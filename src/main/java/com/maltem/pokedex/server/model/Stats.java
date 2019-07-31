
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
    "baseAttack",
    "baseDefense",
    "baseStamina"
})
public class Stats implements Serializable
{

    @JsonProperty("baseAttack")
    private Integer baseAttack;
    @JsonProperty("baseDefense")
    private Integer baseDefense;
    @JsonProperty("baseStamina")
    private Integer baseStamina;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6834401988336535227L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Stats() {
    }

    /**
     * 
     * @param baseAttack
     * @param baseStamina
     * @param baseDefense
     */
    public Stats(Integer baseAttack, Integer baseDefense, Integer baseStamina) {
        super();
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.baseStamina = baseStamina;
    }

    @JsonProperty("baseAttack")
    public Integer getBaseAttack() {
        return baseAttack;
    }

    @JsonProperty("baseAttack")
    public void setBaseAttack(Integer baseAttack) {
        this.baseAttack = baseAttack;
    }

    @JsonProperty("baseDefense")
    public Integer getBaseDefense() {
        return baseDefense;
    }

    @JsonProperty("baseDefense")
    public void setBaseDefense(Integer baseDefense) {
        this.baseDefense = baseDefense;
    }

    @JsonProperty("baseStamina")
    public Integer getBaseStamina() {
        return baseStamina;
    }

    @JsonProperty("baseStamina")
    public void setBaseStamina(Integer baseStamina) {
        this.baseStamina = baseStamina;
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
