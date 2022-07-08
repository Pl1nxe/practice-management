package ru.haulmont.management.practice.screen.student;

import io.jmix.ui.screen.*;
import ru.haulmont.management.practice.entity.Student;

@UiController("Student.edit")
@UiDescriptor("student-edit.xml")
@EditedEntityContainer("studentDc")
public class StudentEdit extends StandardEditor<Student> {
}