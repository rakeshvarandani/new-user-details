package com.practise.new_user_details.service;

import com.practise.new_user_details.Service.UserDetailsService;
import com.practise.new_user_details.model.User;
import com.practise.new_user_details.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserDetailsServiceTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    UserDetailsService userDetailsService;



    @Test
    public void testgetAllUsers() {

        User user = new User();
        user.setName("Rakesh");
        user.setId("1");

        List<User> testData = new ArrayList<>();
        testData.add(user);

        when(userRepository.findAll()).thenReturn(testData);

        List<User> result = userDetailsService.findAllUsers();

        Assert.assertNotNull(result);

    }

    @Test
    public void testgetUserById() {

        User user = new User();
        user.setName("Rakesh");
        user.setId("1");

        List<User> testData = new ArrayList<>();
        testData.add(user);

        when(userRepository.findById(anyString())).thenReturn(Optional.of(user));

    Optional<User> result = userDetailsService.getUserById("1");

        Assert.assertNotNull(result);

    }
}
