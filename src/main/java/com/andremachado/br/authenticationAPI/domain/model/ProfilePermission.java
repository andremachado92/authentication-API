package com.andremachado.br.authenticationAPI.domain.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "ProfilePermission")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfilePermission {


    @Id
    @Column(name = "PROF_PERM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROF_PERM_PROFILE", referencedColumnName = "PROF_ID")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "PROF_PERM_PERMISSION", referencedColumnName = "PERM_ID")
    private Permission permission;

}
