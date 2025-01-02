package com.example.uitdaginkje.controller;

import com.example.uitdaginkje.dao.OutputRepository;
import com.example.uitdaginkje.service.CombinationsService;
import com.example.uitdaginkje.service.FileReaderService;
import com.example.uitdaginkje.service.Utils;
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
    private final OutputRepository outputRepository;

    public ApiController(CombinationsService combinationsService, OutputRepository outputRepository) {
        this.combinationsService = combinationsService;
        this.outputRepository = outputRepository;
    }

    @PostMapping(path = "/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<String> getCombinations(@RequestParam("file") MultipartFile inputFile, @RequestParam(defaultValue = "6") int combinationLength) {
        //check if file is empty
        if (inputFile.isEmpty() || inputFile.getSize() == 0) {
            throw new IllegalArgumentException("File is empty");
        }

        List<String> list = combinationsService.getCombinations(FileReaderService.readFile(inputFile), combinationLength);
        outputRepository.saveAll(Utils.toOutput(list));

        return list;
    }
}