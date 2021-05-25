package com.praktyki.log.app.data.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class ScheduleCalculationEventPK implements Serializable {

    @OneToOne
    @JoinColumn(name = "schedule_calculation_event_id")
    public ScheduleCalculationEventEntity scheduleCalculationEventEntity;

    public ScheduleCalculationEventPK(ScheduleCalculationEventEntity scheduleCalculationEventEntity) {
        this.scheduleCalculationEventEntity = scheduleCalculationEventEntity;
    }
}
