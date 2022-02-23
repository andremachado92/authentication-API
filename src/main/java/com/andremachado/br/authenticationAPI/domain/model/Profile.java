package com.andremachado.br.authenticationAPI.domain.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Profile")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {


    @Id
    @Column(name = "PROF_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "PROF_DESCRIPTION")
    private String description;


}
