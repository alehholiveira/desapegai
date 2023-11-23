package br.com.api.desapegai.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.api.desapegai.Model.Ad;
import br.com.api.desapegai.Model.User;
import br.com.api.desapegai.Service.AdService;
import br.com.api.desapegai.Service.UserService;
import jakarta.validation.Valid;


import java.util.List;

@Controller
public class AuthController {
    private UserService userService;
    private AdService adService;

    public AuthController(UserService userService, AdService adService) {
        this.userService = userService;
        this.adService = adService;
    }

    // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/login-success")
    public String loginSuccess() {
        return "redirect:";
    }


    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") User user,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(user.getEmail());
        
        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "Já existe uma conta com esse email");
                    
        }

        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "/register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    // handler method to handle list of users
    
    
    @GetMapping("/users")
    public String users(Model model){
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

        // handler method to handle home page request
    @GetMapping("/")
    public String home(Model model){
        List<Ad> ads = adService.getAllAds();
        model.addAttribute("ads", ads);
        return "index";
    }


    
}
