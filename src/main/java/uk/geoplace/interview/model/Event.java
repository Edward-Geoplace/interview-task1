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
@Table(name = "EVENT")
@Cacheable(false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "EVENT_ID")
    private BigInteger eventId;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @OneToMany(mappedBy = "event", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    private List<FileDetail> fileDetails;

    @ManyToOne
    @JoinColumn(name = "EVENT_STATUS_ID")
    private EventStatus eventStatus;

    @Column(name = "TEST_SUBMISSION")
    private String testSubmission;

}
