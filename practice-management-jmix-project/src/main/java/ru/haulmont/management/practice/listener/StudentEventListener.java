package ru.haulmont.management.practice.listener;

import io.jmix.core.DataManager;
import io.jmix.core.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import ru.haulmont.management.practice.entity.Event;
import ru.haulmont.management.practice.entity.Student;
import io.jmix.core.event.EntityChangedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.haulmont.management.practice.exception.IncorrectTimeRangeException;

@Component
public class StudentEventListener {

    @Autowired
    private DataManager dataManager;
    @Autowired
    private Messages messages;

    @EventListener
    public void onStudentChangedBeforeCommit(EntityChangedEvent<Student> event) throws Exception {
        if (event.getType() != EntityChangedEvent.Type.DELETED) {
            Student e = dataManager.load(event.getEntityId()).one();
            if (e.getStartDate().isAfter(e.getEndDate())) {
                throw new IncorrectTimeRangeException(
                        messages.getMessage("ru.haulmont.management.practice/exception.IncorrectTimeRangeException")
                );
            } else
                dataManager.save(e);
        }
    }
}