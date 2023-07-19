package com.stackroute.HealthMonitoring;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
//add import
import com.stackroute.HealthMonitoring.model.User;
import com.stackroute.HealthMonitoring.repo.UserRepo;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired 
    private UserRepo repo;
     
    @Test
    public void testCreateUser() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("Wipro@2023");
         
        User newUser = new User("Wipro Limited","wipro@github.com", password);
        User savedUser = repo.save(newUser);
         
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getUserId()).isGreaterThan(0);
    }
    //write test cases User Repository
    @Test
    public void testFindByEmail() {
        String email = "wipro@github.com";
        Optional<User> user = repo.findByEmail(email);
        assertThat(user.get()).isNotNull();
    }
}
