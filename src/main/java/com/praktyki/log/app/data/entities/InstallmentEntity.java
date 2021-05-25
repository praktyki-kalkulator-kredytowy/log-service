package com.praktyki.log.app.data.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
@Table(name = "installments")
public class InstallmentEntity {

    @OneToOne
    @JoinColumn(name = "schedule_calculation_event_id")
    public ScheduleCalculationEventEntity orderId;

    @Column(name = "installment_index")
    public int installmentIndex;

    @Column(name = "installment_date")
    public LocalDate installmentDate;

    @Column(name = "capital_installment")
    public BigDecimal capitalInstallment;

    @Column(name = "interest_installment")
    public BigDecimal interestInstallment;

    @Column(name = "remaining_debt")
    public BigDecimal remainingDebt;

    public InstallmentEntity(
            ScheduleCalculationEventEntity orderId, int installmentIndex,
            LocalDate installmentDate, BigDecimal capitalInstallment,
            BigDecimal interestInstallment, BigDecimal remainingDebt)
    {
        this.orderId = orderId;
        this.installmentIndex = installmentIndex;
        this.installmentDate = installmentDate;
        this.capitalInstallment = capitalInstallment;
        this.interestInstallment = interestInstallment;
        this.remainingDebt = remainingDebt;
    }
}
