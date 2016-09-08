package com.zavier.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zavier.demo.entity.User;
import com.zavier.demo.repository.UserRepository;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        User user = new User();
        user.setUsername("zheng");
        user.setPassword("admin");
        userRepository.save(user);
        return "index";
    }
}
