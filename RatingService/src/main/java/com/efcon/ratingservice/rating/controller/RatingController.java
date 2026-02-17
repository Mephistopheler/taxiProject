package com.efcon.ratingservice.rating.controller;

import com.efcon.ratingservice.rating.dto.RatingRequestDto;
import com.efcon.ratingservice.rating.dto.RatingResponseDto;
import com.efcon.ratingservice.rating.service.RatingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
@RequiredArgsConstructor
public class RatingController {


    private final RatingService ratingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RatingResponseDto rateTrip(@Valid @RequestBody RatingRequestDto requestDto) {


        // Обрабатываем запрос
        RatingResponseDto response = ratingService.rateTrip(requestDto);


        return response;
    }

    @GetMapping("/{tripId}")
    public List<RatingResponseDto> getTripRatings(@PathVariable String tripId) {


        // Получаем рейтинги
        List<RatingResponseDto> ratings = ratingService.getByTrip(tripId);


        return ratings;
    }
}
