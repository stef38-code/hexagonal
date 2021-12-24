package org.stephane.tools;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Slf4j
public class ReadFile {
    protected List<String> read(String pathFile) {
        Path path = Paths.get(pathFile);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
    private static Random createSecureRandom() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException nae) {
            log.warn("Couldn't create strong secure random generator; reason: {}.", nae.getMessage());
            return new SecureRandom();
        }
    }
    protected Random getSecureRandom() {
       return createSecureRandom();
    }
}
