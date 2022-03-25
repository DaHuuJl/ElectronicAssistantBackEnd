package ru.cchgeu.electronicassistantbackend.utils.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class LoadScheduler {

    @Scheduled(cron = "${test.scheduler.first}")
    public void loadFaculty() {

    }

    @Scheduled(cron = "${test.scheduler.first}")
    public void loadDepartment() {

    }

    @Scheduled(cron = "${test.scheduler.first}")
    public void loadGroups() {

    }

    @Scheduled(cron = "${test.scheduler.first}")
    public void loadGradBookInformation() {

    }


}
