package mp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mp.domain.*;
import mp.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AuditCompleted extends AbstractEvent {

    private Long id;
    private String userId;
    private String info;
    private String status;
    private String portfolioUrl;

    public AuditCompleted(Writer aggregate) {
        super(aggregate);
    }

    public AuditCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
