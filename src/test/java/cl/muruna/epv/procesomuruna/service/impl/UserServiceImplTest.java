package cl.muruna.epv.procesomuruna.service.impl;

import cl.muruna.epv.procesomuruna.dto.UserDTO;
import cl.muruna.epv.procesomuruna.model.User;
import cl.muruna.epv.procesomuruna.repository.UserRepository;
import cl.muruna.epv.procesomuruna.service.UserService;
import cl.muruna.epv.procesomuruna.util.TestsUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private UserService service;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        service = new UserServiceImpl(userRepository, passwordEncoder);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllUsers_empty() {
        Mockito.when(userRepository.findAll()).thenReturn(new ArrayList<>(Collections.emptyList()));

        List<UserDTO> list = service.getAllUsers();

        Assertions.assertThat(list).isEmpty();

    }

    @Test
    void updateUser() {
    }

    //@Test
    void newUser() {
        User user = TestsUtil.getUserModel();
        UserDTO dto = TestsUtil.getUserDTO();

        Mockito.when(userRepository.saveAndFlush(user)).thenReturn(user);
        //Mockito.when(service.newUser(dto)).thenReturn(dto);

        UserDTO dtoService = service.newUser(dto);

        Assertions.assertThat(dtoService).isNotNull();

    }

    @Test
    void getUser() {
    }

    @Test
    void testGetUser() {
    }

    @Test
    void deleteUser() {
    }
}