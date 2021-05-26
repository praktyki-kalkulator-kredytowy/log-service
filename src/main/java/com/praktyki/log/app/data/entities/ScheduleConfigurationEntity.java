package com.praktyki.log.app.data.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class ScheduleConfigurationEntity {

    @Column(name = "capital")
    public Integer capital;

    @Column(name = "installment_type")
    @Enumerated(EnumType.STRING)
    public InstallmentType installmentType;

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

    public ScheduleConfigurationEntity() {
    }

    public ScheduleConfigurationEntity(
            Integer capital,
            InstallmentType installmentType,
            Integer installmentAmount,
            BigDecimal interestRate,
            LocalDate withdrawalDate,
            Integer commissionRate,
            Integer age,
            Boolean insurance) 
    {
        this.capital = capital;
        this.installmentType = installmentType;
        this.installmentAmount = installmentAmount;
        this.interestRate = interestRate;
        this.withdrawalDate = withdrawalDate;
        this.commissionRate = commissionRate;
        this.age = age;
        this.insurance = insurance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                capital, installmentType, installmentAmount,
                interestRate, withdrawalDate, commissionRate, age, insurance
        );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ScheduleConfiguration {\n");

        sb.append("    capital: ").append(toIndentedString(capital)).append("\n");
        sb.append("    installmentType: ").append(toIndentedString(installmentType)).append("\n");
        sb.append("    installmentAmount: ").append(toIndentedString(installmentAmount)).append("\n");
        sb.append("    interestRate: ").append(toIndentedString(interestRate)).append("\n");
        sb.append("    withdrawalDate: ").append(toIndentedString(withdrawalDate)).append("\n");
        sb.append("    commissionRate: ").append(toIndentedString(commissionRate)).append("\n");
        sb.append("    age: ").append(toIndentedString(age)).append("\n");
        sb.append("    insurance: ").append(toIndentedString(insurance)).append("\n");
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
