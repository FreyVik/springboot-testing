package com.freyvik.springboot_testing.rest.app.usuario.respository;

import static org.junit.jupiter.api.Assertions.*;

import com.freyvik.springboot_testing.rest.app.usuario.models.Address;
import com.freyvik.springboot_testing.rest.app.usuario.repository.AddressRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AddressRepositoryShould {

    @Autowired
    AddressRepository addressRepository;

    @Test
    public void instance_address() {
        Address address = addressRepository.findById(1L).orElseThrow();
        assertNotNull(address);
        assertEquals("Invented", address.getName());
    }
}
