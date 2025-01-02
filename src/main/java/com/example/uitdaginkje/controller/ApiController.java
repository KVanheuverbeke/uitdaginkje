package com.example.uitdaginkje.controller;

import com.example.uitdaginkje.service.CombinationsService;
import com.example.uitdaginkje.service.FileReaderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {
    private final CombinationsService combinationsService;

    public ApiController(CombinationsService combinationsService) {
        this.combinationsService = combinationsService;

    }

    @PostMapping(path = "/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<String> getCombinations(@RequestParam("file") MultipartFile inputFile, @RequestParam(defaultValue = "6") int combinationLength) {
        List<String> list = combinationsService.getCombinations(FileReaderService.readFile(inputFile), combinationLength);
        return list;
    }
}