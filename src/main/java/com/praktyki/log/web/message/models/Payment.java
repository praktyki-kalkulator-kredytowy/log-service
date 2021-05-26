package com.praktyki.log.web.message.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Payment {

    private int mIndex;
    private LocalDate mInstallmentDate;
    private BigDecimal mCapitalInstallment;
    private BigDecimal mInterestInstallment;
    private BigDecimal mRemainingDebt;
    private BigDecimal mInsurancePremiumValue;

    public int getIndex() {
        return mIndex;
    }

    public LocalDate getInstallmentDate() {
        return mInstallmentDate;
    }

    public BigDecimal getCapitalInstallment() {
        return mCapitalInstallment;
    }

    public BigDecimal getInterestInstallment() {
        return mInterestInstallment;
    }

    public BigDecimal getRemainingDebt() {
        return mRemainingDebt;
    }

    public BigDecimal getInsurancePremiumValue() {
        return mInsurancePremiumValue;
    }

    public Payment(int index, LocalDate installmentDate, BigDecimal capitalInstallment,
                   BigDecimal interestInstallment, BigDecimal remainingDebt, BigDecimal insurancePremiumValue) {
        mIndex = index;
        mInstallmentDate = installmentDate;
        mCapitalInstallment = capitalInstallment;
        mInterestInstallment = interestInstallment;
        mRemainingDebt = remainingDebt;
        mInsurancePremiumValue = insurancePremiumValue;
    }

    private Payment() {}

    public void round() {
        mCapitalInstallment = mCapitalInstallment.setScale(2, BigDecimal.ROUND_HALF_UP);
        mInterestInstallment = mInterestInstallment.setScale(2, BigDecimal.ROUND_HALF_UP);
        mRemainingDebt = mRemainingDebt.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment that = (Payment) o;
        return getIndex() == that.getIndex()
                && getInstallmentDate().equals(that.getInstallmentDate())
                && getCapitalInstallment().equals(that.getCapitalInstallment())
                && getInterestInstallment().equals(that.getInterestInstallment())
                && getRemainingDebt().equals(that.getRemainingDebt())
                && getInsurancePremiumValue().equals(that.getInsurancePremiumValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getIndex(), getInstallmentDate(), getCapitalInstallment(),
                getInterestInstallment(), getRemainingDebt(),getInsurancePremiumValue()
        );
    }

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
