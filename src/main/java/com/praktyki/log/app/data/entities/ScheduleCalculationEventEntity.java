package com.praktyki.log.app.data.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "schedule_calculation_event")
public class ScheduleCalculationEventEntity {

    @Id
    @GeneratedValue
    @Column(name = "schedule_calculation_event_id")
    public int eventId;

    @Column(name = "schedule_calculation_event_date")
    public LocalDate orderDate;

    @Embedded
    public ScheduleConfigurationEntity scheduleConfigurationEntity;

    @Embedded
    public ScheduleSummaryEntity scheduleSummaryEntity;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "payments",
            joinColumns = @JoinColumn(name = "schedule_calculation_event_id", referencedColumnName = "schedule_calculation_event_id")
    )
    public List<PaymentEntity> payments;

    public ScheduleCalculationEventEntity() {
    }

    public ScheduleCalculationEventEntity(
            int eventId,
            LocalDate orderDate,
            ScheduleConfigurationEntity scheduleConfigurationEntity,
            ScheduleSummaryEntity scheduleSummaryEntity,
            List<PaymentEntity> payments
    ) {
        this.eventId = eventId;
        this.orderDate = orderDate;
        this.scheduleConfigurationEntity = scheduleConfigurationEntity;
        this.scheduleSummaryEntity = scheduleSummaryEntity;
        this.payments = payments;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDate, scheduleConfigurationEntity, scheduleSummaryEntity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ScheduleCalculationEvent {\n");

        sb.append("    date: ").append(toIndentedString(orderDate)).append("\n");
        sb.append("    ").append(scheduleConfigurationEntity.toString()).append("\n");
        sb.append("    ").append(scheduleSummaryEntity.toString()).append("\n");
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
