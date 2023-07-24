package com.sharad.ridersspot.collection;

import lombok.Builder;
import lombok.Data;
import org.springframework.cglib.core.Local;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "reservation")
public class Reservation {
    private String id;
    private String bikeId;
    private String userId;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private String status;
}
