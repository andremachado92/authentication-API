package com.andremachado.br.authenticationAPI.domain.repository;
import com.andremachado.br.authenticationAPI.domain.model.Profile;
import com.andremachado.br.authenticationAPI.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {
}
