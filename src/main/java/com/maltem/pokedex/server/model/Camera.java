
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
    "cylinderRadius",
    "diskRadius",
    "shoulderModeScale"
})
public class Camera implements Serializable
{

    @JsonProperty("cylinderRadius")
    private Double cylinderRadius;
    @JsonProperty("diskRadius")
    private Double diskRadius;
    @JsonProperty("shoulderModeScale")
    private Double shoulderModeScale;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7322482612846003899L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Camera() {
    }

    /**
     * 
     * @param shoulderModeScale
     * @param diskRadius
     * @param cylinderRadius
     */
    public Camera(Double cylinderRadius, Double diskRadius, Double shoulderModeScale) {
        super();
        this.cylinderRadius = cylinderRadius;
        this.diskRadius = diskRadius;
        this.shoulderModeScale = shoulderModeScale;
    }

    @JsonProperty("cylinderRadius")
    public Double getCylinderRadius() {
        return cylinderRadius;
    }

    @JsonProperty("cylinderRadius")
    public void setCylinderRadius(Double cylinderRadius) {
        this.cylinderRadius = cylinderRadius;
    }

    @JsonProperty("diskRadius")
    public Double getDiskRadius() {
        return diskRadius;
    }

    @JsonProperty("diskRadius")
    public void setDiskRadius(Double diskRadius) {
        this.diskRadius = diskRadius;
    }

    @JsonProperty("shoulderModeScale")
    public Double getShoulderModeScale() {
        return shoulderModeScale;
    }

    @JsonProperty("shoulderModeScale")
    public void setShoulderModeScale(Double shoulderModeScale) {
        this.shoulderModeScale = shoulderModeScale;
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
