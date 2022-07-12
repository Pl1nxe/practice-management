package ru.haulmont.management.practice.dto;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.JmixProperty;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
public class Segment {
    @JmixGeneratedValue
    @JmixId
    private UUID id;

    @JmixProperty(mandatory = true)
    @Composition
    @NotNull
    private EventsOfStudent eventOfStudent;

    @JmixProperty(mandatory = true)
    @NotNull
    private Integer start;

    @JmixProperty(mandatory = true)
    @NotNull
    private Integer duration;

    @JmixProperty(mandatory = true)
    @NotNull
    private String color;

    @InstanceName
    @JmixProperty(mandatory = true)
    @NotNull
    private String task;

    @JmixProperty(mandatory = true)
    @NotNull
    private Integer index;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public EventsOfStudent getEventOfStudent() {
        return eventOfStudent;
    }

    public void setEventOfStudent(EventsOfStudent eventOfStudent) {
        this.eventOfStudent = eventOfStudent;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}