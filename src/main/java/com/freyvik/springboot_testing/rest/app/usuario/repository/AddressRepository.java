package com.freyvik.springboot_testing.rest.app.usuario.repository;

import com.freyvik.springboot_testing.rest.app.usuario.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findById(Long id);
}
