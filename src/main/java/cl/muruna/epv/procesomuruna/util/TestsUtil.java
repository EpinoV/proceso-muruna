package cl.muruna.epv.procesomuruna.util;

import cl.muruna.epv.procesomuruna.dto.UserDTO;
import cl.muruna.epv.procesomuruna.model.User;

public class TestsUtil {
    public static UserDTO getUserDTO() {
        return UserDTO.builder().userId(1).name("Nombre Test").email("user@user.cl").build();
    }
    public static User getUserModel() {
        return User.builder().userId(1).name("Nombre Test").email("user@user.cl").build();
    }
}
