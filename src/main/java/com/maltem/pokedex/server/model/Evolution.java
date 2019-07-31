
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
    "futureBranches",
    "pastBranch",
    "costToEvolve"
})
public class Evolution implements Serializable
{

    @JsonProperty("futureBranches")
    private List<FutureBranch> futureBranches = null;
    @JsonProperty("pastBranch")
    private PastBranch pastBranch;
    @JsonProperty("costToEvolve")
    private CostToEvolve__ costToEvolve;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8000881336186899781L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Evolution() {
    }

    /**
     * 
     * @param costToEvolve
     * @param pastBranch
     * @param futureBranches
     */
    public Evolution(List<FutureBranch> futureBranches, PastBranch pastBranch, CostToEvolve__ costToEvolve) {
        super();
        this.futureBranches = futureBranches;
        this.pastBranch = pastBranch;
        this.costToEvolve = costToEvolve;
    }

    @JsonProperty("futureBranches")
    public List<FutureBranch> getFutureBranches() {
        return futureBranches;
    }

    @JsonProperty("futureBranches")
    public void setFutureBranches(List<FutureBranch> futureBranches) {
        this.futureBranches = futureBranches;
    }

    @JsonProperty("pastBranch")
    public PastBranch getPastBranch() {
        return pastBranch;
    }

    @JsonProperty("pastBranch")
    public void setPastBranch(PastBranch pastBranch) {
        this.pastBranch = pastBranch;
    }

    @JsonProperty("costToEvolve")
    public CostToEvolve__ getCostToEvolve() {
        return costToEvolve;
    }

    @JsonProperty("costToEvolve")
    public void setCostToEvolve(CostToEvolve__ costToEvolve) {
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
