package ru.haulmont.management.practice.dto;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.JmixProperty;

import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@JmixEntity
public class EventsOfStudent {
    @JmixGeneratedValue
    @JmixId
    private UUID id;

    @InstanceName
    @JmixProperty(mandatory = true)
    @NotNull
    private String category;

    @OrderBy("index")
    @JmixProperty(mandatory = true)
    @Composition
    @NotNull
    private List<Segment> segments;

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}