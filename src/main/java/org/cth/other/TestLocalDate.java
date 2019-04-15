package org.cth.other;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class TestLocalDate {
    private Logger log = LoggerFactory.getLogger(TestLocalDate.class);

    public void test() {
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.now();
        LocalDate ldt1 = ldt.toLocalDate();
        log.info(">>> " + ld + " >>> " + lt);
        log.info(">>> " + ldt + " >>> " + ldt1);
    }
}
