package com.andremachado.br.authenticationAPI.utils;

import com.andremachado.br.authenticationAPI.domain.model.Permission;
import com.andremachado.br.authenticationAPI.domain.model.Profile;
import com.andremachado.br.authenticationAPI.domain.model.ProfilePermission;
import com.andremachado.br.authenticationAPI.domain.model.User;
import com.andremachado.br.authenticationAPI.domain.repository.PermissionRepository;
import com.andremachado.br.authenticationAPI.domain.repository.ProfilePermissionRepository;
import com.andremachado.br.authenticationAPI.domain.repository.ProfileRepository;
import com.andremachado.br.authenticationAPI.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Utils {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private ProfilePermissionRepository profilePermissionRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void insertUserAndPermissionsDefault() {
        var profile = saveAProfile();

        var permission = saveAPermission();

        saveAProfilePermission(profile, permission);

        saveAUser(profile);

    }

    private void saveAUser(Profile profile) {
        userRepository.save(
                User.builder().
                        profile(profile).
                        login("usuario@email.com").
                        password(passEncoder("admin123")).
                        build()
        );
    }

    private void saveAProfilePermission(Profile profile, Permission permission) {
        profilePermissionRepository.save(
                ProfilePermission.builder().
                        profile(profile).
                        permission(permission).
                        build()
        );
    }

    private Permission saveAPermission() {
        return permissionRepository.save(
                Permission.
                        builder().
                        description("ROLE_LOGIN").
                        build()
        );
    }

    private Profile saveAProfile() {
        return profileRepository.save(
                Profile.builder().
                        description("Administrador").
                        build()
        );
    }

    public String passEncoder(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

}
