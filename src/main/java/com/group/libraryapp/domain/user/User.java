package com.group.libraryapp.domain.user;

public class User {

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        if(name == null || name.isBlank()) { // 만약 이름이 null 이거나 이름이 공백 문자가 들어오면 메세지를 남김
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다."));
        }
        this.name = name;
        this.age = age;
    }

}
