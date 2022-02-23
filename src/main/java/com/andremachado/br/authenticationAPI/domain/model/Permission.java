package com.andremachado.br.authenticationAPI.domain.model;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Permission")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permission {


    @Id
    @Column(name = "PERM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "PERM_Description")
    private String description;
}
