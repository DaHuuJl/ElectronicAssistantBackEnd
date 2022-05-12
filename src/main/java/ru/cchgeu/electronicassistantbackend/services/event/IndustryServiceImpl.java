package ru.cchgeu.electronicassistantbackend.services.event;

import org.springframework.stereotype.Service;
import ru.cchgeu.electronicassistantbackend.repositories.event.IndustryRepository;

@Service
public class IndustryServiceImpl implements IndustryService {

    private final IndustryRepository industryRepository;

    public IndustryServiceImpl(IndustryRepository industryRepository) {
        this.industryRepository = industryRepository;
    }
}
