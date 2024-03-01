package cl.muruna.epv.procesomuruna.service;

import cl.muruna.epv.procesomuruna.dto.AuthenticationRequestDTO;
import cl.muruna.epv.procesomuruna.dto.AuthenticationResponseDTO;
import cl.muruna.epv.procesomuruna.dto.RegisterRequestDTO;

public interface AuthenticationService {
    AuthenticationResponseDTO register(RegisterRequestDTO request);

    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request);

}
