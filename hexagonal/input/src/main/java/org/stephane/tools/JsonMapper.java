package org.stephane.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe de mapping json
 * - obj vers json
 * - json vers obj
 * - fichier json vers obj
 * - obj vers fichier json
 */
@Slf4j
public class JsonMapper {
    public JsonMapper() {
    }

    private ObjectMapper getObjectMapper() {
        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .registerModule(new Jdk8Module())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    /**
     * Convertir un objet en une string json
     *
     * @param value l'objet a convertir
     * @return Optional de string String si conversion réussit
     */
    public Optional<String> toString(final Object value) {
        String string = null;
        try {
            string = getObjectMapper().writeValueAsString(value);
        } catch (JsonProcessingException e) {
            log.error("Erreur de conversion du type de classe {}", value.getClass().getSimpleName(), e);
        }
        return Optional.ofNullable(string);
    }

    /**
     * Convertir une chaine json en un objet
     * @param contentJson le contenu json
     * @param valueType le type de la classe qui compose le contenu json
     * @param <T> le type de la classe qui compose le contenu json
     * @return retourne optional de T
     */
    public <T> Optional<T> toObject(String contentJson, Class<T> valueType){
        T value = null;
        try {
            value = getObjectMapper().readValue(contentJson, valueType);
        } catch (JsonProcessingException e) {
            log.error("Erreur de conversion en {} de la chaine suivante : {}",valueType.getSimpleName(), contentJson, e);
        }
        return Optional.ofNullable(value);
    }
    /**
     * Convertir une chaine json en un list d'objet
     *
     * @param contentJson le contenu json
     * @param valueType       le type de la classe qui compose la liste
     * @param <T>         le type de la classe qui compose la liste
     * @return retourne optional de List
     */
    public <T> Optional<List<T>> toObjectList(String contentJson, Class<T> valueType) {
        ObjectMapper mapper = getObjectMapper();
        CollectionType listType = mapper.getTypeFactory()
                .constructCollectionType(ArrayList.class, valueType);
        List<T> values = null;
        try {
            values = mapper.readValue(contentJson, listType);
        } catch (IOException e) {
            log.error("Erreur de conversion en List<{}> de la chaine suivante : {}",valueType.getSimpleName(), contentJson, e);
        }
        return Optional.ofNullable(values);
    }

    /**
     * Ecrire un objet dans un fichier au format json
     * @param obj l'objet a ecrire
     * @param nomFichier le fichier de sortie
     * @param <T> le type de l'objet
     * @return true si ok sinon false
     */
    public <T> boolean objectToFile(T obj, String nomFichier) {
        Optional<File> fileRessource = FileTools.getFileRessource(nomFichier);
        if(fileRessource.isPresent()){
            try {
                getObjectMapper().writeValue(fileRessource.get(), obj);
                return true;
            } catch (IOException e) {
                log.error("Erreur avec le fichier {}", nomFichier, e);
            }
        }
        return false;
    }

    /**
     * convertir le contenu du fichier json en obj
     * @param valueType le type de l'objet
     * @param nomFichier le path du fichier
     * @param <T> le type de l'objet
     * @return Optional avec un obj T
     */
    public <T> Optional<T> fileToObject(Class<T> valueType, String nomFichier) {
        Optional<String> content = FileTools.getResourceFileAsString(nomFichier);
        if(content.isPresent()){
            return toObject(content.get(), valueType);
        }
        return Optional.empty();
    }

    /**
     * convertir le contenu du fichier json en List de T
     * @param valueType valueType le type de l'objet contenu dans la list
     * @param nomFichier path du fichier
     * @param <T> valueType le type de l'objet contenu dans la list
     * @return Une liste de type T dans un Optional
     */
    public <T> Optional<List<T>> fileToListObject(Class<T> valueType, String nomFichier) {
        Optional<String> content = FileTools.getResourceFileAsString(nomFichier);
        if(content.isPresent()){
            return toObjectList(content.get(), valueType);
        }
        return Optional.empty();
    }
}
