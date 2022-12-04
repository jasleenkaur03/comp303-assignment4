package com.comp303.Assignment4.Cruise;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("cruises")
public class Cruise {
    @Id
    public String cruiseId;
    public String cruiseDestination;
    public String cruiseLine;
    public String departureDate;
    public String visitingPlaces;
    public int duration;
    public double price;

    public Cruise() {
    }

    public Cruise(String cruiseId, String cruiseDestination, String cruiseLine, String departureDate,
            String visitingPlaces, int duration, double price) {
        this.cruiseId = cruiseId;
        this.cruiseDestination = cruiseDestination;
        this.cruiseLine = cruiseLine;
        this.departureDate = departureDate;
        this.visitingPlaces = visitingPlaces;
        this.duration = duration;
        this.price = price;
    }

   

}
