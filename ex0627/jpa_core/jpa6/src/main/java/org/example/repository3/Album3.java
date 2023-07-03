package org.example.repository3;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Album3 extends Item3 {
    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
