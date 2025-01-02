package com.example.uitdaginkje.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CombinationsServiceTest {

    @InjectMocks
    private CombinationsService combinationsService;

    @Test
    void getCombinations() {
        List<String> input = List.of("foo", "bar", "fo", "obar", "foobar", "foo", "foobar");
        List<String> result = combinationsService.getCombinations(input, 6);
        System.err.println(result);
        assertTrue(result.contains("foo+bar=foobar"));
        assertTrue(result.contains("fo+obar=foobar"));
        assertEquals(2, result.size());
    }
}