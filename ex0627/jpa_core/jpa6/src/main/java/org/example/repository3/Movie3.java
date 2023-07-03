package org.example.repository3;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Movie3 extends Item3 {

    private String direction;

    private String actor;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
