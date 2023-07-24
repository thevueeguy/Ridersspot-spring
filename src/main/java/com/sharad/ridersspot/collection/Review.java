package com.sharad.ridersspot.collection;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "review")
public class Review {
        private String id;
        private String userId;
        private String bikeId;
        private Double rating;
        private String comment;
}
