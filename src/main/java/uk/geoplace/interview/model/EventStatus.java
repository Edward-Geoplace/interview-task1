package uk.geoplace.interview.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;


@Entity
@Table(name = "EVENT_STATUS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "EVENT_STATUS_ID")
    private BigInteger eventStatusId;

    @Column(name = "EVENT_STATUS")
    private String eventStatus;

    @OneToMany(mappedBy = "eventStatus")
    private List<Event> events;


}
