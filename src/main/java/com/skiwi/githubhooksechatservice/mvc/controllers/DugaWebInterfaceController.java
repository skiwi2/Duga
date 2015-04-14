package com.skiwi.githubhooksechatservice.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


/**
 * @author Frank van Heeswijk
 */
@Controller
@RequestMapping("/dwi")
public class DugaWebInterfaceController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(final Principal principal) {
        ModelAndView modelAndView = new ModelAndView("dwi/index");
        modelAndView.addObject("username", principal.getName());
        return modelAndView;
    }
}
