package com.zavier.demo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zavier.demo.entity.User;
import com.zavier.demo.repository.UserRepository;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index(@Valid User user, Errors errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            attributes.addFlashAttribute("message", "请求参数错误");
            return "redirect:/";
        }
        userRepository.save(user);
        return "index";
    }
}
