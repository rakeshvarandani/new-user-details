package com.practise.new_user_details.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practise.new_user_details.Service.UserDetailsService;
import com.practise.new_user_details.model.Car;
import com.practise.new_user_details.model.User;
import com.practise.new_user_details.repository.CarRepo;
import com.practise.new_user_details.repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//The @WebMvcTest annotation is used to unit test the Spring MVC components (@Controller,  @ControllerAdvice).
//It disables the full autoconfiguration and only configures the Spring Security and MockMvc.

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @MockBean
    private UserDetailsService userDetailsService;


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testGetAllUsersAPI() throws Exception {

        User user = new User();
        user.setId("1");
        user.setName("testUser");
        List<User> testuserList = new ArrayList<>();
        testuserList.add(user);

        when(userDetailsService.findAllUsers()).thenReturn(testuserList);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/user-details/getAllUsers"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetUsersByIdAPI() throws Exception {

        User user = new User();
        user.setId("1");
        user.setName("testUser");

        when(userDetailsService.getUserById(anyString())).thenReturn(Optional.of(user));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/user-details/getUser/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    public void testSaveUserAPI() throws Exception {

        User user = new User();
        user.setId("1");
        user.setName("testUser");

        when(userDetailsService.saveUser(any(User.class))).thenReturn(user);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user-details/addUser").content(asJsonString(user))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void testSaveCarAPI() throws Exception {

        Car car = new Car();
        car.setCarId("1");
        car.setCarName("Maruti");

        when(userDetailsService.saveCar(any(Car.class))).thenReturn(car);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/user-details/addCar").content(asJsonString(car))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
