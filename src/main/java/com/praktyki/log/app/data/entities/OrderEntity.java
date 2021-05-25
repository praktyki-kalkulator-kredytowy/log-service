package com.praktyki.log.app.data.entities;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue
    @Column(name = "orders_id")
    public int id;

    @Column(name = "orders_date")
    public LocalDate orderDate;

    public OrderEntity(int id, LocalDate orderDate) {
        this.id = id;
        this.orderDate = orderDate;
    }
}
