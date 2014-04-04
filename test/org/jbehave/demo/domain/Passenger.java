package org.jbehave.demo.domain;

import org.jbehave.demo.builders.PassengerBuilder;

/**
 * Created by ThoughtWorker on 4/1/14.
 */
public class Passenger {
    public static enum Gender{Male, Female};

    private String name;
    private String loyalty;
    private Gender gender;

    public Passenger(String name, String loyalty, Gender gender) {
        this.name = name;
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
