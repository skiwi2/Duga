package com.skiwi.githubhooksechatservice.service;

import com.skiwi.githubhooksechatservice.model.DugaUser;
import com.skiwi.githubhooksechatservice.model.RepositoryLink;

import java.util.List;

/**
 * @author Frank van Heeswijk
 */
public interface RepositoryLinkService {
    RepositoryLink getRepositoryLink(final Integer id);

    RepositoryLink getRepositoryLink(final String repositoryOwner, final String repositoryName);

    List<RepositoryLink> getRepositoryLinks();

    List<RepositoryLink> getRepositoryLinks(final String repositoryOwner);

    RepositoryLink createRepositoryLink(final String repositoryOwner, final String repositoryName, final String repositoryUrl);

    RepositoryLink createRepositoryLink(final String repositoryOwner, final String repositoryName, final String repositoryUrl, final DugaUser dugaUser);

    void updateRepositoryLink(final RepositoryLink repositoryLink);

    void deleteRepositoryLink(final RepositoryLink repositoryLink);
}
