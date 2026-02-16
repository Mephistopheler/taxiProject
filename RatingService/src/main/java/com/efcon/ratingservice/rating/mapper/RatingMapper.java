package com.efcon.ratingservice.rating.mapper;

import com.efcon.ratingservice.rating.dto.RatingRequestDto;
import com.efcon.ratingservice.rating.dto.RatingResponseDto;
import com.efcon.ratingservice.rating.model.Rating;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface RatingMapper {

    Rating toEntity(RatingRequestDto dto);
    RatingResponseDto toDto(Rating rating);

}
