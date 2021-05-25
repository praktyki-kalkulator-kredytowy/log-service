package com.praktyki.log.app.data.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
@Table(name = "schedule_configuration")
public class ScheduleConfigurationEntity {

    @OneToOne
    @JoinColumn(name = "schedule_calculation_event_id")
    public ScheduleCalculationEventEntity orderId;

    @Column(name = "capital")
    public Integer capital;

    @Column(name = "installment_type")
    public String installmentType;

    @Column(name = "installment_amount")
    public Integer installmentAmount;

    @Column(name = "interest_rate")
    public BigDecimal interestRate;

    @Column(name = "withdrawal_date")
    public LocalDate withdrawalDate;

    @Column(name = "commission_rate")
    public Integer commissionRate;

    @Column(name = "age")
    public Integer age;

    @Column(name = "insurance")
    public Boolean insurance;

    public ScheduleConfigurationEntity(
            ScheduleCalculationEventEntity orderId,
            Integer capital,
            String installmentType,
            Integer installmentAmount,
            BigDecimal interestRate,
            LocalDate withdrawalDate,
            Integer commissionRate,
            Integer age,
            Boolean insurance) 
    {
        this.orderId = orderId;
        this.capital = capital;
        this.installmentType = installmentType;
        this.installmentAmount = installmentAmount;
        this.interestRate = interestRate;
        this.withdrawalDate = withdrawalDate;
        this.commissionRate = commissionRate;
        this.age = age;
        this.insurance = insurance;
    }
}
