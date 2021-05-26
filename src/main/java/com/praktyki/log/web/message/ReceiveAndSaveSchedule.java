package com.praktyki.log.web.message;

import com.praktyki.log.app.data.converters.PaymentConverter;
import com.praktyki.log.app.data.converters.ScheduleCalculationEventConverter;
import com.praktyki.log.app.data.converters.ScheduleConverter;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.app.data.repositories.PaymentsRepository;
import com.praktyki.log.app.data.repositories.ScheduleCalculationEventRepository;
import com.praktyki.log.web.message.models.Schedule;
import com.praktyki.log.web.message.models.ScheduleCalculationEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ReceiveAndSaveSchedule {

    @Autowired
    private PaymentConverter mPaymentConverter;

    @Autowired
    private ScheduleCalculationEventConverter mScheduleCalculationEventConverter;

    @Autowired
    private PaymentsRepository mPaymentsRepository;

    @Autowired
    private ScheduleCalculationEventRepository mScheduleCalculationEventRepository;

    @RabbitListener(queues = "#{getAnonymousQueue.name}")
    public void received(ScheduleCalculationEvent scheduleCalculationEvent) throws InterruptedException {

        ScheduleCalculationEventEntity scheduleCalculationEventEntity =
                mScheduleCalculationEventConverter.convertToEntity(scheduleCalculationEvent);

        mScheduleCalculationEventRepository.save(scheduleCalculationEventEntity);

        mPaymentsRepository.saveAll(
                mPaymentConverter.convertListToEntity(
                        scheduleCalculationEvent.schedule.getPaymentList(),
                        scheduleCalculationEventEntity
                )
        );

    }

}
