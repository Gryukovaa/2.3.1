package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

   private UserService userService;

   @Autowired
   public UserController(UserService userService) {
        this.userService = userService;
   }

    @GetMapping("")
    public String getUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        System.out.println(users.toString());
        model.addAttribute("listUsers", users);
        return "users";
    }

   // CREATE
   @PostMapping(value = "/create")
   public String createUser(@ModelAttribute User user) {
       userService.addUser(user);
       return "redirect:/users";
   }

    @GetMapping( "/save")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "save";
    }

    // READ
    @GetMapping(value = "/{id}")
    public String getUser(@PathVariable("id") Long id, ModelMap model){
        User user = userService.getUser(id);
        model.addAttribute("key", user);
        return "profile";
    }

    // UPDATE
    @GetMapping(value = "/edit/{id}")
    public String getForEditUser(@PathVariable("id") Long id, ModelMap model) {
        User user = userService.getUser(id);
        model.addAttribute("editedUser",user);
        return "edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String editUser(@PathVariable("id") Long id, @ModelAttribute("user") User user){
        userService.updateUser(id, user);
       return "redirect:/users";
    }

    // DELETE
    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(userService.getUser(id));
        return "redirect:/users";
    }















}
