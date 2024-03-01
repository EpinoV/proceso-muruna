package cl.muruna.epv.procesomuruna.service;

import cl.muruna.epv.procesomuruna.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO user, int userId);

    UserDTO newUser(UserDTO user);

    UserDTO getUser(int userId);

    UserDTO getUser(String email);

    Boolean deleteUser(String email);
}
