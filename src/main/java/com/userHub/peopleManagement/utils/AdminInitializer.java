package com.userHub.peopleManagement.utils;

import com.userHub.peopleManagement.dao.AdminRepository;
import com.userHub.peopleManagement.model.Administrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AdminInitializer.class);
    private static final String DEFAULT_ADMIN_USERNAME = "admin";
    private static final String DEFAULT_ADMIN_PASSWORD = "admin123";

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
            logger.error("Falha ao inicializar conta de administrador", e);
        }
    }

    private void initializeAdminAccount() {
        if (!adminRepository.existsByUserName(DEFAULT_ADMIN_USERNAME)) {
            Administrator admin = new Administrator();
            admin.setUserName(DEFAULT_ADMIN_USERNAME);
            admin.setPassword(passwordEncoder.encode(DEFAULT_ADMIN_PASSWORD));
            admin.setRole(Role.ADMIN);

            adminRepository.save(admin);
            logger.info("Conta de administrador criada com sucesso");
        }
    }

}