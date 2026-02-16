package com.efcon.ratingservice.rating.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("rating")
public class Rating {

    @Id
    private String id;
    @Indexed
    private String tripId;
    private Long driverId;
    private Long passengerId;
    private Integer score;
    private String comment;
    private RaterType raterType;


}
