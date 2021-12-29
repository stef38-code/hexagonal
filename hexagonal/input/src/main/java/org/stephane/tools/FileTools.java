package org.stephane.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Classe qui permet d'avoir le contenu d'un fichier dans une chaine de caractere
 */
@Slf4j
public class FileTools {

    private FileTools() {
        throw new IllegalStateException("FileTools class");
    }
    /**
     * retourne une chaine du contenu du fichier.
     *
     * @param fileName path du fichier
     * @return retourne le contenu du fichier
     * @throws IOException if read fails for any reason
     */
    public static Optional<String> getResourceFileAsString(String fileName)  {
        String value = null;
        Optional<File> fileRessource = getFileRessource(fileName);
        if(fileRessource.isPresent()) {
            try (InputStream is = new FileInputStream(fileRessource.get())) {
                    try (InputStreamReader isr = new InputStreamReader(is);
                         BufferedReader reader = new BufferedReader(isr)) {
                        value = reader.lines().collect(Collectors.joining(System.lineSeparator()));
                    }
            } catch (IOException e) {
                log.error("Erreur avec le fichier {}", fileName, e);
            }
        }
        return Optional.ofNullable(value);
    }
    /**
     * Gets the file ressource.
     *
     * @param nomFichier the nom fichier object
     * @return the file ressource
     */
    public static Optional<File> getFileRessource(String nomFichier) {
        log.info("fichier de ressources:" + nomFichier);
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:" + nomFichier);
        } catch (FileNotFoundException e) {
            log.error("Fichier {} introuvable !!",nomFichier,e);
        }
        return Optional.ofNullable(file);
    }
}
