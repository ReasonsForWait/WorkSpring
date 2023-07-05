package org.example.repository4;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Member4 {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    private String name;
    // 선호하는 음식
    @ElementCollection // 여러개의 데이터를 받는 컬렉션 값 타입을 지정 시 선언하는 어노테이션
    // 컬렉션 값에 대한 세부 설정 어노테이션
    // - name = 테이블 이름
    // - joinColumn = 해당 테이블의 참조할 id 값
    @CollectionTable(name = "FAVORITE_FOOD",
            joinColumns = @JoinColumn(name = "MEMBER_ID"))
    private Set<String> favoriteFood = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "ADDRESS",
    joinColumns = @JoinColumn(name = "MEMBER_ID"))
    private List<Address4> addressList = new ArrayList<>();

    public List<Address4> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address4> addressList) {
        this.addressList = addressList;
    }

    public Long getId() {
        return id;
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

    public Set<String> getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(Set<String> favoriteFood) {
        this.favoriteFood = favoriteFood;
    }
}
