package cl.muruna.epv.procesomuruna.service.impl;

import cl.muruna.epv.procesomuruna.dto.UserDTO;
import cl.muruna.epv.procesomuruna.exceptios.UserException;
import cl.muruna.epv.procesomuruna.mappers.PhoneMapper;
import cl.muruna.epv.procesomuruna.mappers.UserMapper;
import cl.muruna.epv.procesomuruna.model.User;
import cl.muruna.epv.procesomuruna.repository.UserRepository;
import cl.muruna.epv.procesomuruna.service.UserService;
import cl.muruna.epv.procesomuruna.util.ConstantsUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> getAllUsers() {
        log.info("getAllUsers");

        return Optional.of(
                        repository.findAll()
                )
                .map(UserMapper.INSTANCE::entityListToDTOList)
                .orElse(new ArrayList<>());
    }

    @Transactional
    @Override
    public UserDTO updateUser(UserDTO user, int userId) {
        User updateUser = repository.findById(userId)
                .orElseThrow(() -> new UserException(ConstantsUtil.ERROR_MESSAGE_NO_DATA_FOUND));

        updateUser.setUserId(userId);
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(passwordEncoder.encode(user.getPassword()));
        updateUser.getPhones().addAll(PhoneMapper.INSTANCE.dtoListToEntityList(user.getPhones()));

        AtomicReference<UserDTO> dto = new AtomicReference<>();
        Optional.of(
                        updateUser
                )
                .ifPresent(etty ->
                        //UserMapper.INSTANCE.entityToDTO(repository.saveAndFlush(new User()))
                        dto.set(UserMapper.INSTANCE.entityToDTO(repository.saveAndFlush(etty)))
                );
        return dto.get();
    }

    @Transactional
    @Override
    public UserDTO newUser(UserDTO user) {
        AtomicReference<UserDTO> dto = new AtomicReference<>();
        Optional.ofNullable(
                        UserMapper.INSTANCE.dtoToEntity(user)
                )
                .ifPresent(etty -> {
                            etty.setPassword(passwordEncoder.encode(user.getPassword()));
                            dto.set(UserMapper.INSTANCE.entityToDTO(repository.saveAndFlush(etty)));
                        }
                );
        return dto.get();
    }

    @Override
    public UserDTO getUser(int userId) {
        return Optional.ofNullable(
                        repository.findById(userId).get()
                )
                .map(UserMapper.INSTANCE::entityToDTO)
                //.orElse(new UserDTO());
                .orElseThrow(() -> new UserException(ConstantsUtil.ERROR_MESSAGE_NO_DATA_FOUND));
    }

    @Override
    public UserDTO getUser(String email) {
        return Optional.of(
                        repository.findByEmail(email).get()
                )
                .map(UserMapper.INSTANCE::entityToDTO)
                //.orElse(new UserDTO());
                .orElseThrow(() -> new UserException(ConstantsUtil.ERROR_MESSAGE_NO_DATA_FOUND));
    }

    @Override
    public Boolean deleteUser(String email) {
        AtomicReference<Boolean> executed = new AtomicReference<>();

        Optional.ofNullable(repository.findByEmail(email)).ifPresent(d ->{
            repository.deleteByEmail(email);
            executed.set(Boolean.TRUE);
        });
        return executed.get();

    }


}
