package ImageHoster.controller;

import ImageHoster.model.User;
import ImageHoster.model.UserProfile;
import ImageHoster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //This controller method is called when the request pattern is of type 'users/registration'
    @RequestMapping("users/registration")
    public String registration(Model model) {
        //Complete this method
        //Observe User and UserProfile models implemented
        //Declare an object of User class and UserProfile class
        //Set the profile of the user as UserProfile type object
        //Add user in the model and return 'users/registration.html'

        User user=new User();
        UserProfile userProfile=new UserProfile();

        user.setProfile(userProfile);

        model.addAttribute("User",user);

        return "users/registration";
    }

    //This controller method is called when the request pattern is of type 'users/registration' and also the incoming request is of POST type
    @RequestMapping(value = "users/registration", method = RequestMethod.POST)
    public String registerUser(User user) {
        //Complete this method
        //Call the business logic which currently does not store the details of the user in the database
        //After registration, again redirect to the registration page

        userService.registerUser(user);

        return "users/registration";
    }
}
