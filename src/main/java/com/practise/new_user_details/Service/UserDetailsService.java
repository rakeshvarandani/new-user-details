package com.practise.new_user_details.Service;

import com.practise.new_user_details.model.Car;
import com.practise.new_user_details.model.User;
import com.practise.new_user_details.repository.CarRepo;
import com.practise.new_user_details.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CarRepo carRepo;


    public Optional<User> getUserById(String userId ){
        return userRepository.findById(userId);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Car saveCar(Car car){
        return carRepo.save(car);
    }

}
