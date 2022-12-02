package com.freyvik.springboot_testing.rest.app.usuario.repository;

import com.freyvik.springboot_testing.rest.app.usuario.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
    List<User> findAll();
}
