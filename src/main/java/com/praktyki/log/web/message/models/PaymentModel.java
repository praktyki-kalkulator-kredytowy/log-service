package com.praktyki.log.web.message.models;

import java.time.LocalDate;

public class PaymentModel {

    public int index;
    public LocalDate installmentDate;
    public Double capitalInstallment;
    public Double interestInstallment;
    public Double remainingDebt;
    public Double insurancePremiumValue;

    public PaymentModel(int index, LocalDate installmentDate, Double capitalInstallment,
                        Double interestInstallment, Double remainingDebt, Double insurancePremiumValue) {
        this.index = index;
        this.installmentDate = installmentDate;
        this.capitalInstallment = capitalInstallment;
        this.interestInstallment = interestInstallment;
        this.remainingDebt = remainingDebt;
        this.insurancePremiumValue = insurancePremiumValue;
    }

    public PaymentModel() {}

    @Override
    public String toString() {
        return "Installment { " +
                " Index = " + index +
                ", InstallmentDate = " + installmentDate +
                ", CapitalInstallment = " + capitalInstallment +
                ", InterestInstallment = " + interestInstallment +
                ", RemainingDebt = " + remainingDebt +
                ", mInsurancePremiumValue = " + insurancePremiumValue +
                " }";
    }
}
