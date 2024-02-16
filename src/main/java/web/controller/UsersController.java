package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/addNewUser")
    public String addNewUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "/addNewUser";
    }

    @GetMapping(value = "/allusers")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("allUsers", userService.getAll().stream().toList());
        return "/allusers";
    }

    @RequestMapping("saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/allusers";
    }

    @RequestMapping("/updateIndo")
    public String updateUser(@RequestParam("empId") int id, ModelMap model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "addNewUser";
    }
}
