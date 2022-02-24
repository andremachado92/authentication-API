package com.andremachado.br.authenticationAPI.domain.model;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "User")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "USER_LOGIN")
    private String login;

    @Column(name = "USER_PASSWORD")
    private String password;

    @ManyToOne
    @JoinColumn(name = "USER_PROFILE", referencedColumnName = "PROF_ID")
    private Profile profile;

    @OneToMany(mappedBy = "profile")
    private List<ProfilePermission> profilePermission;
}
