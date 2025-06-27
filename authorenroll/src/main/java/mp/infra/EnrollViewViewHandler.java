package mp.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import mp.config.kafka.KafkaProcessor;
import mp.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class EnrollViewViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private EnrollViewRepository enrollViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAuthorEnrolled_then_CREATE_1(
        @Payload AuthorEnrolled authorEnrolled
    ) {
        try {
            if (!authorEnrolled.validate()) return;

            // view 객체 생성
            EnrollView enrollView = new EnrollView();
            // view 객체에 이벤트의 Value 를 set 함
            enrollView.setUserId(authorEnrolled.getUserId());
            enrollView.setInfo(authorEnrolled.getInfo());
            enrollView.setPortfolioUrl(authorEnrolled.getPortfolioUrl());
            enrollView.setStatus(authorEnrolled.getStatus());
            // view 레파지 토리에 save
            enrollViewRepository.save(enrollView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAuditCompleted_then_UPDATE_1(
        @Payload AuditCompleted auditCompleted
    ) {
        try {
            if (!auditCompleted.validate()) return;
            // view 객체 조회

            List<EnrollView> enrollViewList = enrollViewRepository.findByUserId(
                auditCompleted.getUserId()
            );
            for (EnrollView enrollView : enrollViewList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                enrollView.setEnrollStatus(AuditCompleted);
                // view 레파지 토리에 save
                enrollViewRepository.save(enrollView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
