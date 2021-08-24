package com.ganesh;

import com.ganesh.bean.Rating;
import com.ganesh.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.ganesh")
@EnableJpaRepositories(basePackages = "com.ganesh.persistence")
@EntityScan(basePackages = "com.ganesh.bean")
public class RatingProducerApplication implements CommandLineRunner {

    private RatingService ratingService;

    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }


    public static void main(String[] args) {
        SpringApplication.run(RatingProducerApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        ratingService.insertRating(new Rating(1, 1, 1, 5));
        ratingService.insertRating(new Rating(2, 1, 2, 2));
        ratingService.insertRating(new Rating(3, 1, 3, 3));
        ratingService.insertRating(new Rating(4, 2, 3, 4));
        ratingService.insertRating(new Rating(5, 2, 4, 4));
        ratingService.insertRating(new Rating(6, 3, 2, 3));
        ratingService.insertRating(new Rating(7, 3, 4, 5));
        ratingService.insertRating(new Rating(8, 3, 5, 2));
        ratingService.insertRating(new Rating(9, 4, 1, 1));
        ratingService.insertRating(new Rating(10, 4, 3, 4));
        ratingService.insertRating(new Rating(11, 4, 4, 3));
        ratingService.insertRating(new Rating(12, 4, 5, 2));
        ratingService.insertRating(new Rating(13, 5, 2, 4));
        ratingService.insertRating(new Rating(14, 5, 4, 4));
        ratingService.insertRating(new Rating(15, 5, 5, 5));

    }
}
