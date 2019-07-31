
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
    "attackProbability",
    "attackTimer",
    "baseFleeRate",
    "baseCaptureRate",
    "cameraDistance",
    "collisionRadius",
    "dodgeDistance",
    "dodgeProbability",
    "jumpTime",
    "maxPokemonActionFrequency",
    "minPokemonActionFrequency",
    "movementType",
    "gender"
})
public class Encounter implements Serializable
{

    @JsonProperty("attackProbability")
    private Double attackProbability;
    @JsonProperty("attackTimer")
    private Integer attackTimer;
    @JsonProperty("baseFleeRate")
    private Double baseFleeRate;
    @JsonProperty("baseCaptureRate")
    private Double baseCaptureRate;
    @JsonProperty("cameraDistance")
    private Double cameraDistance;
    @JsonProperty("collisionRadius")
    private Double collisionRadius;
    @JsonProperty("dodgeDistance")
    private Integer dodgeDistance;
    @JsonProperty("dodgeProbability")
    private Double dodgeProbability;
    @JsonProperty("jumpTime")
    private Double jumpTime;
    @JsonProperty("maxPokemonActionFrequency")
    private Double maxPokemonActionFrequency;
    @JsonProperty("minPokemonActionFrequency")
    private Double minPokemonActionFrequency;
    @JsonProperty("movementType")
    private MovementType movementType;
    @JsonProperty("gender")
    private Gender gender;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8821534061983478238L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Encounter() {
    }

    /**
     * 
     * @param jumpTime
     * @param baseFleeRate
     * @param minPokemonActionFrequency
     * @param collisionRadius
     * @param attackTimer
     * @param maxPokemonActionFrequency
     * @param baseCaptureRate
     * @param cameraDistance
     * @param gender
     * @param dodgeDistance
     * @param movementType
     * @param attackProbability
     * @param dodgeProbability
     */
    public Encounter(Double attackProbability, Integer attackTimer, Double baseFleeRate, Double baseCaptureRate, Double cameraDistance, Double collisionRadius, Integer dodgeDistance, Double dodgeProbability, Double jumpTime, Double maxPokemonActionFrequency, Double minPokemonActionFrequency, MovementType movementType, Gender gender) {
        super();
        this.attackProbability = attackProbability;
        this.attackTimer = attackTimer;
        this.baseFleeRate = baseFleeRate;
        this.baseCaptureRate = baseCaptureRate;
        this.cameraDistance = cameraDistance;
        this.collisionRadius = collisionRadius;
        this.dodgeDistance = dodgeDistance;
        this.dodgeProbability = dodgeProbability;
        this.jumpTime = jumpTime;
        this.maxPokemonActionFrequency = maxPokemonActionFrequency;
        this.minPokemonActionFrequency = minPokemonActionFrequency;
        this.movementType = movementType;
        this.gender = gender;
    }

    @JsonProperty("attackProbability")
    public Double getAttackProbability() {
        return attackProbability;
    }

    @JsonProperty("attackProbability")
    public void setAttackProbability(Double attackProbability) {
        this.attackProbability = attackProbability;
    }

    @JsonProperty("attackTimer")
    public Integer getAttackTimer() {
        return attackTimer;
    }

    @JsonProperty("attackTimer")
    public void setAttackTimer(Integer attackTimer) {
        this.attackTimer = attackTimer;
    }

    @JsonProperty("baseFleeRate")
    public Double getBaseFleeRate() {
        return baseFleeRate;
    }

    @JsonProperty("baseFleeRate")
    public void setBaseFleeRate(Double baseFleeRate) {
        this.baseFleeRate = baseFleeRate;
    }

    @JsonProperty("baseCaptureRate")
    public Double getBaseCaptureRate() {
        return baseCaptureRate;
    }

    @JsonProperty("baseCaptureRate")
    public void setBaseCaptureRate(Double baseCaptureRate) {
        this.baseCaptureRate = baseCaptureRate;
    }

    @JsonProperty("cameraDistance")
    public Double getCameraDistance() {
        return cameraDistance;
    }

    @JsonProperty("cameraDistance")
    public void setCameraDistance(Double cameraDistance) {
        this.cameraDistance = cameraDistance;
    }

    @JsonProperty("collisionRadius")
    public Double getCollisionRadius() {
        return collisionRadius;
    }

    @JsonProperty("collisionRadius")
    public void setCollisionRadius(Double collisionRadius) {
        this.collisionRadius = collisionRadius;
    }

    @JsonProperty("dodgeDistance")
    public Integer getDodgeDistance() {
        return dodgeDistance;
    }

    @JsonProperty("dodgeDistance")
    public void setDodgeDistance(Integer dodgeDistance) {
        this.dodgeDistance = dodgeDistance;
    }

    @JsonProperty("dodgeProbability")
    public Double getDodgeProbability() {
        return dodgeProbability;
    }

    @JsonProperty("dodgeProbability")
    public void setDodgeProbability(Double dodgeProbability) {
        this.dodgeProbability = dodgeProbability;
    }

    @JsonProperty("jumpTime")
    public Double getJumpTime() {
        return jumpTime;
    }

    @JsonProperty("jumpTime")
    public void setJumpTime(Double jumpTime) {
        this.jumpTime = jumpTime;
    }

    @JsonProperty("maxPokemonActionFrequency")
    public Double getMaxPokemonActionFrequency() {
        return maxPokemonActionFrequency;
    }

    @JsonProperty("maxPokemonActionFrequency")
    public void setMaxPokemonActionFrequency(Double maxPokemonActionFrequency) {
        this.maxPokemonActionFrequency = maxPokemonActionFrequency;
    }

    @JsonProperty("minPokemonActionFrequency")
    public Double getMinPokemonActionFrequency() {
        return minPokemonActionFrequency;
    }

    @JsonProperty("minPokemonActionFrequency")
    public void setMinPokemonActionFrequency(Double minPokemonActionFrequency) {
        this.minPokemonActionFrequency = minPokemonActionFrequency;
    }

    @JsonProperty("movementType")
    public MovementType getMovementType() {
        return movementType;
    }

    @JsonProperty("movementType")
    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    @JsonProperty("gender")
    public Gender getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(Gender gender) {
        this.gender = gender;
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
