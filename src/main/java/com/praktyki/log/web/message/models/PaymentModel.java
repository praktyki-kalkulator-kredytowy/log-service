package com.praktyki.log.web.message.models;

import org.springframework.lang.Nullable;

import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class PaymentModel {

    public int mIndex;
    public LocalDate mInstallmentDate;
    public Double mCapitalInstallment;
    public Double mInterestInstallment;
    public Double mRemainingDebt;
    public Double mInsurancePremiumValue;

    public PaymentModel(int index, LocalDate installmentDate, Double capitalInstallment,
                        Double interestInstallment, Double remainingDebt, Double insurancePremiumValue) {
        mIndex = index;
        mInstallmentDate = installmentDate;
        mCapitalInstallment = capitalInstallment;
        mInterestInstallment = interestInstallment;
        mRemainingDebt = remainingDebt;
        mInsurancePremiumValue = insurancePremiumValue;
    }

    public PaymentModel() {}

    @Override
    public String toString() {
        return "Installment { " +
                " Index = " + mIndex +
                ", InstallmentDate = " + mInstallmentDate +
                ", CapitalInstallment = " + mCapitalInstallment +
                ", InterestInstallment = " + mInterestInstallment +
                ", RemainingDebt = " + mRemainingDebt +
                ", mInsurancePremiumValue = " + mInsurancePremiumValue +
                " }";
    }
}
