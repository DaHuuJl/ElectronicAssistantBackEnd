package ru.cchgeu.electronicassistantbackend.services.reference;

import ru.cchgeu.electronicassistantbackend.model.dto.ReferenceRequestDTO;

public interface ReferenceService {
    void createReference(ReferenceRequestDTO referenceRequestDTO);
/*    void createReference();
    void verifivationReference();*/
}
