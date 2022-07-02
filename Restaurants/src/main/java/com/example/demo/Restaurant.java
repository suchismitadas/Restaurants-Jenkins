package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Restaurant {

    private @Id @GeneratedValue Long id;
    private String name;
    private String city;
    private double rating;
    public Long getId() {
        return id;
    }

    Restaurant() {}
    
    public Restaurant(String name, String city, double rating) {
        this.name = name;
        this.city = city;
        this.rating = rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


    

    

    


    // MusicItem(String name, String artist_group, String genre) {

    //     this.name = name;
    //     this.artist_group = artist_group;
    //     this.genre = genre;
    // }

    // public Long getId() {
    //     return this.id;
    // }

    // public String getName() {
    //     return this.name;
    // }

    // public String getArtist_group() {
    //     return this.artist_group;
    // }

    // public String getGenre(){
    //     return this.genre;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public void setArtist_group(String artist_group) {
    //     this.artist_group = artist_group;
    // }

    // public void setGenre(String genre){
    //     this.genre = genre;
    // }


    /*@Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof MusicItem))
            return false;
        MusicItem item = (MusicItem) o;
        return Objects.equals(this.id, item.id) && Objects.equals(this.name, item.name)
                && Objects.equals(this.artist_group, item.artist_group)
                && Objects.equals(this.genre, item.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.artist_group, this.genre);
    }

    @Override
    public String toString() {
        return "MusicItem{" + "id=" + this.id + ", name='" + this.name + '\'' + ", artist_group='" + this.artist_group
                + '\'' + "genre='" + this.genre + '\'' + '}';
    }*/
}
