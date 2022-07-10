package ru.haulmont.management.practice.screen.event;

import io.jmix.ui.screen.*;
import ru.haulmont.management.practice.entity.Event;

@UiController("Event.browse")
@UiDescriptor("event-browse.xml")
@LookupComponent("eventsTable")
public class EventBrowse extends StandardLookup<Event> {

}