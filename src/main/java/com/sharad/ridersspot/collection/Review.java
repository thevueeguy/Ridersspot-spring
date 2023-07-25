package com.sharad.ridersspot.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "review")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Review {
        @Id
        private String id;
        private String userId;
        private String bikeId;
        private Double rating;
        private String comment;
}
