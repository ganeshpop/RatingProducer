package com.ganesh.resources;


import com.ganesh.bean.Rating;
import com.ganesh.bean.RatingList;
import com.ganesh.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(path = "/ratings")
public class RatingResource {

    private RatingService ratingService;

    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @Autowired

    @GetMapping(produces = "Application/json")
    RatingList findAllRatings() {
        return ratingService.getAllRatings();
    }

    @GetMapping(path = "/{id}", produces = "Application/json")
    Rating getRatingById(@PathVariable("id") int id) {
        return ratingService.getRatingById(id);
    }


    @GetMapping(path = "/xml/{id}", produces = "Application/xml")
    public Rating getXmlRatingById(@PathVariable("id") int id) {
        return ratingService.getRatingById(id);
    }

    @GetMapping(path = "/movies/average/{id}", produces = "Application/json")
    public Integer getAverageRatingByMovieId(@PathVariable("id") int id) {
        Integer averageRating = ratingService.getAverageRatingByMovieId(id);
        if(averageRating!=null) return averageRating;
        return 0;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "Application/json", consumes = "Application/json")
    Rating saveRating(@RequestBody Rating rating ) {
        return ratingService.insertRating(rating);
    }


    @RequestMapping(path = "/{id}/{rating}", method = RequestMethod.PUT, produces = "Application/json", consumes = "Application/json")
    Rating updateRating(@PathVariable("id") int id, @PathVariable("rating") int rating) {
        return ratingService.updateRating(id, rating);
    }

    @GetMapping(path = "/users/{id}",produces = "Application/json")
    RatingList getRatingByUserId(@PathVariable("id") int id) {
        return ratingService.getRatingByUserId(id);
    }


    @GetMapping(path = "/movies/{id}",produces = "Application/json")
    RatingList getRatingByMovieId(@PathVariable("id") int id) {
        return ratingService.getRatingByMovieId(id);
    }


    @DeleteMapping(path = "/{id}", produces = "Application/json", consumes = "Application/json")
    Rating deleteRating(@PathVariable("id") int id) {
        return ratingService.deleteRatingById(id);
    }
}