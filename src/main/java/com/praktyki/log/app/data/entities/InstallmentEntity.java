package com.praktyki.log.app.data.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "installments")
public class InstallmentEntity {

    @EmbeddedId
    public ScheduleCalculationEventPK scheduleCalculationEventPK;

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
            ScheduleCalculationEventPK scheduleCalculationEventPK, int installmentIndex,
            LocalDate installmentDate, BigDecimal capitalInstallment,
            BigDecimal interestInstallment, BigDecimal remainingDebt)
    {
        this.scheduleCalculationEventPK = scheduleCalculationEventPK;
        this.installmentIndex = installmentIndex;
        this.installmentDate = installmentDate;
        this.capitalInstallment = capitalInstallment;
        this.interestInstallment = interestInstallment;
        this.remainingDebt = remainingDebt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(installmentIndex, installmentDate, capitalInstallment, interestInstallment, remainingDebt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Installment {\n");

        sb.append("    index: ").append(toIndentedString(installmentIndex)).append("\n");
        sb.append("    date: ").append(toIndentedString(installmentDate)).append("\n");
        sb.append("    capitalInstallment: ").append(toIndentedString(capitalInstallment)).append("\n");
        sb.append("    interestInstallment: ").append(toIndentedString(interestInstallment)).append("\n");
        sb.append("    remainingDebt: ").append(toIndentedString(remainingDebt)).append("\n");
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
