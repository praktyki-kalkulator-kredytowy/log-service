package com.praktyki.log.web.controllers;

import com.praktyki.log.app.data.converters.ScheduleCalculationEventConverter;
import com.praktyki.log.app.data.converters.ScheduleCalculationEventDetailsConverter;
import com.praktyki.log.app.data.entities.PaymentEntity;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.app.data.repositories.PaymentsRepository;
import com.praktyki.log.app.data.repositories.ScheduleCalculationEventRepository;
import com.praktyki.log.web.exceptions.NotSuchEntityException;
import com.praktyki.log.web.message.models.ScheduleCalculationEventDetailsModel;
import com.praktyki.log.web.message.models.ScheduleCalculationEventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@CrossOrigin
@RestController
@Validated
public class AuditDataController {

    @Autowired
    private ScheduleCalculationEventRepository mScheduleCalculationEventRepository;

    @Autowired
    private PaymentsRepository mPaymentsRepository;

    @Autowired
    private ScheduleCalculationEventDetailsConverter mScheduleCalculationEventDetailsConverter;

    @Autowired
    private ScheduleCalculationEventConverter mScheduleCalculationEventConverter;


    @GetMapping("/api/v1/audit")
    public List<ScheduleCalculationEventModel> getFilteredEvents(
            @RequestParam(value = "calculationStartDate", required = false) LocalDate calculationStartDate,
            @RequestParam(value = "calculationEndDate", required = false) LocalDate calculationEndDate,
            @RequestParam(value = "withdrawalStartDate", required = false) LocalDate withdrawalStartDate,
            @RequestParam(value = "withdrawalEndDate", required = false) LocalDate withdrawalEndDate,
            @RequestParam(value = "capitalStart", required = false) BigDecimal capitalStart,
            @RequestParam(value = "capitalEnd", required = false) BigDecimal capitalEnd,
            @RequestParam(value = "installmentAmountStart", required = false) BigDecimal installmentAmountStart,
            @RequestParam(value = "installmentAmountEnd", required = false) BigDecimal installmentAmountEnd,
            @RequestParam(value = "interestRateStart", required = false) Double interestRateStart,
            @RequestParam(value = "interestRateEnd", required = false) Double interestRateEnd,
            @RequestParam(value = "insuranceSumStart", required = false) BigDecimal insuranceSumStart,
            @RequestParam(value = "insuranceSumEnd", required = false) BigDecimal insuranceSumEnd,
            @RequestParam(value = "clientAgeStart", required = false) Integer clientAgeStart,
            @RequestParam(value = "clientAgeEnd", required = false) Integer clientAgeEnd,
            @RequestParam(value = "aprcStart", required = false) Double aprcStart,
            @RequestParam(value = "aprcEnd", required = false) Double aprcEnd
    )
    {

        List<ScheduleCalculationEventModel> scheduleCalculationEventModels = new LinkedList<>();
        Iterable<ScheduleCalculationEventEntity> scheduleCalculationEventEntityIterator =
                mScheduleCalculationEventRepository.findAll();

        for(ScheduleCalculationEventEntity sce : scheduleCalculationEventEntityIterator) {

            scheduleCalculationEventModels.add(
                    mScheduleCalculationEventConverter.convertToModel(sce)
            );

        }

        return scheduleCalculationEventModels;

    }

    @GetMapping("/api/v1/audit/{id}")
    public ScheduleCalculationEventDetailsModel getEventById(@Valid @Min(1) @PathVariable int id)
            throws NotSuchEntityException {

        ScheduleCalculationEventEntity scheduleCalculationEventEntity =
                mScheduleCalculationEventRepository.findById(id).orElseThrow(NotSuchEntityException::new);

        List<PaymentEntity> paymentEntityList = new LinkedList<>();
        Iterable<PaymentEntity> paymentEntityIterator =
                mPaymentsRepository.getAllPaymentsByEventId(scheduleCalculationEventEntity.eventId);
        for(PaymentEntity pe: paymentEntityIterator)
            paymentEntityList.add(pe);

        return mScheduleCalculationEventDetailsConverter.convertToModel(scheduleCalculationEventEntity, paymentEntityList);

    }

}
