package cl.muruna.epv.procesomuruna.model;

import cl.muruna.epv.procesomuruna.enums.TokenTypeEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TOKEN")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Token {
    @Id
    @GeneratedValue
    @Column(name = "TOKEN_ID")
    private Integer tokenId;

    @Column(name = "TOKEN", unique = true)
    private String token;

    @Column(name = "TOKEN_TYPE")
    @Enumerated(EnumType.STRING)
    private TokenTypeEnum tokenType = TokenTypeEnum.BEARER;

    @Column(name = "REVOKED")
    private boolean revoked;

    @Column(name = "EXPIRED")
    private boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
}
