package uk.geoplace.interview.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uk.geoplace.interview.dto.FileDetailDto;
import uk.geoplace.interview.model.Event;
import uk.geoplace.interview.model.QAccount;
import uk.geoplace.interview.model.QEvent;
import uk.geoplace.interview.model.QFileDetail;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.math.BigInteger;

@Repository
@Transactional

public class EventRepositoryImpl implements EventRepositoryCustom {

    @Autowired
    private EntityManager entityManager;


    public FileDetailDto getResultEvent(final String accountCode,  final BigInteger currentEventId) {

        // TODO - To update the function

        final JPAQuery<Event> query = new JPAQuery<>(entityManager);
        final QFileDetail fileDetail = QFileDetail.fileDetail;
        final QEvent event = QEvent.event;
        final QAccount account = QAccount.account;



        final FileDetailDto theEvent = query
                .select(Projections.bean(FileDetailDto.class, fileDetail.fileId, fileDetail.event.eventId, fileDetail.fileStatus.fileStatus,
                        fileDetail.fileName))
                .from(fileDetail)
                .fetchFirst();


        return theEvent;
    }


}
