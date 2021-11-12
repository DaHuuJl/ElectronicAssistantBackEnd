package ru.cchgeu.electronicassistantbackend.model.entity.user;

public enum Type_training {
    BUDGET ("бюджетной"), COMMERCE ("контррактной"), TARGET ("целевое");

    private String type;

    Type_training(String type) {
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
