package com.freyvik.springboot_testing.rest.app.usuario.respository;

import static org.junit.jupiter.api.Assertions.*;

import com.freyvik.springboot_testing.rest.app.usuario.models.AddressType;
import com.freyvik.springboot_testing.rest.app.usuario.repository.AddressTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AddresTypeRepositoryShould {
    @Autowired
    AddressTypeRepository addressTypeRepository;

    @Test
    void return_type_calle() {
        AddressType addressType = addressTypeRepository.findByType("calle").orElseThrow();
        assertNotNull(addressType);
    }
}
