package org.jbehave.demo.builders;

import org.jbehave.demo.domain.Passenger;

import java.util.ArrayList;
import java.util.List;

import static org.jbehave.demo.domain.Passenger.Gender;

/**
 * Created by ThoughtWorker on 4/1/14.
 */
public class PassengerBuilder {
    private String name = "Able Baker";
    private Integer loyaltyPoints = 0;
    private Gender gender = Gender.Male;
    private int numberOfPassengers = 1;
    private List<String> specialServiceRequests = new ArrayList<String>();


    public java.util.List<Passenger> build() {
        List<Passenger> passengerList = new ArrayList<Passenger>();
        passengerList.add(new Passenger(name, loyaltyPoints, gender, specialServiceRequests));
        return passengerList;
    }

    public PassengerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PassengerBuilder withMaxPoints() {
        loyaltyPoints = 999999;
        return this;
    }

    public PassengerBuilder withPassenger(int i) {
        numberOfPassengers = i;
        return this;
    }

    public PassengerBuilder withDeafPassenger() {
        specialServiceRequests.add("deaf");
        return this;
    }
}
