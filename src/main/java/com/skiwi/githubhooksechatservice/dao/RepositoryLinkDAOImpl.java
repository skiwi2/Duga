package com.skiwi.githubhooksechatservice.dao;

import com.skiwi.githubhooksechatservice.model.DugaUser;
import com.skiwi.githubhooksechatservice.model.GithubRepository;
import com.skiwi.githubhooksechatservice.model.RepositoryLink;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Frank van Heeswijk
 */
@Repository
public class RepositoryLinkDAOImpl implements RepositoryLinkDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private GithubRepositoryDAO githubRepositoryDAO;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public RepositoryLink getRepositoryLink(final Integer id) {
        Query query = openSession().createQuery("from RepositoryLink link where link.id = :id");
        query.setParameter("id", id);
        RepositoryLink repositoryLink = (RepositoryLink)query.uniqueResult();
        if (repositoryLink == null) {
            throw new IllegalArgumentException("No RepositoryLink exists for id = " + id);
        }
        return repositoryLink;
    }

    @Override
    public List<RepositoryLink> getRepositoryLinks(final String repositoryOwner) {
        Query query = openSession().createQuery("from RepositoryLink link where link.githubRepository.owner = :owner");
        query.setParameter("owner", repositoryOwner);
        return query.list();
    }

    @Override
    public RepositoryLink createRepositoryLink(final String repositoryOwner, final String repositoryName, final String repositoryUrl, final DugaUser dugaUser) {
        RepositoryLink repositoryLink = new RepositoryLink();
        GithubRepository githubRepository = githubRepositoryDAO.createRepository(repositoryOwner, repositoryName, repositoryUrl);
        repositoryLink.setGithubRepository(githubRepository);
        repositoryLink.getDugaUsers().add(dugaUser);
        openSession().persist(repositoryLink);
        return repositoryLink;
    }

    @Override
    public void updateRepositoryLink(final RepositoryLink repositoryLink) {
        openSession().update(repositoryLink);
    }

    @Override
    public void deleteRepositoryLink(final RepositoryLink repositoryLink) {
        openSession().delete(repositoryLink);
    }
}
