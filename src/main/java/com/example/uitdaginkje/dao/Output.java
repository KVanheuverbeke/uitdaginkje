package com.example.uitdaginkje.dao;

import jakarta.persistence.*;

@Entity
@Table(name="output")
public class Output {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "output")
    private String output;

    public Output(String output) {
        this.output = output;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
