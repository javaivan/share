package com.share.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mix on 20.03.2016.
 */

@Controller
public class HomeController {
    private static final Logger logger = Logger.getLogger(HomeController.class);
/*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap model){
        logger.debug("HomeController: home");

        model.addAttribute("messege","Home Page");
        return "hello";
    }*/
}
