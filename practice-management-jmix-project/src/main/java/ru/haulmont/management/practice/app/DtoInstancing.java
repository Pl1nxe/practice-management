package ru.haulmont.management.practice.app;

import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.haulmont.management.practice.dto.EventsOfStudent;
import ru.haulmont.management.practice.dto.Segment;
import ru.haulmont.management.practice.entity.Event;
import ru.haulmont.management.practice.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DtoInstancing {

    @Autowired
    private DataManager dataManager;

    public List<EventsOfStudent> getEventsOfStudentList(List<UUID> students) {
        if (students == null)
            students = new ArrayList<>();
        if (students.size() == 0) {
            List<UUID> finalStudents = students;
            dataManager.load(Student.class).all().list().forEach(e -> finalStudents.add(e.getId()));
        }
        List<Event> events;
        List<EventsOfStudent> eventsOfStudents = new ArrayList<>();
        for (UUID sId : students) {
            events = dataManager.loadValues(String.format("select e from EVENT e where e.ID in " +
                            "(select es.EVENT_ID from EVENT_STUDENT_LINK es where es.STUDENT_ID = '%s') " +
                            "order by e.START_DATE", sId.toString()))
                    .properties("event")
                    .list()
                    .stream()
                    .map(e -> e.<Event>getValue("event"))
                    .toList();
            EventsOfStudent eos = dataManager.create(EventsOfStudent.class);
            Student student = dataManager.load(Student.class).id(sId).one();
            eos.setCategory(student.getFullName());
            eos.setSegments(new ArrayList<>());
            Segment segment;
            for (int i = 0; i < events.size(); i++) {
                segment = dataManager.create(Segment.class);

                //TODO - Добавить start, duration, color, когда будет понятно, что они значат.
                segment.setEventOfStudent(eos);
                segment.setIndex(i + 1);
                segment.setTask(events.get(i).getDescription());

                eos.getSegments().add(segment);
            }
            eventsOfStudents.add(eos);
        }
        return eventsOfStudents;
    }
}