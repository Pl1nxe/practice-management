package ru.haulmont.management.practice.screen.student;

import io.jmix.core.Messages;
import io.jmix.ui.Notifications;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.haulmont.management.practice.entity.Student;

@UiController("Student.edit")
@UiDescriptor("student-edit.xml")
@EditedEntityContainer("studentDc")
public class StudentEdit extends StandardEditor<Student> {

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