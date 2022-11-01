package uk.geoplace.interview.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
@Getter
@Setter
@NoArgsConstructor
public class FileDetailDto {

    private BigInteger fileId;
    
    private BigInteger eventId;
    
    private String fileStatus;

    private String fileName;

  
    @QueryProjection
    public FileDetailDto(BigInteger fileId, BigInteger eventId, String fileStatus, String fileName) {
        super();
        this.fileId = fileId;
        this.eventId = eventId;
        this.fileStatus = fileStatus;
        this.fileName = fileName;

    }

}