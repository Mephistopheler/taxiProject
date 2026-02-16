package com.efcon.ratingservice.rating.service;

import com.efcon.ratingservice.rating.dto.RatingRequestDto;
import com.efcon.ratingservice.rating.dto.RatingResponseDto;
import com.efcon.ratingservice.rating.mapper.RatingMapper;
import com.efcon.ratingservice.rating.model.Rating;
import com.efcon.ratingservice.rating.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

    private static final Logger log = LoggerFactory.getLogger(RatingService.class);

    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    public RatingResponseDto rateTrip(RatingRequestDto requestDto) {
        log.info("Received request to rate trip: {}", requestDto);

        // Маппим DTO в сущность
        Rating rating = ratingMapper.toEntity(requestDto);
        log.info("Mapped Rating entity: {}", rating);

        // Сохраняем в Redis
        Rating savedRating = ratingRepository.save(rating);
        log.info("Saved Rating: {}", savedRating);

        // Маппим обратно в DTO и возвращаем
        RatingResponseDto responseDto = ratingMapper.toDto(savedRating);
        log.info("Returning RatingResponseDto: {}", responseDto);

        return responseDto;
    }

    public List<RatingResponseDto> getByTrip(String tripId) {
        log.info("Fetching ratings for tripId: {}", tripId);

        List<Rating> ratings = ratingRepository.findByTripId(tripId);
        log.info("Found {} ratings for tripId {} in the database", ratings.size(), tripId);

        List<RatingResponseDto> responseDtos = ratings.stream()
                .map(ratingMapper::toDto)
                .toList();

        log.info("Returning {} RatingResponseDto(s) for tripId: {}", responseDtos.size(), tripId);

        return responseDtos;
    }
}
