package com.ganesh.service;

import com.ganesh.bean.Rating;
import com.ganesh.bean.RatingList;
import com.ganesh.persistence.RatingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RatingServiceImpl implements RatingService {
    private RatingDao ratingDao;

    @Autowired
    public void setRatingDao(RatingDao ratingDao) {
        this.ratingDao = ratingDao;
    }

    @Override
    public RatingList getAllRatings() {
        return new RatingList(ratingDao.findAll());
    }

    @Override
    public Rating insertRating(Rating rating) {
        if (ratingDao.getRatingByUserIdAndMovieId(rating.getUserId(), rating.getMovieId()) != null) {
            ratingDao.updateRatingWithUserIdAndMovieId(rating.getUserId(), rating.getRating(), rating.getMovieId());
            return ratingDao.getRatingByUserIdAndMovieId(rating.getUserId(), rating.getMovieId());
        }
        return ratingDao.save(rating);
    }

    @Override
    public Rating getRatingById(int id) {
        return ratingDao.getById(id);
    }

    @Override
    public Rating deleteRatingById(int id) {
        Rating rating = ratingDao.getById(id);
        ratingDao.deleteById(id);
        return rating;
    }

    @Override
    public Integer getAverageRatingByMovieId(int id) {
        Integer rating = ratingDao.getAverageRatingByMovieId(id);
        System.out.println(rating);
        return rating;
    }

    @Override
    public Rating updateRating(int id, int rating) {
        int rows = ratingDao.updateRating(id, rating);
        if (rows > 0) return ratingDao.getById(id);
        return null;
    }


    @Override
    public RatingList getRatingByUserId(int id) {
        return new RatingList(ratingDao.getRatingByUserId(id));
    }

    @Override
    public RatingList getRatingByMovieId(int id) {
        return new RatingList((ratingDao.getRatingByMovieId(id)));
    }


}
