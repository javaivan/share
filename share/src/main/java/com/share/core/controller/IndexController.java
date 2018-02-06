package com.share.core.controller;

import com.share.core.model.User;
//import com.share.repository.SequenceDao;
//import com.share.repository.SequenceDaoImpl;
import com.share.core.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;
/*
    @Autowired
    private SequenceDao sequenceDao;
*/
    private Log log = LogFactory.getLog(this.getClass());

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public ModelAndView index() {
        /*Long random = new Random().nextLong();
        User user = new User("sdf" + random.toString());
        user.setUserId(Long.parseLong(sequenceDao.getNextSequenceId("user").toString()));
        userRepository.save(user);*/

        return new ModelAndView("index");
    }

    @RequestMapping(value = "/home", method=RequestMethod.GET)
    public String home() {
        List<User> users = userRepository.findAll();
        users.toString();
        return "site.homepage";
    }

    @RequestMapping(value = "/greet", method=RequestMethod.GET)
    public ModelAndView greet(@RequestParam(value = "name", required=false, defaultValue="World!")final String name, final Model model) {
        log.info("Controller has been invoked with Request Parameter name = '" + name + "'.");
        return new ModelAndView("site.greeting", "name", name);
    }

    @RequestMapping(value = "/greet/{name}", method=RequestMethod.GET)
    public ModelAndView greetTwoWays(@PathVariable(value="name") final String name, final Model model) {
        log.info("Controller has been invoked with Path Variable name = '" + name + "'.");
        return new ModelAndView("site.greeting", "name", name);
    }
}
