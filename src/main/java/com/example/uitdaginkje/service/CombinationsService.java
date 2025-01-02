package com.example.uitdaginkje.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationsService {

    public List<String> getCombinations(List<String> input, int combinationLength) {
        List<String> wordsToCombine = getWordsOfLength(input, combinationLength);
        List<String> output = new ArrayList<>();

        input.stream().forEach(word1 -> input.stream().forEach(word2 -> {
            String combination = word1 + word2;
            if (wordsToCombine.contains(combination)) {
                output.add(word1 + "+" + word2 + "=" + combination);
            }
        }));


        return output;
    }

    private List<String> getWordsOfLength(List<String> input, int combinationLength) {
        return input.stream().collect(Collectors.groupingBy(String::length)).get(combinationLength);
    }
}
