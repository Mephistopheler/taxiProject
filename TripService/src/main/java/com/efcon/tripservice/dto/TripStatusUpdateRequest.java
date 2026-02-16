package com.efcon.tripservice.dto;

import com.efcon.tripservice.model.TripStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TripStatusUpdateRequest {
    @NotNull
    private TripStatus status;
}