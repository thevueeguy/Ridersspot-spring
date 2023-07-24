package com.sharad.ridersspot.collection;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "bike")
public class Bike {
    private String id;
    private String brand;
    private String model;
    private String price;
    private String color;
    private String location;
    private Boolean isAvailable;
    private Double rating;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
}
