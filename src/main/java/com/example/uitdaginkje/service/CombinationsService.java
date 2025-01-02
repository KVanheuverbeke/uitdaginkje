package com.example.uitdaginkje.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CombinationsService {

    public List<String> getCombinations(List<String> input, int combinationLength) {
        Set<String> wordsToCombine = new HashSet<>(getWordsOfLength(input, combinationLength));
        Set<String> output = new HashSet<>();

        input.forEach(word1 -> input.forEach(word2 -> {
            String combination = word1 + word2;
            if (wordsToCombine.contains(combination)) {
                output.add(word1 + "+" + word2 + "=" + combination);
            }
        }));


        return new ArrayList<>(output);
    }

    private List<String> getWordsOfLength(List<String> input, int combinationLength) {
        return input.stream().collect(Collectors.groupingBy(String::length)).get(combinationLength);
    }
}
