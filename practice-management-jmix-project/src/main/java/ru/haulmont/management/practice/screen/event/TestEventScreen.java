package ru.haulmont.management.practice.screen.event;

import io.jmix.ui.screen.*;
import ru.haulmont.management.practice.entity.Event;

@UiController("Test.event")
@UiDescriptor("test-event-screen.xml")
@LookupComponent("table")
public class TestEventScreen extends MasterDetailScreen<Event> {
}