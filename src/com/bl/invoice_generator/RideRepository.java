package com.bl.invoice_generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {

    Map<String, ArrayList<MultipalRides>> userRides;

    public RideRepository() {
        userRides = new HashMap<>();
    }

    public void addRide(String userId, MultipalRides[] ride) {
        this.userRides.computeIfAbsent(userId, k -> new ArrayList<>(Arrays.asList(ride)));

    }

    public MultipalRides[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new MultipalRides[0]);
    }
}