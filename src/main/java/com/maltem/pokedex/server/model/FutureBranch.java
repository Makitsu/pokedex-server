
package com.maltem.pokedex.server.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
    "futureBranches",
    "costToEvolve"
})
public class FutureBranch implements Serializable
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("futureBranches")
    private List<FutureBranch_> futureBranches = null;
    @JsonProperty("costToEvolve")
    private CostToEvolve_ costToEvolve;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3411602555470385470L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FutureBranch() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param costToEvolve
     * @param futureBranches
     */
    public FutureBranch(String name, String id, List<FutureBranch_> futureBranches, CostToEvolve_ costToEvolve) {
        super();
        this.name = name;
        this.id = id;
        this.futureBranches = futureBranches;
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

    @JsonProperty("futureBranches")
    public List<FutureBranch_> getFutureBranches() {
        return futureBranches;
    }

    @JsonProperty("futureBranches")
    public void setFutureBranches(List<FutureBranch_> futureBranches) {
        this.futureBranches = futureBranches;
    }

    @JsonProperty("costToEvolve")
    public CostToEvolve_ getCostToEvolve() {
        return costToEvolve;
    }

    @JsonProperty("costToEvolve")
    public void setCostToEvolve(CostToEvolve_ costToEvolve) {
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
