package com.efcon.tripservice.dto;

import com.efcon.tripservice.model.TripStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TripResponseDto {
    private String id;
    private Long driverId;
    private Long passengerId;
    private String pickupAddress;
    private String destinationAddress;
    private TripStatus status;
    private LocalDateTime orderDateTime;
    private BigDecimal cost;
}