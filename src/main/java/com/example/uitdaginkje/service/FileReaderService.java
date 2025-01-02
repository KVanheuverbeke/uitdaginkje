package com.example.uitdaginkje.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FileReaderService {

    private FileReaderService() {
    }

    public static List<String> readFile(MultipartFile file)  {
        try {
            return new BufferedReader(new InputStreamReader(file.getInputStream())).lines().map(String::trim).filter(line -> !line.isEmpty()).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}