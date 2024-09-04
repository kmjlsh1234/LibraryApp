package com.group.libraryapp.dto.user.request;

public class GetUserRequest {
    private String name;
    private int age;
    public GetUserRequest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
