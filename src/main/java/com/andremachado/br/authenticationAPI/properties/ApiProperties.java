package com.andremachado.br.authenticationAPI.properties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties("api")
public class ApiProperties {
    private String clientId;
    private String clientSecret;
    private String scopeRead;
    private String scopeTrust;
    private String scopeWrite;
    private String grantTypePassword;
    private String grantTypeRefreshToken;
    private Integer tokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;
    private String signingKey;
    private String swaggerSecret;
    private String authServer;
}
