package com.ganesh.persistence;

import com.ganesh.bean.Rating;
import com.ganesh.bean.RatingList;
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

    List<Rating> getRatingByUserId(@Param("id") int id);
}
