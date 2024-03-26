package atom.id.user;


import atom.id.user.service.MyUserDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final MyUserDetailServiceImpl userService;

    @GetMapping("/register")
    public String register() {
        return "registration";
    }

    @GetMapping
    public String f() {
        return "hello";
    }

    @PostMapping("/register")
    public String registrationUser(@RequestParam String username, @RequestParam String password) {
        return userService.addUser(username, password);
    }

}
