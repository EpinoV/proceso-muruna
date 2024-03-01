package cl.muruna.epv.procesomuruna.controller;

import cl.muruna.epv.procesomuruna.dto.UserDTO;
import cl.muruna.epv.procesomuruna.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proceso-muruna/api/v1/private")
@Slf4j
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/allUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> allUsers(){
        log.info("Todos los usuarios");

        List<UserDTO> result = service.getAllUsers();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/userByEmail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> userByEmail(
            @RequestParam(value = "email") String email
    ){
        log.info("Todos los usuarios");

        UserDTO result = service.getUser(email);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/newUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> newUser(
            @Valid @RequestBody UserDTO user
    ){
        log.info("nuevo usuario");

        UserDTO result = service.newUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PutMapping(value = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUser(
            @Valid @RequestBody UserDTO user
    ){
        log.info("actualiza usuario");

        UserDTO result = service.updateUser(user, user.getUserId());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> deleteUser(
            @RequestParam(value = "email") String email
    ){
        log.info("Todos los usuarios");

        UserDTO result = service.getUser(email);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
