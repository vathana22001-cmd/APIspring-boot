package kh.edu.istad.restfulapi.init;

import jakarta.annotation.PostConstruct;
import kh.edu.istad.restfulapi.model.User;
import kh.edu.istad.restfulapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitialization {

    private final UserRepository userRepository;

    @PostConstruct
    void init() {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setFullName("Administrator");
            user.setUsername("admin");
            user.setPassword("qwer");
            user.setIsActive(true);

            User user2 = new User();
            user2.setFullName("Editor");
            user2.setUsername("editor");
            user2.setPassword("qwer");
            user2.setIsActive(true);

            User user3 = new User();
            user3.setFullName("Lomchhina Vathana");
            user3.setUsername("Vathana");
            user3.setPassword("qwer");
            user3.setIsActive(false);

            userRepository.save(user);
            userRepository.save(user2);
            userRepository.save(user3);
        }
    }
}