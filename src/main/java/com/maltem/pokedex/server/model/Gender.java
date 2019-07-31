
package com.maltem.pokedex.server.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "malePercent",
    "femalePercent"
})
public class Gender implements Serializable
{

    @JsonProperty("malePercent")
    private Double malePercent;
    @JsonProperty("femalePercent")
    private Double femalePercent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 1625811622979859997L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Gender() {
    }

    /**
     * 
     * @param malePercent
     * @param femalePercent
     */
    public Gender(Double malePercent, Double femalePercent) {
        super();
        this.malePercent = malePercent;
        this.femalePercent = femalePercent;
    }

    @JsonProperty("malePercent")
    public Double getMalePercent() {
        return malePercent;
    }

    @JsonProperty("malePercent")
    public void setMalePercent(Double malePercent) {
        this.malePercent = malePercent;
    }

    @JsonProperty("femalePercent")
    public Double getFemalePercent() {
        return femalePercent;
    }

    @JsonProperty("femalePercent")
    public void setFemalePercent(Double femalePercent) {
        this.femalePercent = femalePercent;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
