package org.stephane.domain.entities.builder;

import java.util.HashMap;
import java.util.Map;

public class ErreursValidations {
    private final Map<String,String> erreurs = new HashMap<>();

    public int nombreErreurs() {
        return erreurs.size();
    }

    public void add(String champs,String message){
        erreurs.put(champs,message);
    }
    public Map<String,String> getErreurs(){
        return this.erreurs;
    }
}
