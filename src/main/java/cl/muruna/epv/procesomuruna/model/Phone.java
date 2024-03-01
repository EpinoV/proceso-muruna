package cl.muruna.epv.procesomuruna.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "PHONES")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PHONE_ID")
    private Integer phoneId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "CITY_CODE")
    private String cityCode;

    @Column(name = "COUNTRY_CODE")
    private String countryCode;
}
