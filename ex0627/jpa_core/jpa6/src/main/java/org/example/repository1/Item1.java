package org.example.repository1;

import javax.persistence.*;

@Entity
// 어떤 조인전략을 사용할 것인지 선언
@Inheritance(strategy = InheritanceType.JOINED)
// 조인의 기준이 되는 컬럼 설정
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item1 {
    @Id @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;
    private String name;
    private Integer price;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
