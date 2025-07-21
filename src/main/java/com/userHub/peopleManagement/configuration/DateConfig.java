package com.userHub.peopleManagement.configuration;

import io.micrometer.common.util.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Objects;

@Configuration
public class DateConfig {

    @Bean
    public Formatter<LocalDate> localDateFormatter() {
        return new Formatter<>() {
            private static final String DATE_FORMATED = "dd/MM/yyyy";
            private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATED);

            @Override
            public LocalDate parse(String text, Locale locale) {
                if (StringUtils.isBlank(text)) {
                    return null;
                }
                try {
                    return LocalDate.parse(text, formatter);
                } catch (DateTimeParseException e) {
                    throw new IllegalArgumentException("Invalid Date. Use Formated dd/MM/yyyy", e);
                }
            }

            @Override
            public String print(LocalDate date, Locale locale) {
                return formatter.format(Objects.requireNonNull(date));
            }
        };
    }
}
