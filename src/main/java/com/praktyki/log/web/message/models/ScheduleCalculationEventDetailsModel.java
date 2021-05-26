package com.praktyki.log.web.message.models;

import java.time.LocalDate;
import java.util.Objects;

public class ScheduleCalculationEventDetailsModel {

    public int id;
    public ScheduleModel schedule;
    public LocalDate calculationDate;

    public ScheduleCalculationEventDetailsModel(int id, ScheduleModel scheduleModel, LocalDate calculationDate) {
        this.id = id;
        this.schedule = scheduleModel;
        this.calculationDate = calculationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleCalculationEventDetailsModel that = (ScheduleCalculationEventDetailsModel) o;
        return id == that.id && calculationDate.equals(that.calculationDate) && schedule.equals(that.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, calculationDate, schedule);
    }

}
