package service.yourbookspring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import service.yourbookspring.dto.UserDTO;
import service.yourbookspring.entity.User;
import service.yourbookspring.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(UserDTO userDTO) {
        User user = User.builder()
                .name(userDTO.getName())
                .surname(userDTO.getSurname())
                .phoneNumber(userDTO.getPhoneNumber())
                .password(userDTO.getPassword())
                .build();
        return userRepository.save(user);
    }
}
