package com.praktyki.log.web.message.models;

import java.time.LocalDate;

public class PaymentModel {

    public int index;
    public LocalDate date;
    public Double capitalInstallment;
    public Double interestInstallment;
    public Double remainingDebt;
    public Double insurancePremium;

    public PaymentModel(int index, LocalDate date, Double capitalInstallment,
                        Double interestInstallment, Double remainingDebt, Double insurancePremium) {
        this.index = index;
        this.date = date;
        this.capitalInstallment = capitalInstallment;
        this.interestInstallment = interestInstallment;
        this.remainingDebt = remainingDebt;
        this.insurancePremium = insurancePremium;
    }

    public PaymentModel() {}

    @Override
    public String toString() {
        return "Installment { " +
                " Index = " + index +
                ", InstallmentDate = " + date +
                ", CapitalInstallment = " + capitalInstallment +
                ", InterestInstallment = " + interestInstallment +
                ", RemainingDebt = " + remainingDebt +
                ", mInsurancePremiumValue = " + insurancePremium +
                " }";
    }
}
