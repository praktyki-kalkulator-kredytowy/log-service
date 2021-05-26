package com.praktyki.log.app.data.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class ScheduleSummaryEntity {

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

    public ScheduleSummaryEntity() {
    }

    public ScheduleSummaryEntity(
            BigDecimal sumUpCapitalInstallment,
            BigDecimal loanPaidOutAmount, BigDecimal commissionAmount,
            BigDecimal insuranceTotalAmount, BigDecimal loanTotalCost, BigDecimal aprc)
    {
        this.sumUpCapitalInstallment = sumUpCapitalInstallment;
        this.loanPaidOutAmount = loanPaidOutAmount;
        this.commissionAmount = commissionAmount;
        this.insuranceTotalAmount = insuranceTotalAmount;
        this.loanTotalCost = loanTotalCost;
        this.aprc = aprc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                 sumUpCapitalInstallment, loanPaidOutAmount, commissionAmount, insuranceTotalAmount,loanTotalCost,aprc
        );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ScheduleSummary {\n");

        sb.append("    sumUpCapitalInstallment: ").append(toIndentedString(sumUpCapitalInstallment)).append("\n");
        sb.append("    loanPaidOutAmount: ").append(toIndentedString(loanPaidOutAmount)).append("\n");
        sb.append("    commissionAmount: ").append(toIndentedString(commissionAmount)).append("\n");
        sb.append("    insuranceTotalAmount: ").append(toIndentedString(insuranceTotalAmount)).append("\n");
        sb.append("    loanTotalCost: ").append(toIndentedString(loanTotalCost)).append("\n");
        sb.append("    aprc: ").append(toIndentedString(aprc)).append("\n");
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
