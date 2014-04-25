package org.jbehave.demo.builders;

import org.jbehave.demo.domain.Flight;
import org.jbehave.demo.domain.Fop;
import org.jbehave.demo.domain.Passenger;
import org.jbehave.demo.pages.*;

import java.util.List;

public class PnrBuilder {
    private PassengerBuilder passengerBuilder;
    private final FopBuilder fopBuilder;
    private FlightBuilder flightBuilder;
    private String defaultAgentInfo;
    private LoginPage loginPage;
    private SearchFlightPage selectFlightPage;
    private PassengerPage passengerPage;
    private PricingPage pricingPage;
    private FopPage fopPage;
    private IssueDocumentsPage issueDocumentsPage;

    public PnrBuilder(FlightBuilder flightBuilder, PassengerBuilder passengerBuilder, FopBuilder fopBuilder) {
        this.flightBuilder = flightBuilder;
        this.passengerBuilder = passengerBuilder;
        this.fopBuilder = fopBuilder;
    }

    public void build(Flight flight, List<Passenger> passenger, Fop fop) {
        fillInThePages(flight, passenger, fop);
    }

    public void buildForDb() {
        flightBuilder.build();
        passengerBuilder.build();
        fopBuilder.build();
    }

    private void fillInThePages(Flight flight, List<Passenger> passenger, Fop fop) {
        loginPage.login(defaultAgentInfo);
        selectFlightPage.select(flight);
        passengerPage.add(passenger, flight);
        pricingPage.price();
        fopPage.add(fop);
        issueDocumentsPage.confirm();
    }
}
