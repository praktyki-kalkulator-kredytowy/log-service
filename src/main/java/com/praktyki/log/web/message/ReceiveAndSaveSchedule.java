package com.praktyki.log.web.message;

import com.praktyki.log.app.data.converters.PaymentConverter;
import com.praktyki.log.app.data.converters.ScheduleCalculationEventDetailsConverter;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.app.data.repositories.PaymentsRepository;
import com.praktyki.log.app.data.repositories.ScheduleCalculationEventRepository;
import com.praktyki.log.web.message.models.ScheduleCalculationEventDetailsModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceiveAndSaveSchedule {

    @Autowired
    private PaymentConverter mPaymentConverter;

    @Autowired
    private ScheduleCalculationEventDetailsConverter mScheduleCalculationEventDetailsConverter;

    @Autowired
    private PaymentsRepository mPaymentsRepository;

    @Autowired
    private ScheduleCalculationEventRepository mScheduleCalculationEventRepository;

    @RabbitListener(queues = "#{getAnonymousQueue.name}")
    public void received(ScheduleCalculationEventDetailsModel scheduleCalculationEventDetailsModel) throws InterruptedException {

        ScheduleCalculationEventEntity scheduleCalculationEventEntity =
                mScheduleCalculationEventDetailsConverter.convertToEntity(scheduleCalculationEventDetailsModel);

        mScheduleCalculationEventRepository.save(scheduleCalculationEventEntity);

        mPaymentsRepository.saveAll(
                mPaymentConverter.convertListToEntity(
                        scheduleCalculationEventDetailsModel.schedule.payments,
                        scheduleCalculationEventEntity
                )
        );

    }

}
