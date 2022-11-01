package uk.geoplace.interview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.geoplace.interview.dto.FileDetailDto;
import uk.geoplace.interview.dto.ResultDto;
import uk.geoplace.interview.repository.EventRepository;
import uk.geoplace.interview.repository.FileDetailRepository;

import java.math.BigInteger;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private FileDetailRepository fdRepository;

    ResultDto getResultEvent(final String accountCode, final BigInteger currentEventId) {

        // TODO - To update the function
        FileDetailDto dto = eventRepository.getResultEvent(accountCode, currentEventId);
        boolean flag = false;

        return new ResultDto(dto.getEventId(), flag);
    }

}
