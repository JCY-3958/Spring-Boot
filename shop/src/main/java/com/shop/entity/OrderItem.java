package com.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
//@Table이 없으면 클래스 이름 그대로 만들어짐
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id") //OderItem.item_id = Item.item_id
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id") // OrderItem.order_id = Order.order_id
    private Order order;

    private int orderPrice;

    private int count;

    private LocalDateTime regTime;

    private LocalDateTime updateTime;
}
