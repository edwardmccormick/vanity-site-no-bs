package com.codeup.springboot_blog.controllers;

import com.codeup.springboot_blog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private final EmailService emailService;

    public HomeController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/")
    public String hello() {
        return "home";
    }

    @GetMapping("/resume")
    public String resume() { return "resume";}

    @GetMapping("/projects")
    public String projects() { return "projects";}

    @GetMapping("/contact")
    public String contact(Model model) {
    return "contact";}

    @PostMapping("/contact")
    public String contactSend(@RequestParam(name = "email") String email, @RequestParam(name = "name") String name, @RequestParam(name = "source") String source, @RequestParam(name = "bodytext") String body) {
        emailService.prepareAndSend("ted.mccormick@gmail.com","New message from " + name, "Hey Ted, \n You just received a new message on the contact-me form at tedmccormick.dev. The user's email was entered as: " + email + ". They mentioned the source of their visit was: " + source + ". Their message was: \n \n \n'" + body +"'");


    return "thank-you";
    }

    @GetMapping("/test")
    public String renderTest() {
        return "thank-you";
    }

}
