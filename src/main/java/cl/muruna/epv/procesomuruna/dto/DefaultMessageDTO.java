package cl.muruna.epv.procesomuruna.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefaultMessageDTO implements Serializable {
    private String mensaje;
}
