package com.userHub.peopleManagement.utils;

import com.userHub.peopleManagement.dao.AdminRepository;
import com.userHub.peopleManagement.model.Administrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminInitializer implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AdminInitializer.class);

    @Value("${spring.user.admin.userName}")
    private String defaultUsernameAdmin;
    @Value("${spring.user.admin.password}")
    private String defaultPasswordAdmin;

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminInitializer(AdminRepository adminRepository,
                            PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        try {
            initializeAdminAccount();
        } catch (Exception e) {
            logger.error("Failed to Initialize ADMIN Account.", e);
        }
    }

    private void initializeAdminAccount() {
        if (!getAdminRepository().existsByUserName(getDefaultUsernameAdmin())) {
            Administrator admin = new Administrator();
            admin.setUserName(getDefaultUsernameAdmin());
            admin.setPassword(getPasswordEncoder().encode(getDefaultPasswordAdmin()));
            admin.setRole(Role.ADMIN);

            getAdminRepository().save(admin);
            logger.info("ADMIN account created successfully.");
        }
    }

    public String getDefaultUsernameAdmin() {
        return defaultUsernameAdmin;
    }

    public void setDefaultUsernameAdmin(String defaultUsernameAdmin) {
        this.defaultUsernameAdmin = defaultUsernameAdmin;
    }

    public String getDefaultPasswordAdmin() {
        return defaultPasswordAdmin;
    }

    public void setDefaultPasswordAdmin(String defaultPasswordAdmin) {
        this.defaultPasswordAdmin = defaultPasswordAdmin;
    }

    public AdminRepository getAdminRepository() {
        return adminRepository;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}