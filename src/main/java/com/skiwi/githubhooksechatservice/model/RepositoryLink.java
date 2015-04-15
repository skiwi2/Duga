package com.skiwi.githubhooksechatservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Frank van Heeswijk
 */
@Entity
@Table(name = "repository_links")
public class RepositoryLink {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    @JoinTable(name = "repository_links_github_repositories",
        joinColumns = {@JoinColumn(name = "github_repository_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "repository_link_id", referencedColumnName = "id")})
    private GithubRepository githubRepository;

    @OneToMany
    @JoinTable(name = "repository_links_duga_users",
        joinColumns = {@JoinColumn(name = "duga_user_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "repository_link_id", referencedColumnName = "id")})
    private List<DugaUser> dugaUsers = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public GithubRepository getGithubRepository() {
        return githubRepository;
    }

    public void setGithubRepository(final GithubRepository githubRepository) {
        this.githubRepository = githubRepository;
    }

    public List<DugaUser> getDugaUsers() {
        return dugaUsers;
    }

    public void setDugaUsers(final List<DugaUser> dugaUsers) {
        this.dugaUsers = dugaUsers;
    }
}
