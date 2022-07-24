
package com.works.props;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class User {

    private Boolean durum;
    private String mesaj;
    private Bilgiler bilgiler;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Boolean getDurum() {
        return durum;
    }

    public void setDurum(Boolean durum) {
        this.durum = durum;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public Bilgiler getBilgiler() {
        return bilgiler;
    }

    public void setBilgiler(Bilgiler bilgiler) {
        this.bilgiler = bilgiler;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
