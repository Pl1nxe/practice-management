package ru.haulmont.management.practice.screen.event;

import io.jmix.core.DataManager;
import io.jmix.core.Id;
import io.jmix.core.LoadContext;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.DataComponents;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.haulmont.management.practice.app.DtoInstancing;
import ru.haulmont.management.practice.dto.EventsOfStudent;
import ru.haulmont.management.practice.dto.Segment;
import ru.haulmont.management.practice.entity.Event;
import ru.haulmont.management.practice.entity.Student;
import ru.haulmont.management.practice.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@UiController("EventChart")
@UiDescriptor("event-chart.xml")
public class EventChart extends StandardLookup<EventsOfStudent> {

    @Autowired
    private DataComponents dataComponents;
    @Autowired
    private DataManager dataManager;
    @Autowired
    private DtoInstancing dtoInstancing;

//    private CollectionLoader<EventsOfStudent> eventsOfStudentsDl;

    @Install(to = "eventsOfStudentsDl", target = Target.DATA_LOADER)
    protected List<EventsOfStudent> customersDlLoadDelegate(LoadContext<EventsOfStudent> loadContext) {
        LoadContext.Query query = loadContext.getQuery();

        // TODO - Добавить получение списка выбранных студентов.
        return dtoInstancing.getEventsOfStudentList(null);
    }

//    private void createCustomerLoader(CollectionContainer<EventsOfStudent> container) {
//        eventsOfStudentsDl = dataComponents.createCollectionLoader();
////        eventsOfStudentsDl.setQuery("select e from uiex1_Customer e");
//        eventsOfStudentsDl.setContainer(container);
//        eventsOfStudentsDl.setDataContext(getScreenData().getDataContext());
//    }
}