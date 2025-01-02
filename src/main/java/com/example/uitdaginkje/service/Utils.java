package com.example.uitdaginkje.service;

import com.example.uitdaginkje.dao.Output;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private Utils() {
    }

    /**
     * change String to Output to store it in database
     *
     * @param input List of strings
     * @return List of output to put in DB
     */
    public static List<Output> toOutput(List<String> input) {
        List<Output> output = new ArrayList<>();
        input.forEach(s -> output.add(new Output(s)));
        return output;
    }

}
