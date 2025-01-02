package com.example.uitdaginkje.controller;

import com.example.uitdaginkje.dao.OutputRepository;
import com.example.uitdaginkje.service.CombinationsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ApiControllerTest {

    @Mock
    private CombinationsService combinationsService;

    @Mock
    private OutputRepository outputRepository;

    @InjectMocks
    private ApiController apiController;

    public ApiControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCombinations_successfulFileUpload() {
        // Arrange
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "test.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "test data".getBytes()
        );
        when(combinationsService.getCombinations(any(), eq(6))).thenReturn(List.of("AB", "BC", "CD"));

        // Act
        List<String> result = apiController.getCombinations(mockFile, 6);

        // Assert
        assertEquals(3, result.size());
        verify(outputRepository).saveAll(any());
    }

    @Test
    void getCombinations_missingFileInput() {
        // Arrange
        MockMultipartFile mockFile = new MockMultipartFile(
                "file",
                "",
                MediaType.TEXT_PLAIN_VALUE,
                new byte[0]
        );

        // Act and Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> apiController.getCombinations(mockFile, 6));

        assertEquals("File is empty", exception.getMessage());
        verifyNoInteractions(outputRepository);
    }

}