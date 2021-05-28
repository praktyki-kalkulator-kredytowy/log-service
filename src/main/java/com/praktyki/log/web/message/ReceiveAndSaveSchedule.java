package com.praktyki.log.web.message;

import com.praktyki.log.app.data.converters.PaymentConverter;
import com.praktyki.log.app.data.converters.ScheduleCalculationEventDetailsConverter;
import com.praktyki.log.app.data.entities.ScheduleCalculationEventEntity;
import com.praktyki.log.app.interactors.AuditDataInteractor;
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
    private AuditDataInteractor mAuditDataInteractor;

    @RabbitListener(queues = "#{getAnonymousQueue.name}")
    public void received(ScheduleCalculationEventDetailsModel scheduleCalculationEventDetailsModel) throws InterruptedException {

        ScheduleCalculationEventEntity scheduleCalculationEventEntity =
                mScheduleCalculationEventDetailsConverter.convertToEntity(scheduleCalculationEventDetailsModel);

        mAuditDataInteractor.saveEvent(scheduleCalculationEventEntity);
    }

}
