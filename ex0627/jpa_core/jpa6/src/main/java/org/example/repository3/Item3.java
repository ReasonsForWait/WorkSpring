package org.example.repository3;

import javax.persistence.*;

@Entity
// 어떤 조인전략을 사용할 것인지 선언
// 조인전략을 TABLE_PER_TABLE
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item3 {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
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
