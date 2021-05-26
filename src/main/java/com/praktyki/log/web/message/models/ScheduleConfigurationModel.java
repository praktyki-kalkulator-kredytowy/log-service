package com.praktyki.log.web.message.models;

import org.springframework.lang.Nullable;

import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class ScheduleConfigurationModel {

    public double capital;

    public String installmentType;

    public int installmentAmount;

    public double interestRate;

    public LocalDate withdrawalDate;

    public double commissionRate;

    public Integer age;

    public boolean insurance;

    public ScheduleConfigurationModel() {
    }

    public ScheduleConfigurationModel(
            double capital,
            String installmentType,
            int installmentAmount,
            double interestRate,
            LocalDate withdrawalDate,
            double commissionRate,
            Integer age,
            boolean insurance
    ) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleConfigurationModel that = (ScheduleConfigurationModel) o;
        return Double.compare(that.capital, capital) == 0
                && installmentAmount == that.installmentAmount
                && Double.compare(that.interestRate, interestRate) == 0
                && Double.compare(that.commissionRate, commissionRate) == 0
                && age == that.age && insurance == that.insurance
                && installmentType.equals(that.installmentType)
                && withdrawalDate.equals(that.withdrawalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                capital,
                installmentType,
                installmentAmount,
                interestRate,
                withdrawalDate,
                commissionRate,
                age,
                insurance
        );
    }
    @Override
    public String toString() {
        return "ScheduleConfiguration {" +
                " Capital = " + capital +
                ", InstallmentType = " + installmentType +
                ", InstallmentAmount = " + installmentAmount +
                ", InterestRate = " + interestRate +
                ", WithdrawalDate = " + withdrawalDate +
                ", CommissionRate = " + commissionRate +
                ", InsuranceRate = " + age +
                ", Insurance = " + insurance +
                " }";
    }
}