package com.skiwi.githubhooksechatservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Frank van Heeswijk
 */
@Entity
@Table(name = "github_repositories", uniqueConstraints = @UniqueConstraint(columnNames = {"owner", "name"}))
public class GithubRepository {
    @Id
    @GeneratedValue
    private Integer id;

    private String owner;

    private String name;

    @Column(name = "url", unique = true)
    private String url;

    public Integer getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }
}
