package com.praktyki.log.app.data.entities;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "schedule_calculation_event_id")
public class ScheduleCalculationEventEntity {

    @Id
    @GeneratedValue
    @Column(name = "schedule_calculation_event_id")
    public int id;

    @Column(name = "schedule_calculation_event_date")
    public LocalDate orderDate;

    public ScheduleCalculationEventEntity(int id, LocalDate orderDate) {
        this.id = id;
        this.orderDate = orderDate;
    }
}
