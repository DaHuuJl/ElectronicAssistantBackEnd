package ru.cchgeu.electronicassistantbackend.model.entity.user;

public class TUser {
    private final int id;
    private final String name;

    public TUser(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
