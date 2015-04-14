package com.skiwi.githubhooksechatservice.service;

import com.skiwi.githubhooksechatservice.dao.GithubRepositoryDAO;
import com.skiwi.githubhooksechatservice.model.GithubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Frank van Heeswijk
 */
@Service
@Transactional
public class GithubRepositoryServiceImpl implements GithubRepositoryService {
    @Autowired
    private GithubRepositoryDAO githubRepositoryDAO;

    @Override
    public GithubRepository getRepository(final String owner, final String name) {
        return githubRepositoryDAO.getRepository(owner, name);
    }

    @Override
    public GithubRepository getRepository(final String url) {
        return githubRepositoryDAO.getRepository(url);
    }

    @Override
    public GithubRepository createRepository(final String owner, final String name, final String url) {
        return githubRepositoryDAO.createRepository(owner, name, url);
    }

    @Override
    public void updateRepository(final GithubRepository githubRepository) {
        githubRepositoryDAO.updateRepository(githubRepository);
    }
}
