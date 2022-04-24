package ru.cchgeu.electronicassistantbackend.model.entity.user;

public enum TypeTraining {
    BUDGET ("бюджетной"), COMMERCE ("контррактной"), TARGET ("целевое");

    private String type;

    TypeTraining(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
