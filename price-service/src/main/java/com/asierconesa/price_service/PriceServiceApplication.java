package com.asierconesa.price_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que arranca la aplicación Spring Boot.
 */
@SpringBootApplication
public class PriceServiceApplication {

    /**
     * Método principal.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(final String[] args) {
        SpringApplication.run(PriceServiceApplication.class, args);
    }

}
