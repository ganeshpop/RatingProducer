package com.ganesh.persistence;

import com.ganesh.bean.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface RatingDao extends JpaRepository<Rating, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Rating SET rating =:rating WHERE id =:id")
    int updateRating(@Param("id") int id, @Param("rating") int rating);

    @Transactional
    @Modifying
    @Query("UPDATE Rating SET rating =:rating WHERE userId =:userId and movieId =:movieId")
    void updateRatingWithUserIdAndMovieId(@Param("userId") int userId, @Param("rating") int rating, @Param("movieId") int movieId);

    List<Rating> getRatingByUserId(@Param("id") int id);

    Rating getRatingByUserIdAndMovieId(@Param("userId") int userId, @Param("movieId") int movieId);

    List<Rating> getRatingByMovieId(@Param("id") int id);

    @Query("SELECT AVG(rating) FROM Rating WHERE movieId =:movieId")
    Integer getAverageRatingByMovieId(@Param("movieId") int movieId);
}
