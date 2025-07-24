package com.userHub.peopleManagement.service.impl;

import com.userHub.peopleManagement.dao.AdminRepository;
import com.userHub.peopleManagement.model.Administrator;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminUserDetailsService implements UserDetailsService {

    private final AdminRepository adminUserRepository;

    public AdminUserDetailsService(AdminRepository adminUserRepository) {
        this.adminUserRepository = adminUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator adminUser = adminUserRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(adminUser.getUserName())
                .password(adminUser.getPassword())
                .roles(adminUser.getRole().name())
                .build();
    }
}