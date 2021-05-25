package com.praktyki.log.app.data.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Embeddable
@Table(name = "schedule_summary")
public class ScheduleSummaryEntity {

    @OneToOne
    @JoinColumn(name = "schedule_calculation_event_id")
    public ScheduleCalculationEventEntity orderId;

    @Column(name = "sum_up_capital_installment")
    public BigDecimal sumUpCapitalInstallment;

    @Column(name = "loan_paid_out_amount")
    public BigDecimal loanPaidOutAmount;

    @Column(name = "commission_amount")
    public BigDecimal commissionAmount;

    @Column(name = "insurance_total_cost")
    public BigDecimal insuranceTotalAmount;

    @Column(name = "loan_total_cost")
    public BigDecimal loanTotalCost;

    @Column(name = "aprc")
    public BigDecimal aprc;

    public ScheduleSummaryEntity(
            ScheduleCalculationEventEntity orderId, BigDecimal sumUpCapitalInstallment,
            BigDecimal loanPaidOutAmount, BigDecimal commissionAmount,
            BigDecimal insuranceTotalAmount, BigDecimal loanTotalCost, BigDecimal aprc)
    {
        this.orderId = orderId;
        this.sumUpCapitalInstallment = sumUpCapitalInstallment;
        this.loanPaidOutAmount = loanPaidOutAmount;
        this.commissionAmount = commissionAmount;
        this.insuranceTotalAmount = insuranceTotalAmount;
        this.loanTotalCost = loanTotalCost;
        this.aprc = aprc;
    }
}
