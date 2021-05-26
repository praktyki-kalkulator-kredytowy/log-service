package com.praktyki.log.web.message.models;

import java.time.LocalDate;

public class ScheduleCalculationEvent {

    public int id;
    public Schedule schedule;
    public LocalDate calculationDate;

    public ScheduleCalculationEvent(int id, Schedule schedule, LocalDate calculationDate) {
        this.id = id;
        this.schedule = schedule;
        this.calculationDate = calculationDate;
    }

}
