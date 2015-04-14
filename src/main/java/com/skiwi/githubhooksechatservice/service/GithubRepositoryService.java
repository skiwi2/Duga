package com.skiwi.githubhooksechatservice.service;

import com.skiwi.githubhooksechatservice.model.GithubRepository;

/**
 * @author Frank van Heeswijk
 */
public interface GithubRepositoryService {
    GithubRepository getRepository(final String owner, final String name);

    GithubRepository getRepository(final String url);

    GithubRepository createRepository(final String owner, final String name, final String url);

    void updateRepository(final GithubRepository githubRepository);
}
