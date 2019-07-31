
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
    "dex",
    "name",
    "animationTime",
    "height",
    "modelHeight",
    "kmBuddyDistance",
    "weight",
    "modelScale",
    "maxCP",
    "buddySize",
    "cinematicMoves",
    "quickMoves",
    "family",
    "stats",
    "types",
    "encounter",
    "camera",
    "evolution",
    "id",
    "forms"
})
public class Pokemon implements Serializable
{

    @JsonProperty("dex")
    private Integer dex;
    @JsonProperty("name")
    private String name;
    @JsonProperty("animationTime")
    private List<Double> animationTime = null;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("modelHeight")
    private Double modelHeight;
    @JsonProperty("kmBuddyDistance")
    private Integer kmBuddyDistance;
    @JsonProperty("weight")
    private Integer weight;
    @JsonProperty("modelScale")
    private Double modelScale;
    @JsonProperty("maxCP")
    private Integer maxCP;
    @JsonProperty("buddySize")
    private BuddySize buddySize;
    @JsonProperty("cinematicMoves")
    private List<Cinematicmove> cinematicMoves = null;
    @JsonProperty("quickMoves")
    private List<Quickmove> quickMoves = null;
    @JsonProperty("family")
    private Family family;
    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("types")
    private List<Type> types = null;
    @JsonProperty("encounter")
    private Encounter encounter;
    @JsonProperty("camera")
    private Camera camera;
    @JsonProperty("evolution")
    private Evolution evolution;
    @JsonProperty("id")
    private String id;
    @JsonProperty("forms")
    private List<Object> forms = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2110119913653987018L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pokemon() {
    }

    /**
     * 
     * @param modelHeight
     * @param weight
     * @param stats
     * @param camera
     * @param dex
     * @param maxCP
     * @param encounter
     * @param quickMoves
     * @param evolution
     * @param id
     * @param buddySize
     * @param cinematicMoves
     * @param height
     * @param family
     * @param name
     * @param kmBuddyDistance
     * @param animationTime
     * @param types
     * @param forms
     * @param modelScale
     */
    public Pokemon(Integer dex, String name, List<Double> animationTime, Integer height, Double modelHeight, Integer kmBuddyDistance, Integer weight, Double modelScale, Integer maxCP, BuddySize buddySize, List<Cinematicmove> cinematicMoves, List<Quickmove> quickMoves, Family family, Stats stats, List<Type> types, Encounter encounter, Camera camera, Evolution evolution, String id, List<Object> forms) {
        super();
        this.dex = dex;
        this.name = name;
        this.animationTime = animationTime;
        this.height = height;
        this.modelHeight = modelHeight;
        this.kmBuddyDistance = kmBuddyDistance;
        this.weight = weight;
        this.modelScale = modelScale;
        this.maxCP = maxCP;
        this.buddySize = buddySize;
        this.cinematicMoves = cinematicMoves;
        this.quickMoves = quickMoves;
        this.family = family;
        this.stats = stats;
        this.types = types;
        this.encounter = encounter;
        this.camera = camera;
        this.evolution = evolution;
        this.id = id;
        this.forms = forms;
    }

    @JsonProperty("dex")
    public Integer getDex() {
        return dex;
    }

    @JsonProperty("dex")
    public void setDex(Integer dex) {
        this.dex = dex;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("animationTime")
    public List<Double> getAnimationTime() {
        return animationTime;
    }

    @JsonProperty("animationTime")
    public void setAnimationTime(List<Double> animationTime) {
        this.animationTime = animationTime;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("modelHeight")
    public Double getModelHeight() {
        return modelHeight;
    }

    @JsonProperty("modelHeight")
    public void setModelHeight(Double modelHeight) {
        this.modelHeight = modelHeight;
    }

    @JsonProperty("kmBuddyDistance")
    public Integer getKmBuddyDistance() {
        return kmBuddyDistance;
    }

    @JsonProperty("kmBuddyDistance")
    public void setKmBuddyDistance(Integer kmBuddyDistance) {
        this.kmBuddyDistance = kmBuddyDistance;
    }

    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonProperty("modelScale")
    public Double getModelScale() {
        return modelScale;
    }

    @JsonProperty("modelScale")
    public void setModelScale(Double modelScale) {
        this.modelScale = modelScale;
    }

    @JsonProperty("maxCP")
    public Integer getMaxCP() {
        return maxCP;
    }

    @JsonProperty("maxCP")
    public void setMaxCP(Integer maxCP) {
        this.maxCP = maxCP;
    }

    @JsonProperty("buddySize")
    public BuddySize getBuddySize() {
        return buddySize;
    }

    @JsonProperty("buddySize")
    public void setBuddySize(BuddySize buddySize) {
        this.buddySize = buddySize;
    }

    @JsonProperty("cinematicMoves")
    public List<Cinematicmove> getCinematicMoves() {
        return cinematicMoves;
    }

    @JsonProperty("cinematicMoves")
    public void setCinematicMoves(List<Cinematicmove> cinematicMoves) {
        this.cinematicMoves = cinematicMoves;
    }

    @JsonProperty("quickMoves")
    public List<Quickmove> getQuickMoves() {
        return quickMoves;
    }

    @JsonProperty("quickMoves")
    public void setQuickMoves(List<Quickmove> quickMoves) {
        this.quickMoves = quickMoves;
    }

    @JsonProperty("family")
    public Family getFamily() {
        return family;
    }

    @JsonProperty("family")
    public void setFamily(Family family) {
        this.family = family;
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @JsonProperty("types")
    public List<Type> getTypes() {
        return types;
    }

    @JsonProperty("types")
    public void setTypes(List<Type> types) {
        this.types = types;
    }

    @JsonProperty("encounter")
    public Encounter getEncounter() {
        return encounter;
    }

    @JsonProperty("encounter")
    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

    @JsonProperty("camera")
    public Camera getCamera() {
        return camera;
    }

    @JsonProperty("camera")
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    @JsonProperty("evolution")
    public Evolution getEvolution() {
        return evolution;
    }

    @JsonProperty("evolution")
    public void setEvolution(Evolution evolution) {
        this.evolution = evolution;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("forms")
    public List<Object> getForms() {
        return forms;
    }

    @JsonProperty("forms")
    public void setForms(List<Object> forms) {
        this.forms = forms;
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
