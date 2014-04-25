package org.jbehave.demo.domain;

import org.jbehave.demo.builders.PassengerBuilder;

import java.util.List;

/**
 * Created by ThoughtWorker on 4/1/14.
 */
public class Passenger {
    public String name() {
        return null;
    }

    public static enum Gender{Male, Female};

    private String name;
    private Integer points;
    private String loyalty;
    private Gender gender;

    public Passenger(String name, Integer points, Gender gender, List<String> specialServiceRequests) {
        this.name = name;
        this.points = points;
        this.loyalty = loyalty;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", loyalty='" + loyalty + '\'' +
                ", gender=" + gender +
                '}';
    }
}
