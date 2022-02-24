package com.andremachado.br.authenticationAPI.config.oauth;
import com.andremachado.br.authenticationAPI.config.token.UserSystem;
import com.andremachado.br.authenticationAPI.domain.model.User;
import com.andremachado.br.authenticationAPI.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email)  {

        //Front/Swagger
        if (Boolean.TRUE) {
            var user = userRepository.findByLogin(email).orElseThrow(
                    () -> new UsernameNotFoundException("Incorrect username or password"));


            return new UserSystem(user, getPermission(user));
        }else {
            throw new UnauthorizedClientException("Error when logging, contact your administrator");
        }
    }

    private Collection<? extends GrantedAuthority> getPermission(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getProfile().getPermissions().forEach(p -> authorities.add(
                new SimpleGrantedAuthority(p.getPermission().getDescription().toUpperCase())));
        return authorities;
    }

}
