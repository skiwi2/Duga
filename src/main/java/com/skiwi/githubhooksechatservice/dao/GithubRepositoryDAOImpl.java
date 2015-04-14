package com.skiwi.githubhooksechatservice.dao;

import com.skiwi.githubhooksechatservice.model.GithubRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Frank van Heeswijk
 */
@Repository
public class GithubRepositoryDAOImpl implements GithubRepositoryDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public GithubRepository getRepository(final String owner, final String name) {
        Query query = openSession().createQuery("from GithubRepository repo where repo.owner = :owner and repo.name = :name");
        query.setParameter("owner", owner);
        query.setParameter("name", name);
        GithubRepository githubRepository = (GithubRepository)query.uniqueResult();
        if (githubRepository == null) {
            throw new IllegalArgumentException("No GithubRepository exists for owner = " + owner + " and name = " + name);
        }
        return githubRepository;
    }

    @Override
    public GithubRepository getRepository(final String url) {
        Query query = openSession().createQuery("from GithubRepository repo where repo.url = :url");
        query.setParameter("url", url);
        GithubRepository githubRepository = (GithubRepository)query.uniqueResult();
        if (githubRepository == null) {
            throw new IllegalArgumentException("No GithubRepository exists for url = " + url);
        }
        return githubRepository;
    }

    @Override
    public GithubRepository createRepository(final String owner, final String name, final String url) {
        GithubRepository githubRepository = new GithubRepository();
        githubRepository.setOwner(owner);
        githubRepository.setName(name);
        githubRepository.setUrl(url);
        openSession().persist(githubRepository);
        return githubRepository;
    }

    @Override
    public void updateRepository(final GithubRepository githubRepository) {
        openSession().update(githubRepository);
    }
}
