package com.wagdynavas.wnmoviecatalogservice.models;

public class Rating {

    private String ratingId;
    private int rate;
    private String movieId;

    public Rating(String movieId, int rate) {
        this.movieId = movieId;
        this.rate = rate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating that = (Rating) o;

        if (rate != that.rate) return false;
        if (ratingId != null ? !ratingId.equals(that.ratingId) : that.ratingId != null) return false;
        return movieId != null ? movieId.equals(that.movieId) : that.movieId == null;
    }

    @Override
    public int hashCode() {
        int result = ratingId != null ? ratingId.hashCode() : 0;
        result = 31 * result + rate;
        result = 31 * result + (movieId != null ? movieId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RatingData ["
                + ((ratingId != null) ? "ratingId=" + ratingId + ", " : "")
                + "rate=" + rate + ", "
                + ((movieId != null) ? "movieId=" + movieId : "")
                + "]";
    }
}
