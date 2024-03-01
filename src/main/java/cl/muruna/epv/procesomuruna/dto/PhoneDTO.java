package cl.muruna.epv.procesomuruna.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO implements Serializable {
    private String phoneNumber;
    private String cityCode;
    private String countryCode;
}
