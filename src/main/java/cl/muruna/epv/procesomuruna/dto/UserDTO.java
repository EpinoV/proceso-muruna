package cl.muruna.epv.procesomuruna.dto;

import cl.muruna.epv.procesomuruna.enums.RoleEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private int userId;
    @NotBlank(message = "Debe ingresar nombre")
    private String name;
    @NotBlank(message = "Debe ingresar email")
    private String email;
    @NotBlank(message = "Debe ingresar contraseña")
    private String password;
    private List<PhoneDTO> phones;
    @Enumerated(EnumType.STRING)
    private RoleEnum role = RoleEnum.USER;
}
