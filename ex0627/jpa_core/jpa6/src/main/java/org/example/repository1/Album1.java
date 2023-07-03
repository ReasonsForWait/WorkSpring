package org.example.repository1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// 실제 조인되는 컬럼에 들어가는 값
@DiscriminatorValue("A")
public class Album1 extends Item1{
    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
