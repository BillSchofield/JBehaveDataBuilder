package org.jbehave.demo.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.demo.builders.FlightBuilder;
import org.jbehave.demo.builders.FopBuilder;
import org.jbehave.demo.builders.PassengerBuilder;
import org.jbehave.demo.builders.PnrBuilder;
import org.jbehave.demo.domain.Flight;
import org.jbehave.demo.domain.Fop;
import org.jbehave.demo.domain.Passenger;
import org.jbehave.demo.pages.ConfirmationPage;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class BookPnrSteps {
    private final FopBuilder fopBuilder;
    private FlightBuilder flightBuilder;
    private PassengerBuilder passengerBuilder;
    private PnrBuilder pnrBuilder;
    private ConfirmationPage confirmationPage;
    private List<Passenger> passengers = new ArrayList<Passenger>();

    public BookPnrSteps(ConfirmationPage confirmationPage) {
        this.confirmationPage = confirmationPage;
        this.flightBuilder = new FlightBuilder();
        this.passengerBuilder = new PassengerBuilder();
        this.fopBuilder = new FopBuilder();
        this.pnrBuilder = new PnrBuilder(flightBuilder, passengerBuilder, fopBuilder);
    }

    @Given("there are 8 passengers")
    public void eightPassengers(){
        passengerBuilder.withPassenger(8);
    }

    @Given("I am a deaf passenger")
    public void deafPassenger(){
        passengerBuilder.withDeafPassenger();
    }

    @When("I book a flight")
    public void bookFlight(){
        Flight flight = flightBuilder.build();
        passengers.addAll(passengerBuilder.build());
        Fop fop = fopBuilder.build();

        pnrBuilder.build(flight, passengers, fop);
    }

    @Then("I receive a PNR indicating my special service")
    public void verifyDeaf(){
        assertTrue(confirmationPage.hasSsr("deaf"));
    }

    @Then("I receive a PNR")
    public void verifyConfirmedPnr(){
        assertTrue(confirmationPage.hasSuccessfulPnr());
        assertThat(confirmationPage.passengerName(), is(passengers.get(0).name()));
    }

}
