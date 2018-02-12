package ru.itpark.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class RegistrationController {


  @GetMapping("/signIn")
  public String getSignInPage(@ModelAttribute("model") ModelMap model,
                              @RequestParam(value = "error", required = false) String error) {
    if (error != null) {
      model.addAttribute("error", true);
    }
    return "signIn";
  }
}
