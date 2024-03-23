package atom.id.user;


import atom.id.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

   /* @GetMapping("/login")
    public String login(){
        return "login";
   }

    @PostMapping("/login")
    public void login(@RequestParam String username, @RequestParam String password) {
        System.out.println(12);
    }
    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registration";
    }
*/
  /*  @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        System.out.println("12");
        return "redirect:/login"; // Перенаправляем пользователя на страницу входа после регистрации
    }*/
}
