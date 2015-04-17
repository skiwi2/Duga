package com.skiwi.githubhooksechatservice.mvc.controllers;

import com.skiwi.githubhooksechatservice.model.DugaUser;
import com.skiwi.githubhooksechatservice.model.GithubRepository;
import com.skiwi.githubhooksechatservice.model.RepositoryLink;
import com.skiwi.githubhooksechatservice.service.GithubRepositoryService;
import com.skiwi.githubhooksechatservice.service.RepositoryLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


/**
 * @author Frank van Heeswijk
 */
@Controller
@RequestMapping("/dwi")
public class DugaWebInterfaceController {
    @Autowired
    private GithubRepositoryService githubRepositoryService;

    @Autowired
    private RepositoryLinkService repositoryLinkService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(final Principal principal) {
        ModelAndView modelAndView = new ModelAndView("dwi/index");
        modelAndView.addObject("username", principal.getName());
        modelAndView.addObject("repositoryLinks", repositoryLinkService.getRepositoryLinks());
        return modelAndView;
    }

    @RequestMapping(value = "/link_repository", method = RequestMethod.GET)
    public String linkRepository() {
        return "dwi/link_repository";
    }

    @RequestMapping(value = "/link_repository", method = RequestMethod.POST)
    public String postLinkRepository(@RequestParam("github_repository_owner") final String githubRepositoryOwner, @RequestParam("github_repository_name") final String githubRepositoryName, @RequestParam("github_repository_url") final String githubRepositoryUrl) {
        repositoryLinkService.createRepositoryLink(githubRepositoryOwner, githubRepositoryName, githubRepositoryUrl);
        return "dwi/index";
    }

    @RequestMapping(value = "/repository_link/{owner}/{name}", method = RequestMethod.GET)
    public ModelAndView repositoryLink(@PathVariable("owner") final String owner, @PathVariable("name") final String name) {
        ModelAndView modelAndView = new ModelAndView("dwi/repository_link");
        RepositoryLink repositoryLink = repositoryLinkService.getRepositoryLink(owner, name);
        modelAndView.addObject("repositoryLink", repositoryLink);
        return modelAndView;
    }

    @RequestMapping(value = "/repository_link/{owner}/{name}/fragment/github_repository/normal", method = RequestMethod.GET)
         public ModelAndView repositoryLinkFragmentGithubRepositoryNormal(@PathVariable("owner") final String owner, @PathVariable("name") final String name) {
        ModelAndView modelAndView = new ModelAndView("dwi/repository_link_fragment_github_repository_normal");
        GithubRepository githubRepository = githubRepositoryService.getRepository(owner, name);
        modelAndView.addObject("githubRepository", githubRepository);
        return modelAndView;
    }

    @RequestMapping(value = "/repository_link/{owner}/{name}/fragment/github_repository/edit", method = RequestMethod.GET)
    public ModelAndView repositoryLinkFragmentGithubRepositoryEdit(@PathVariable("owner") final String owner, @PathVariable("name") final String name) {
        ModelAndView modelAndView = new ModelAndView("dwi/repository_link_fragment_github_repository_edit");
        GithubRepository githubRepository = githubRepositoryService.getRepository(owner, name);
        modelAndView.addObject("githubRepository", githubRepository);
        return modelAndView;
    }

    @RequestMapping(value = "/repository_link/{owner}/{name}/fragment/github_repository/edit", method = RequestMethod.POST)
    public ModelAndView postRepositoryLinkFragmentGithubRepositoryEdit(@PathVariable("owner") final String owner, @PathVariable("name") final String name, @RequestParam("github_repository_owner") final String githubRepositoryOwner, @RequestParam("github_repository_name") final String githubRepositoryName, @RequestParam("github_repository_url") final String githubRepositoryUrl) {
        GithubRepository githubRepository = githubRepositoryService.getRepository(owner, name);
        githubRepository.setOwner(githubRepositoryOwner);
        githubRepository.setName(githubRepositoryName);
        githubRepository.setUrl(githubRepositoryUrl);
        githubRepositoryService.updateRepository(githubRepository);

        ModelAndView modelAndView = new ModelAndView("dwi/repository_link_fragment_github_repository_normal");
        modelAndView.addObject("githubRepository", githubRepository);
        return modelAndView;
    }

    @RequestMapping(value = "/repository_link/{owner}/{name}/fragment/users/normal", method = RequestMethod.GET)
    public ModelAndView repositoryLinkFragmentUsers(@PathVariable("owner") final String owner, @PathVariable("name") final String name) {
        ModelAndView modelAndView = new ModelAndView("dwi/repository_link_fragment_users_normal");
        RepositoryLink repositoryLink = repositoryLinkService.getRepositoryLink(owner, name);
        modelAndView.addObject("repositoryLink", repositoryLink);
        modelAndView.addObject("dugaUsers", repositoryLink.getDugaUsers());
        return modelAndView;
    }

    @RequestMapping(value = "/repository_link/{owner}/{name}/fragment/add_user/normal", method = RequestMethod.GET)
    public String repositoryLinkFragmentAddUserNormal(@PathVariable("owner") final String owner, @PathVariable("name") final String name) {
        return "dwi/repository_link_fragment_add_user_normal";
    }

    @RequestMapping(value = "/repository_link/{owner}/{name}/fragment/add_user/edit", method = RequestMethod.GET)
    public String repositoryLinkFragmentAddUserEdit(@PathVariable("owner") final String owner, @PathVariable("name") final String name) {
        return "dwi/repository_link_fragment_add_user_edit";
    }

    @RequestMapping(value = "/repository_link/{owner}/{name}/fragment/add_user/edit", method = RequestMethod.POST)
    public String postRepositoryLinkFragmentAddUserEdit(@PathVariable("owner") final String owner, @PathVariable("name") final String name, @RequestParam("username") final String username) {
        //TODO actually add user

        return "dwi/repository_link_fragment_add_user_normal";
    }
}
