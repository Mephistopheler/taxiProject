package com.efcon.tripservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import jakarta.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Data
public class TripRequestDto {

    @NotNull
    private Long driverId;
    @NotNull
    private Long passengerId;
    @NotNull
    private String pickupAddress;
    @NotBlank
    private String destinationAddress;
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal cost;

}
