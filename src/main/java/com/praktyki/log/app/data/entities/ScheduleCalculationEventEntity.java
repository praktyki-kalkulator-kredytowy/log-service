package com.praktyki.log.app.data.entities;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(orderDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InsurancePremium {\n");

        sb.append("    date: ").append(toIndentedString(orderDate)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
