package ru.haulmont.management.practice.screen.event;

import io.jmix.core.Messages;
import io.jmix.ui.Notifications;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.haulmont.management.practice.entity.Event;

@UiController("Event.edit")
@UiDescriptor("event-edit.xml")
@EditedEntityContainer("eventDc")
public class EventEdit extends StandardEditor<Event> {

    @Autowired
    protected Notifications notifications;

    @Autowired
    private Messages messages;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        if (getEditedEntity().getStartDate().isAfter(getEditedEntity().getEndDate())) {
            notifications.create()
                    .withCaption(messages.getMessage("ru.haulmont.management.practice/exception.IncorrectTimeRangeExceptionHeader"))
                    .withDescription(messages.getMessage("ru.haulmont.management.practice/exception.IncorrectTimeRangeException"))
                    .withType(Notifications.NotificationType.WARNING)
                    .show();
            event.preventCommit();
        }
    }
}