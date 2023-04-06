package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {

    private final UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    /**
     * 생성
     */
    public void saveUser(UserCreateRequest request) { // 생성
        userJdbcRepository.saveUser(request.getName(), request.getAge());
    }

    /**
     * 조회
     */
    public List<UserResponse> getUsers() { // 조회
        return userJdbcRepository.getUsers();
    }

    /**
     * 업데이트
     */
    public void updateUser(UserUpdateRequest request) {
        String readSql = "SELECT * FROM user WHERE id = ?";
        if (userJdbcRepository.isUserNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }

        userJdbcRepository.updateUserName(request.getName(), request.getId());
    }

    /**
     * 삭제
     **/
    public void deleteUser(String name) {
        if (userJdbcRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }

        userJdbcRepository.deleteUser(name);
    }

}
