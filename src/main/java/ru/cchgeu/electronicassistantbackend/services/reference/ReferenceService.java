package ru.cchgeu.electronicassistantbackend.services.reference;

import ru.cchgeu.electronicassistantbackend.model.dto.ReferenceRequestInput;

public interface ReferenceService {
    void createReferenceForInput(ReferenceRequestInput referenceRequestInput);
    void createPaperReference(ReferenceRequestInput referenceRequestInput);
    void createElectronicReference(ReferenceRequestInput referenceRequestInput);
/*    void createReference();
    void verifivationReference();*/
}
