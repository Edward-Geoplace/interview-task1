package uk.geoplace.interview.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;


@Entity
@Table(name = "FILE_DETAILS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Cacheable(false)
public class FileDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FILE_ID")
    private BigInteger fileId;

    @Column(name = "FILE_NAME")
    private String fileName;

    @ManyToOne
    @JoinColumn(name = "FILE_STATUS_ID")
    private FileStatus fileStatus;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENT_ID")
    private Event event;





}
