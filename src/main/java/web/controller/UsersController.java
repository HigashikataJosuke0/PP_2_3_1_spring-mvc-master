package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/allusers")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("allusers", userService.getAll());
        return "allusers";
    }
   @GetMapping("/addnewuser")
    public String addNewUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "/addnewuser";
    }
    @PostMapping ("saveUser")
    public String saveUser(ModelMap modelMap, @Valid User user, BindingResult bindingResult) {

        if(bindingResult.hasErrors())
        {
            modelMap.addAttribute(user);
            return "redirect:/allusers";
        }

        userService.save(user);

        return "redirect:/allusers";
    }

    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam("usrId") long id, ModelMap model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "/addnewuser";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("usrId") long id ){
        userService.removeById(id);
        return "redirect:/allusers";
    }
}
