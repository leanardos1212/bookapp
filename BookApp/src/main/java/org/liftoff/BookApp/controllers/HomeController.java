package org.liftoff.BookApp.controllers;

import org.liftoff.BookApp.data.BookRepository;
import org.liftoff.BookApp.data.UserRepository;
import org.liftoff.BookApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    BookRepository bookRepository;



    public HomeController() {
    }

    @RequestMapping({""})
    public String index(Model model,HttpServletRequest request) {
        model.addAttribute("title", "Treat Your Shelf!");
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        if (user == null){
            model.addAttribute("loginstatus","");
        }else{
            model.addAttribute("loginstatus",user.getUsername());
        }
        return "index";
    }

    @GetMapping({"userProfile"})
    public String displayUserProfile(Model model, HttpServletRequest request) {
        model.addAttribute("title", "Profile");
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        model.addAttribute("username",user.getUsername());
        model.addAttribute("communication",user.getCommunication());
        return "userProfile/index";
    }





}
