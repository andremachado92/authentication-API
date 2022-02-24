package com.andremachado.br.authenticationAPI.domain.repository;

import com.andremachado.br.authenticationAPI.domain.model.ProfilePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilePermissionRepository extends JpaRepository<ProfilePermission,Long> {
}
