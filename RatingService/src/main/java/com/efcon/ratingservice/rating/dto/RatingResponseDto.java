package com.efcon.ratingservice.rating.dto;


import com.efcon.ratingservice.rating.model.RaterType;
import lombok.Data;

@Data
public class RatingResponseDto{

    private String id;
    private String tripId;
    private Long driverId;
    private Long passengerId;
    private Integer score;
    private String comment;
    private RaterType raterType;

}
