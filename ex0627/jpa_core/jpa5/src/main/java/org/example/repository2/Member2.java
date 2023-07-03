package org.example.repository2;

import javax.persistence.*;

@Entity
@Table
public class Member2 {

    @Id
    @GeneratedValue
    @Column(name ="USER_ID")
    private Long id;

    private String username;

    @OneToOne
    @JoinColumn(name ="LOCKER_ID")
    private Locker2 locker;

    public Member2() {
    }

    public Member2(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Locker2 getLocker() {
        return locker;
    }

    public void setLocker(Locker2 locker) {
        if(this.locker != null){
            this.locker.setMember(null);
        }
        this.locker = locker;

        if(locker != null){
            locker.setMember(this);
        }
    }
}
