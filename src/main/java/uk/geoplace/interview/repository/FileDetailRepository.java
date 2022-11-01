package uk.geoplace.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uk.geoplace.interview.model.FileDetail;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface FileDetailRepository extends JpaRepository<FileDetail, BigInteger> {

    @Query("SELECT t FROM FileDetail t WHERE t.event.eventId = ?1")
    List<FileDetail> findByEvent(final BigInteger eventId);

}
