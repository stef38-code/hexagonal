package org.stephane.tools;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
public class ReadFile extends RandomData {
    protected List<String> read(String pathFile) {
        try {
            Path path = Paths.get(Objects.requireNonNull(this.getClass().getResource(pathFile)).toURI());
            return Files.readAllLines(path, Charset.defaultCharset());
        } catch (IOException | URISyntaxException e) {
            return Collections.emptyList();
        }
    }
}
