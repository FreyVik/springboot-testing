package com.freyvik.springboot_testing.rest.app.usuario.repository;

import com.freyvik.springboot_testing.rest.app.usuario.models.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressTypeRepository extends JpaRepository<AddressType, Long> {

    Optional<AddressType> findByType(String type);
}
