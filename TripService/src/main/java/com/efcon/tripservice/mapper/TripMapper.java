package com.efcon.tripservice.mapper;

import com.efcon.tripservice.dto.TripRequestDto;
import com.efcon.tripservice.dto.TripResponseDto;
import com.efcon.tripservice.model.Trip;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TripMapper {
    Trip toEntity(TripRequestDto requestDto);
    TripResponseDto toDto(Trip trip);
}
