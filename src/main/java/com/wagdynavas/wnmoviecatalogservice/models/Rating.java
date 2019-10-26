package com.wagdynavas.wnmoviecatalogservice.models;

public class Rating {

    private String ratingId;
    private int rate;
    private String movieId;
    private String userId;

    public Rating(String movieId, int rate, String userId) {
        this.movieId = movieId;
        this.rate = rate;
        this.userId = userId;
    }

    public Rating() {

    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating = (Rating) o;

        if (rate != rating.rate) return false;
        if (ratingId != null ? !ratingId.equals(rating.ratingId) : rating.ratingId != null) return false;
        if (movieId != null ? !movieId.equals(rating.movieId) : rating.movieId != null) return false;
        return userId != null ? userId.equals(rating.userId) : rating.userId == null;
    }

    @Override
    public int hashCode() {
        int result = ratingId != null ? ratingId.hashCode() : 0;
        result = 31 * result + rate;
        result = 31 * result + (movieId != null ? movieId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Rating ["
                + ((ratingId != null) ? "ratingId=" + ratingId + ", " : "")
                + "rate=" + rate + ", "
                + ((movieId != null) ? "movieId=" + movieId + ", " : "")
                + ((userId != null) ? "userId=" + userId : "")
                + "]";
    }
}
