package ru.haulmont.management.practice.listener;

import io.jmix.core.DataManager;
import io.jmix.core.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import ru.haulmont.management.practice.entity.Event;
import io.jmix.core.event.EntityChangedEvent;
import io.jmix.core.event.EntityLoadingEvent;
import io.jmix.core.event.EntitySavingEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.haulmont.management.practice.exception.IncorrectTimeRangeException;

@Component
public class EventEventListener {

    @Autowired
    private DataManager dataManager;
    @Autowired
    private Messages messages;

    @EventListener
    public void onEventChangedBeforeCommit(EntityChangedEvent<Event> event) throws Exception {
        if (event.getType() != EntityChangedEvent.Type.DELETED) {
            Event e = dataManager.load(event.getEntityId()).one();
            if (e.getStartDate().isAfter(e.getEndDate())) {
                throw new IncorrectTimeRangeException(
                        messages.getMessage("ru.haulmont.management.practice/exception.IncorrectTimeRangeException")
                );
            } else
                dataManager.save(e);
        }
    }

}