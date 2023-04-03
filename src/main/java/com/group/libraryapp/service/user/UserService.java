package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(JdbcTemplate jdbcTemplate) {
        userRepository = new UserRepository(jdbcTemplate);
    }

    /**
     * 생성
     */
    public void saveUser(UserCreateRequest request) { // 생성
        userRepository.saveUser(request.getName(), request.getAge());
    }

    /**
     * 조회
     */
    public List<UserResponse> getUsers() { // 조회
        return userRepository.getUsers();
    }

    /**
     * 업데이트
     */
    public void updateUser(UserUpdateRequest request) {
        String readSql = "SELECT * FROM user WHERE id = ?";
        if (userRepository.isUserNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }

        userRepository.updateUserName(request.getName(), request.getId());
    }

    /**
     * 삭제
     **/
    public void deleteUser(String name) {
        if (userRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }

        userRepository.deleteUser(name);
    }

}
