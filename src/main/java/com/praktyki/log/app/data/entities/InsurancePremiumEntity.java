package com.praktyki.log.app.data.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "insurance_premiums")
public class InsurancePremiumEntity {

    @EmbeddedId
    public ScheduleCalculationEventPK scheduleCalculationEventPK;

    @Column(name = "insurance_premium_index")
    public int insurancePremiumIndex;

    @Column(name = "insurance_premium_date")
    public LocalDate insurancePremiumDate;

    @Column(name = "insurance_premium_value")
    public BigDecimal insurancePremiumValue;

    public InsurancePremiumEntity(
            ScheduleCalculationEventPK scheduleCalculationEventPK, int insurancePremiumIndex,
            LocalDate insurancePremiumDate, BigDecimal insurancePremiumValue)
    {
        this.scheduleCalculationEventPK = scheduleCalculationEventPK;
        this.insurancePremiumIndex = insurancePremiumIndex;
        this.insurancePremiumDate = insurancePremiumDate;
        this.insurancePremiumValue = insurancePremiumValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(insurancePremiumIndex, insurancePremiumDate, insurancePremiumValue);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InsurancePremium {\n");

        sb.append("    index: ").append(toIndentedString(insurancePremiumIndex)).append("\n");
        sb.append("    date: ").append(toIndentedString(insurancePremiumDate)).append("\n");
        sb.append("    amount: ").append(toIndentedString(insurancePremiumValue)).append("\n");
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
