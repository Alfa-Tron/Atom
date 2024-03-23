package atom.id.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping
    public void login(@RequestParam String username, @RequestParam String password) {
        System.out.println(12);
    }
}
