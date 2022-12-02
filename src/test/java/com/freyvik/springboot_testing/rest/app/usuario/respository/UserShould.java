package com.freyvik.springboot_testing.rest.app.usuario.respository;

import static org.junit.jupiter.api.Assertions.*;

import com.freyvik.springboot_testing.rest.app.usuario.models.Address;
import com.freyvik.springboot_testing.rest.app.usuario.models.User;
import com.freyvik.springboot_testing.rest.app.usuario.repository.AddressRepository;
import com.freyvik.springboot_testing.rest.app.usuario.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class UserShould {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    private User savedUser;

    @BeforeEach
    void setUp() {
        Address address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getName());

        User newUser = User.builder()
                .name("Frey2")
                .address(address)
                .build();
        User savedUser = userRepository.save(newUser);
        System.out.println(savedUser.getName());
    }

    @Test
    public void intance_user() {
        User user = userRepository.findById(1L).orElseThrow();
        assertNotNull(user);
        assertEquals("FreyVik", user.getName());
    }

    @Test
    public void list_all_users() {
        List<User> usersList = userRepository.findAll();
        assertNotNull(usersList);

        for (User user : usersList) {
            System.out.println("User: " + user.getId() + "- " + user.getName());
        }
    }
}
