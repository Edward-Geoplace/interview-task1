package uk.geoplace.interview.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import uk.geoplace.interview.dto.ResultDto;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest

public class EventServiceTest {



    public void getResultEvent_Case1() {

        //Given
        String accountCode = "1111";
        BigInteger eventId = BigInteger.valueOf(1003);

        //When
        //Write your test here

        //then
        //Write your test here

    }


    public void getResultEvent_Case2() {

        //Given
        String accountCode = "2222";
        BigInteger eventId = BigInteger.valueOf(1007);

        //When
        //Write your test here

        //then
        //Write your test here

    }

    public void getResultEvent_Case3() {

        //Given
        String accountCode = "3333";
        BigInteger eventId = BigInteger.valueOf(1013);

        //When
        //Write your test here

        //then
        //Write your test here

    }


    public void getResultEvent_Case4() {

        //Given
        String accountCode = "4444";
        BigInteger eventId = BigInteger.valueOf(1021);

        //When
        //Write your test here

        //then
        //Write your test here

    }


}
