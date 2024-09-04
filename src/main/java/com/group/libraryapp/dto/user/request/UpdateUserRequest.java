package com.group.libraryapp.dto.user.request;

public class UpdateUserRequest {

    private long id;
    private String name;

    public UpdateUserRequest(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
