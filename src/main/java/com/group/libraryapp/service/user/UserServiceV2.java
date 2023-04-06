package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 생성 기능
     */
    public void saveUser(UserCreateRequest request) {
        User u = userRepository.save(new User(request.getName(), request.getAge()));
    }

    /**
     * 조회 기능
     */
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
                                .map(UserResponse::new)
                                .collect(Collectors.toList());
    }

    /**
     * 업데이트 기능
     */
    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId())
                      .orElseThrow(IllegalArgumentException::new); // user 가 없는 경우 예외가 던져진다.

        user.updateName(request.getName());
        userRepository.save(user);
    }

    /**
     * 삭제 기능
     */
    public void deleteUser(String name) {
        User user = userRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);

        userRepository.delete(user);
    }
}
