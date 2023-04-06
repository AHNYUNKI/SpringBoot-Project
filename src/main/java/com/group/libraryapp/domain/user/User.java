package com.group.libraryapp.domain.user;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 20, name = "name") // name 부분은 생략 가능.
    private String name;

    private Integer age;
    protected User() {}

    public User(String name, Integer age) {
        if(name == null || name.isBlank()) { // 만약 이름이 null 이거나 이름이 공백 문자가 들어오면 메세지를 남김
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다."));
        }
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void updateName(String name) {
        this.name = name;

    }
}
