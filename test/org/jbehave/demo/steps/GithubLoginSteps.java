package org.jbehave.demo.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.demo.builders.PassengerBuilder;
import org.jbehave.demo.domain.Passenger;


public class GithubLoginSteps {

    @Given("a passenger named $name with loyalty number $loyalty")
    public void createPassenger(String name, String loyalty){
        final Passenger passenger = new PassengerBuilder()
                .withName(name)
                .withLoyaltyNumber(loyalty)
                .build();

    }
}
