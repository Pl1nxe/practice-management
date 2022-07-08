package ru.haulmont.management.practice.screen.event;

import io.jmix.ui.screen.*;
import ru.haulmont.management.practice.entity.Event;

@UiController("Event.edit")
@UiDescriptor("event-edit.xml")
@EditedEntityContainer("eventDc")
public class EventEdit extends StandardEditor<Event> {
}