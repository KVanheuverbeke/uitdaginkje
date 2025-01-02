package com.example.uitdaginkje;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UitdaginkjeApplicationTests {

    @Test
    void contextLoads() {
        // Verify if the application context loads successfully
        assertNotNull(this);
    }

}