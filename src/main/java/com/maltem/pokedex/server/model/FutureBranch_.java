
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
    "name",
    "id",
    "costToEvolve"
})
public class FutureBranch_ implements Serializable
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("costToEvolve")
    private CostToEvolve costToEvolve;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -417508014710747880L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FutureBranch_() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param costToEvolve
     */
    public FutureBranch_(String name, String id, CostToEvolve costToEvolve) {
        super();
        this.name = name;
        this.id = id;
        this.costToEvolve = costToEvolve;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("costToEvolve")
    public CostToEvolve getCostToEvolve() {
        return costToEvolve;
    }

    @JsonProperty("costToEvolve")
    public void setCostToEvolve(CostToEvolve costToEvolve) {
        this.costToEvolve = costToEvolve;
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
