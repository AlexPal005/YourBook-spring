package service.yourbookspring.controller;

import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.yourbookspring.dto.UserDTO;
import service.yourbookspring.entity.User;
import service.yourbookspring.repository.UserRepository;
import service.yourbookspring.service.UserService;
import service.yourbookspring.utilities.JWT;
import service.yourbookspring.utilities.JWTContent;

import java.util.Optional;


@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository repository;
    private final JWT jwt;

    @PostMapping(value = "/register")
    public ResponseEntity<User> create(@RequestBody UserDTO userDTO) throws Exception {
        return new ResponseEntity<>(userService.create(userDTO), HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO) {
        User storedUser = repository.findByEmail(userDTO.getEmail());

        if (storedUser == null || !BCrypt.checkpw(userDTO.getPassword(), storedUser.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неправильний пароль або логін!");
        }

        Long userId = storedUser.getId();
        JWTContent content = new JWTContent(userId);
        String token = jwt.encode(content);
        return ResponseEntity.ok(token);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Optional<User> user = repository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping(value = "/user/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User user = repository.findById(id).orElseThrow();
        user.setAddress(userDTO.getAddress());
        User saved = repository.save(user);
        return ResponseEntity.ok(saved);
    }
}
