package com.practise.new_user_details.repository;

import com.practise.new_user_details.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class TestUserRepository {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    TestEntityManager entityManager;

User user;
    @BeforeEach
    public void setUp() {
         user = new User();
        user.setName("Rakesh");
        user.setId("1");

    }
    @Test
    public void whenFindByUsername_thenReturnUser() {
        // given
        userRepository.save(user);
        String username = "Rakesh";
        String email = "testuser@example.com";

        // when
        Optional<User> found = userRepository.findById("1");

        // then
        // AssertJ kütüphanesi methodu
        Assert.assertEquals(found.get().getName(),username);
    }

}
