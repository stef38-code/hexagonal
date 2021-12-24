package org.stephane.tools;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

@Slf4j
public class ReadFile extends RandomData {
    protected List<String> read(String pathFile) {
        Path path = Paths.get(pathFile);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
