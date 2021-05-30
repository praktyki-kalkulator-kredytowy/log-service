package com.praktyki.log.web.controllers;

import com.praktyki.log.app.data.converters.ScheduleCalculationEventConverter;
import com.praktyki.log.app.data.converters.ScheduleCalculationEventDetailsConverter;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.app.data.repositories.ScheduleCalculationEventRepository;
import com.praktyki.log.app.interactors.AuditDataInteractor;
import com.praktyki.log.web.exceptions.NotSuchEntityException;
import com.praktyki.log.web.message.models.ScheduleCalculationEventDetailsModel;
import com.praktyki.log.web.message.models.ScheduleCalculationEventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@Validated
public class AuditDataController {

    @Autowired
    private ScheduleCalculationEventRepository mScheduleCalculationEventRepository;

    @Autowired
    private ScheduleCalculationEventDetailsConverter mScheduleCalculationEventDetailsConverter;

    @Autowired
    private ScheduleCalculationEventConverter mScheduleCalculationEventConverter;

    @Autowired
    private AuditDataInteractor mAuditDataInteractor;


    @GetMapping("/api/v1/audit")
    public List<ScheduleCalculationEventModel> getFilteredEvents(
            @RequestParam(value = "calculationStartDate", required = false)
            @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate calculationStartDate,
            @RequestParam(value = "calculationEndDate", required = false)
            @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate calculationEndDate,
            @RequestParam(value = "withdrawalStartDate", required = false)
            @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate withdrawalStartDate,
            @RequestParam(value = "withdrawalEndDate", required = false)
            @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate withdrawalEndDate,
            @RequestParam(value = "capitalStart", required = false) Double capitalStart,
            @RequestParam(value = "capitalEnd", required = false) Double capitalEnd,
            @RequestParam(value = "installmentAmountStart", required = false) Integer installmentAmountStart,
            @RequestParam(value = "installmentAmountEnd", required = false) Integer installmentAmountEnd,
            @RequestParam(value = "interestRateStart", required = false) Double interestRateStart,
            @RequestParam(value = "interestRateEnd", required = false) Double interestRateEnd,
            @RequestParam(value = "insuranceSumStart", required = false) Double insuranceSumStart,
            @RequestParam(value = "insuranceSumEnd", required = false) Double insuranceSumEnd,
            @RequestParam(value = "clientAgeStart", required = false) Integer clientAgeStart,
            @RequestParam(value = "clientAgeEnd", required = false) Integer clientAgeEnd,
            @RequestParam(value = "aprcStart", required = false) Double aprcStart,
            @RequestParam(value = "aprcEnd", required = false) Double aprcEnd
    )
    {

        Collection<ScheduleCalculationEventEntity> events = mAuditDataInteractor.filterAuditData(
                calculationStartDate, calculationEndDate,
                withdrawalStartDate, withdrawalEndDate,
                capitalStart, capitalEnd,
                installmentAmountStart, installmentAmountEnd,
                interestRateStart, interestRateEnd,
                insuranceSumStart, insuranceSumEnd,
                clientAgeStart, clientAgeEnd,
                aprcStart, aprcEnd
        );

        return events.stream().map(mScheduleCalculationEventConverter::convertToModel).collect(Collectors.toList());
    }

    @GetMapping("/api/v1/audit/{id}")
    public ScheduleCalculationEventDetailsModel getEventById(@Valid @Min(0) @PathVariable int id) throws NotSuchEntityException {
        ScheduleCalculationEventEntity event = mAuditDataInteractor.getEventById(id);
        return mScheduleCalculationEventDetailsConverter.convertToModel(event);
    }

}
