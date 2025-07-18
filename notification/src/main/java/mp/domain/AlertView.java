package mp.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "AlertView_table")
@Data
public class AlertView {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String userId;
    private String message;
    private Boolean isRead;
    private Date createdAt;
    private String alertStatus;
}
