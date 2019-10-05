package com.wagdynavas.wnmoviecatalogservice.models;


public class CatalogItem {

    private String movieTitle;
    private String movieDescription;
    private int rating;

    public CatalogItem(String movieTitle, String movieDescription, int rating) {
        this.movieTitle = movieTitle;
        this.movieDescription = movieDescription;
        this.rating = rating;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatalogItem that = (CatalogItem) o;

        if (rating != that.rating) return false;
        if (movieTitle != null ? !movieTitle.equals(that.movieTitle) : that.movieTitle != null) return false;
        return movieDescription != null ? movieDescription.equals(that.movieDescription) : that.movieDescription == null;
    }

    @Override
    public int hashCode() {
        int result = movieTitle != null ? movieTitle.hashCode() : 0;
        result = 31 * result + (movieDescription != null ? movieDescription.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }

    @Override
    public String toString() {
        return "CatalogItem ["
                + ((movieTitle != null) ? "movieTitle=" + movieTitle + ", " : "")
                + ((movieDescription != null) ? "movieDescription=" + movieDescription + ", " : "")
                + "rating=" + rating
                + "]";
    }
}
