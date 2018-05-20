package com.codegym.file.controller;

import com.codegym.file.model.User;
import com.codegym.file.model.UserForm;
import com.codegym.file.service.UserService;
import com.codegym.file.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/create-user")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("userForm", new UserForm());
        return modelAndView;
    }

    @PostMapping("/create-user")
    public ModelAndView saveUser(@ModelAttribute("user") UserForm userForm){
        ModelAndView modelAndView = new ModelAndView("create");
        try {
            String originFileName = userForm.getAvatar().getOriginalFilename();
            String randomName = FileUtils.generateRandomName() + FileUtils.getExtension(originFileName);

            userForm.getAvatar().transferTo(new File(FileUtils.UPLOAD_LOCATION + randomName));

            User userEntity = new User();
            userEntity.setName(userForm.getName());
            userEntity.setOriginAvatarName(originFileName);
            userEntity.setAvatar(randomName);
            userService.save(userEntity);
            modelAndView.addObject("message", "User created successfully");
        } catch (IOException e) {
            modelAndView.addObject("message", "Error saving user avatar");
            e.printStackTrace();
        }
        modelAndView.addObject("userForm", new UserForm());
        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView showUsers(){
        List<User> users = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}
