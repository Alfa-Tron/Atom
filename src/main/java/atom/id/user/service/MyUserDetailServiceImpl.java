package atom.id.user.service;

import atom.id.security.MyUserDetails;
import atom.id.user.model.UserLog;
import atom.id.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserLog> user = userRepository.findByName(username);
        return user.map(MyUserDetails::new).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }

    public String addUser(String name, String password) {
        UserLog user = new UserLog();
        user.setName(name);
        user.setPassword(passwordEncoder.encode(password));
        if (name.equals("admin") && password.equals("admin"))
            user.setRoles("ROLE_ADMIN, ROLE_USER");
        else {
            user.setRoles("ROLE_USER");
        }
        if (name.isBlank()) {
            return "registrationWrongName";
        }
        if (userRepository.existsByName(name)) {
            return "registrationEx";
        } else {
            userRepository.save(user);
            return "hello";
        }
    }
}
