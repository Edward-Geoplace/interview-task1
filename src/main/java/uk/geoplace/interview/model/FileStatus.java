package uk.geoplace.interview.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;


@Entity
@Table(name = "FILE_STATUS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FILE_STATUS_ID")
    private BigInteger fileStatusId;

    @Column(name = "FILE_STATUS")
    private String fileStatus;

}
