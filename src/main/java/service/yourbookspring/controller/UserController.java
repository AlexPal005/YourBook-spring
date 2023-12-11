package service.yourbookspring.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.yourbookspring.dto.UserDTO;
import service.yourbookspring.entity.User;
import service.yourbookspring.service.UserService;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    @CrossOrigin

    @PostMapping(value = "/user")
    public ResponseEntity<User> create(@RequestBody UserDTO userDTO) throws Exception {
        System.out.println(userDTO);
        return new ResponseEntity<>(userService.create(userDTO), HttpStatus.OK);
    }

}
