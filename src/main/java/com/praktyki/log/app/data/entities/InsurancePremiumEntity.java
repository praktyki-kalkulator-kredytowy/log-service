package com.praktyki.log.app.data.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
@Table(name = "insurance_premiums")
public class InsurancePremiumEntity {

    @OneToOne
    @JoinColumn(name = "schedule_calculation_event_id")
    public ScheduleCalculationEventEntity orderId;

    @Column(name = "insurance_premium_index")
    public int insurancePremiumIndex;

    @Column(name = "insurance_premium_date")
    public LocalDate insurancePremiumDate;

    @Column(name = "insurance_premium_value")
    public BigDecimal insurancePremiumValue;

    public InsurancePremiumEntity(
            ScheduleCalculationEventEntity orderId, int insurancePremiumIndex,
            LocalDate insurancePremiumDate, BigDecimal insurancePremiumValue)
    {
        this.orderId = orderId;
        this.insurancePremiumIndex = insurancePremiumIndex;
        this.insurancePremiumDate = insurancePremiumDate;
        this.insurancePremiumValue = insurancePremiumValue;
    }
}
