package com.dentist.ProjectDentist.security;


import com.dentist.ProjectDentist.entity.AppUser;
import com.dentist.ProjectDentist.entity.AppUserRole;
import com.dentist.ProjectDentist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {


    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("password2");

        userRepository.save(new AppUser("paula", "pauH", "pau@gmail.com", password, AppUserRole.ADMIN));
        userRepository.save(new AppUser("laura", "lauR", "lau@gmail.com", password2, AppUserRole.USER));


    }
}
