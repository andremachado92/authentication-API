package com.andremachado.br.authenticationAPI.domain.repository;

import com.andremachado.br.authenticationAPI.domain.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
