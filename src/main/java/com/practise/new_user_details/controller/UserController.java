package com.practise.new_user_details.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.practise.new_user_details.Service.UserDetailsService;
import com.practise.new_user_details.model.Car;
import com.practise.new_user_details.model.User;
import com.practise.new_user_details.repository.CarRepo;
import com.practise.new_user_details.repository.UserRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping({"/user-details"})
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CarRepo carRepo;

    public UserController() {
    }


    @GetMapping({"/getUser/{id}"})
    public Optional<User> getByID(@PathVariable String id) {
        return userDetailsService.getUserById(id);
    }

    @GetMapping({"/getAllUsers"})
    public List<User> getAllUsers() {
             return userDetailsService.findALlUsers();
    }

    @PostMapping({"/addUser"})
    public User addUser(@RequestBody User user) {
        return userDetailsService.saveUser(user);
    }

    @PostMapping({"/addCar"})
    public Car addCar(@RequestBody Car car) {
        return userDetailsService.saveCar(car);
    }

//    @GetMapping({"/util"})
//    public void method2() throws JsonProcessingException {
//        this.logger.info("returning 1", "no error happened");
//        User user1 = new User();
//        user1.setId("1");
//        user1.setName("Rakesh");
//        Car balenoCar = new Car();
//        balenoCar.setCarCompany("Maruti");
//        balenoCar.setUser(user1);
//        balenoCar.setCarCompany("A");
//        balenoCar.setPurchaseDate(Date.valueOf(LocalDate.of(2013, 9, 3)));
//        List<Car> rakeshcar = new ArrayList();
//        rakeshcar.add(balenoCar);
//        user1.setCarowned(rakeshcar);
//        ObjectWriter ow = (new ObjectMapper()).writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString(user1);
//        System.out.println(json);
//    }

}

