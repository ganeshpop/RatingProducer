package com.ganesh.service;

import com.ganesh.bean.Rating;
import com.ganesh.bean.RatingList;


public interface RatingService {

    RatingList getAllRatings();
    Rating insertRating(Rating rating);
    Rating getRatingById(int id);
    Rating deleteRatingById(int id);
    Integer getAverageRatingByMovieId(int id);
    Rating updateRating(int id, int rating);
    RatingList getRatingByUserId(int id);
    RatingList getRatingByMovieId(int id);
}
