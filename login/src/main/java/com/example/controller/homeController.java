package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class homeController
{
    @GetMapping("/login")
    public String viewLoginPage() {
        return "redirect:/login.html";  // Serve the static login.html page
    }

    // Handle the login form submission
    @PostMapping("/login")
    public String handleLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);


        if ("admin".equals(username) && "123".equals(password)) {

            return "redirect:/welcome";  // Redirect to a welcome page on successful login
        } else {
            return "redirect:/login";
        }
    }

    // Example welcome page after successful login
    @GetMapping("/welcome")
    public String welcomePage() {
        return "redirect:/welcome.html";  // Ensure a static welcome page is created in /static
    }

    @GetMapping("/signOut")
    public String singOut() {
        return "redirect:/login";
    }

}
