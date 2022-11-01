package uk.geoplace.interview.repository;

import uk.geoplace.interview.dto.FileDetailDto;

import java.math.BigInteger;

public interface EventRepositoryCustom {

    FileDetailDto getResultEvent(String accountCode, BigInteger currentEventId);
}
