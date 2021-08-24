package com.ganesh.service;

import com.ganesh.bean.Rating;
import com.ganesh.bean.RatingList;

import java.util.Collection;
import java.util.List;

public interface RatingService {

    RatingList getAllRatings();
    Rating insertRating(Rating rating);
    Rating getRatingById(int id);
    Rating deleteRatingById(int id);
    Rating updateRating(int id, int rating);
    RatingList getRatingByUserId(int id);
}
