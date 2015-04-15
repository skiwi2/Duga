package com.skiwi.githubhooksechatservice.mvc.controllers;

import com.skiwi.githubhooksechatservice.service.RepositoryLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
