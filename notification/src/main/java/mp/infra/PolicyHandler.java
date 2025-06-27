package mp.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import mp.config.kafka.KafkaProcessor;
import mp.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    알림Repository 알림Repository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='WriterEnrolled'"
    )
    public void wheneverWriterEnrolled_Notify(
        @Payload WriterEnrolled writerEnrolled
    ) {
        WriterEnrolled event = writerEnrolled;
        System.out.println(
            "\n\n##### listener Notify : " + writerEnrolled + "\n\n"
        );

        // Sample Logic //
        알림.notify(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AuditCompleted'"
    )
    public void wheneverAuditCompleted_Notify(
        @Payload AuditCompleted auditCompleted
    ) {
        AuditCompleted event = auditCompleted;
        System.out.println(
            "\n\n##### listener Notify : " + auditCompleted + "\n\n"
        );

        // Sample Logic //
        알림.notify(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookRegistered'"
    )
    public void wheneverBookRegistered_Notify(
        @Payload BookRegistered bookRegistered
    ) {
        BookRegistered event = bookRegistered;
        System.out.println(
            "\n\n##### listener Notify : " + bookRegistered + "\n\n"
        );

        // Sample Logic //
        알림.notify(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
