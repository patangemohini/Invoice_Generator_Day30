package com.bl.invoice_generator;

public class InvoiceGenerator {

    private final RideRepository rideRepository;

    public InvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }

    public double calculateFare(MultipalRides ride) {
        return Math.max(ride.rideCategory.minFare,
                ride.getDistance() * ride.rideCategory.costPerKm + ride.getTime() * ride.rideCategory.costPerTime);
    }

    public EnhancedInvoice calculateFare(MultipalRides[] rides) {
        double totalFare = 0;
        for (MultipalRides ride : rides) {
            totalFare += calculateFare(ride);
        }
        return new EnhancedInvoice(rides.length, totalFare);
    }

    public void addRides(String userId, MultipalRides[] ride) {
        rideRepository.addRide(userId, ride);
    }

    public EnhancedInvoice getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}