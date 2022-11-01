package uk.geoplace.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import uk.geoplace.interview.model.Event;

import java.math.BigInteger;


public interface EventRepository extends JpaRepository<Event, BigInteger>,  EventRepositoryCustom, QuerydslPredicateExecutor<Event> {


}
