package gritlab.letsplay.seeder;

import gritlab.letsplay.model.User;
import gritlab.letsplay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserSeeder(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        seedAdminData();
    }

    private void seedAdminData() {
        if (userRepository.findByEmail("admin@example.com") == null) {
            String encodedPassword = passwordEncoder.encode("Admin12345!");
            User adminUser = new User("admin","admin@example.com",encodedPassword,"ADMIN");
            userRepository.save(adminUser);
        }

    }
}
