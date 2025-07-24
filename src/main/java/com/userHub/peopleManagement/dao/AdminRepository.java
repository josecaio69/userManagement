package com.userHub.peopleManagement.dao;

import com.userHub.peopleManagement.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Administrator, UID> {
    Optional<Administrator> findByUserName(String userName);
    boolean existsByUserName(String userName);
}
