package org.stephane.tools;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class RandomData {
    @Getter
    private final Random rand;

    public RandomData() {
        rand = getSecureRandom();
    }

    protected Random getSecureRandom() {
        return createSecureRandom();
    }
    private static Random createSecureRandom() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException nae) {
            log.warn("Couldn't create strong secure random generator; reason: {}.", nae.getMessage());
            return new SecureRandom();
        }
    }
    protected LocalDate randomLocalDate(LocalDate startDate, LocalDate endDate) {

        long start = startDate.toEpochDay();
        long end = endDate.toEpochDay();
        long randomEpochDay = ThreadLocalRandom.current().nextLong(start, end);
        return LocalDate.ofEpochDay(randomEpochDay);
    }
}
