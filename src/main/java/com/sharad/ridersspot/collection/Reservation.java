package com.sharad.ridersspot.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reservation")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reservation {
    @Id
    private String id;
    private String bikeId;
    private String userId;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private String status;
}
