package com.skiwi.githubhooksechatservice.service;

import com.skiwi.githubhooksechatservice.dao.RepositoryLinkDAO;
import com.skiwi.githubhooksechatservice.model.DugaUser;
import com.skiwi.githubhooksechatservice.model.RepositoryLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Frank van Heeswijk
 */
@Service
@Transactional
public class RepositoryLinkServiceImpl implements RepositoryLinkService {
    @Autowired
    private RepositoryLinkDAO repositoryLinkDAO;

    @Autowired
    private UserService userService;

    @Override
    public RepositoryLink getRepositoryLink(final Integer id) {
        return repositoryLinkDAO.getRepositoryLink(id);
    }

    @Override
    public RepositoryLink getRepositoryLink(final String repositoryOwner, final String repositoryName) {
        return repositoryLinkDAO.getRepositoryLink(repositoryOwner, repositoryName);
    }

    @Override
    public List<RepositoryLink> getRepositoryLinks() {
        DugaUser currentUser = userService.getAuthenticatedUser();
        return getRepositoryLinks(currentUser);
    }

    @Override
    public List<RepositoryLink> getRepositoryLinks(final String repositoryOwner) {
        return repositoryLinkDAO.getRepositoryLinks(repositoryOwner);
    }

    @Override
    public List<RepositoryLink> getRepositoryLinks(final DugaUser user) {
        return repositoryLinkDAO.getRepositoryLinks(user);
    }

    @Override
    public RepositoryLink createRepositoryLink(final String repositoryOwner, final String repositoryName, final String repositoryUrl) {
        return createRepositoryLink(repositoryOwner, repositoryName, repositoryUrl, userService.getAuthenticatedUser());
    }

    @Override
    public RepositoryLink createRepositoryLink(final String repositoryOwner, final String repositoryName, final String repositoryUrl, final DugaUser dugaUser) {
        return repositoryLinkDAO.createRepositoryLink(repositoryOwner, repositoryName, repositoryUrl, dugaUser);
    }

    @Override
    public void updateRepositoryLink(final RepositoryLink repositoryLink) {
        repositoryLinkDAO.updateRepositoryLink(repositoryLink);
    }

    @Override
    public void deleteRepositoryLink(final RepositoryLink repositoryLink) {
        repositoryLinkDAO.deleteRepositoryLink(repositoryLink);
    }
}
