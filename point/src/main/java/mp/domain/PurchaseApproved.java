package mp.domain;

import java.util.*;
import lombok.*;
import mp.domain.*;
import mp.infra.AbstractEvent;

@Data
@ToString
public class PurchaseApproved extends AbstractEvent {

    private Long id;
    private String userId;
    private String item;
    private Long amount;
    private String status;
    private Date createdAt;
}
