package com.praktyki.log.web.message;

import com.praktyki.log.app.data.converters.PaymentConverter;
import com.praktyki.log.app.data.converters.ScheduleCalculationEventConverter;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.app.data.repositories.PaymentsRepository;
import com.praktyki.log.app.data.repositories.ScheduleCalculationEventRepository;
import com.praktyki.log.web.message.models.ScheduleCalculationEventModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public void received(ScheduleCalculationEventModel scheduleCalculationEventModel) throws InterruptedException {

        ScheduleCalculationEventEntity scheduleCalculationEventEntity =
                mScheduleCalculationEventConverter.convertToEntity(scheduleCalculationEventModel);

        mScheduleCalculationEventRepository.save(scheduleCalculationEventEntity);

        mPaymentsRepository.saveAll(
                mPaymentConverter.convertListToEntity(
                        scheduleCalculationEventModel.schedule.payments,
                        scheduleCalculationEventEntity
                )
        );

    }

}
