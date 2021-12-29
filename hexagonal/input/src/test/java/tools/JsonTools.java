package tools;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
public class JsonTools {
    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Map to string.
     *
     * @param object the object
     * @return the string
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static String parseObjectAsJsonString(Object object) throws IOException {
        ObjectMapper objMapper = new ObjectMapper();
        objMapper.registerModule(new JavaTimeModule());
        objMapper.registerModule(new Jdk8Module());
        objMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        StringWriter stringWriter = new StringWriter();
        objMapper.writeValue(stringWriter, object);

        return stringWriter.toString();
    }

    /**
     * Write object to json file.
     *
     * @param <T> the generic type
     * @param obj the obj
     * @return true, if successful
     */
    public static <T> boolean writeObjectToJsonFile(T obj) {
        String nomFichierObject = obj.getClass().getSimpleName();// + EXTENSION_FILE;
        return writeObjectToJsonFile(obj, nomFichierObject);
    }

    /**
     * Write object to json file.
     *
     * @param <T>        the generic type
     * @param obj        the obj
     * @param nomFichier the nom fichier
     * @return true, if successful
     */
    public static <T> boolean writeObjectToJsonFile(T obj, String nomFichier) {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String nomFichierObject = nomFichier;//+ EXTENSION_FILE;
        File file = getFileRessource(nomFichierObject);

        boolean status = true;
        try {
            mapper.writeValue(file, obj);
        } catch (IOException e) {
            e.printStackTrace();
            status = false;
        }
        return status;
    }

    /**
     * Read object to json file.
     *
     * @param <T>        the generic type
     * @param obj        the obj
     * @param nomFichier the nom fichier
     * @return the t
     */
    @SuppressWarnings("unchecked")
    public static <T> T readObjectToJsonFile(T obj, String nomFichier) {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String nomFichierObject = nomFichier;//+ EXTENSION_FILE;
        File file = getFileRessource(nomFichierObject);
        log.info("fichier de ressources:" + file.getAbsolutePath());
        try {
            return (T) mapper.readValue(file, obj.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Read object to json file.
     *
     * @param <T> the generic type
     * @param obj the obj
     * @return the t
     */
    public static <T> T readObjectToJsonFile(T obj) {
        String nomFichierObject = obj.getClass().getSimpleName();
        return readObjectToJsonFile(obj, nomFichierObject);
    }

    /**
     * Gets the file ressource.
     *
     * @param <T>              the generic type
     * @param nomFichierObject the nom fichier object
     * @return the file ressource
     */
    private static <T> File getFileRessource(String nomFichierObject) {
        log.info("fichier de ressources:" + nomFichierObject);
        try {
            return ResourceUtils.getFile("classpath:" + nomFichierObject);
        } catch (FileNotFoundException e) {
            log.error("Fichier {} introuvable !!",nomFichierObject,e);
            return null;
        }
    }

    /**
     * Parses the json string to list object.
     *
     * @param <T>     the generic type
     * @param content the content
     * @param clazz   the clazz
     * @return the list
     * @throws JsonParseException   the json parse exception
     * @throws JsonMappingException the json mapping exception
     * @throws IOException          Signals that an I/O exception has occurred.
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> parseJsonStringToListObject(String content, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        T obj = mapper.readValue(content, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        return (List<T>) obj;

    }

    /**
     * Map reponse to object.
     *
     * @param <T>          the generic type
     * @param jsonResponse the json response
     * @param valueType    the value type
     * @return the t
     * @throws JsonProcessingException the json processing exception
     * @throws JsonMappingException    the json mapping exception
     */
    public static <T> T parseJsonStringToObject(String jsonResponse, Class<T> valueType)
            throws JsonProcessingException, JsonMappingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonResponse, valueType);
    }

    public static <T> List<T> jsonArrayToObjectList(String jsonFileName, Class<T> tClass)  {
        ObjectMapper mapper = new ObjectMapper();
        final File file = getFileRessource(jsonFileName);
        CollectionType listType = mapper.getTypeFactory()
                .constructCollectionType(ArrayList.class, tClass);
        List<T> ts = null;
        try {
            ts = mapper.readValue(file, listType);
        } catch (IOException e) {
           log.error("Erreur lecture du fichier: {}",jsonFileName,e);
           return Collections.EMPTY_LIST;
        }
        return ts;
    }
}
