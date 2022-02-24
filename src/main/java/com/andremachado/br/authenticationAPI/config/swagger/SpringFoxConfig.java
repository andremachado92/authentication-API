package com.andremachado.br.authenticationAPI.config.swagger;

import com.andremachado.br.authenticationAPI.properties.ApiProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Configuration
@EnableSwagger2
public class SpringFoxConfig implements WebMvcConfigurer {

    @Autowired
    private ApiProperties properties;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.andremachado.br.authenticationAPI"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Collections.singletonList(securityScheme()))
                .securityContexts(Collections.singletonList(securityContext()))
                .apiInfo(apiInfo());
    }

    @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
                .clientId(properties.getClientId())
                .clientSecret(properties.getSwaggerSecret())
                .scopeSeparator(" ")
                .useBasicAuthenticationWithAccessCodeGrant(true)
                .build();
    }

    private OAuth securityScheme() {

        List<AuthorizationScope> authorizationScopeList = new ArrayList<>();
        authorizationScopeList.add(new AuthorizationScope(properties.getScopeRead(), "read all"));
        authorizationScopeList.add(new AuthorizationScope(properties.getScopeTrust(), "trust all"));
        authorizationScopeList.add(new AuthorizationScope(properties.getScopeWrite(), "access all"));

        List<GrantType> grantTypes = new ArrayList<>();

        grantTypes.add(new ResourceOwnerPasswordCredentialsGrant(properties.getAuthServer() + "/oauth/token"));

        return new OAuth("oauth2schema", authorizationScopeList, grantTypes);

    }

    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[]{
                new AuthorizationScope(properties.getScopeRead(), "for read operations"),
                new AuthorizationScope(properties.getScopeWrite(), "for write operations"),
                new AuthorizationScope(properties.getScopeTrust(), "trust all")};
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(
                        Collections.singletonList(new SecurityReference("oauth2schema", scopes())))
                .forPaths(PathSelectors.any())
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Auth")
                .description("API estudos de autenticação")
                .version("2.0")
                .contact(new Contact("André Machado ", "http://www.github.com/andremachado92", "naoresponda@itbam.org.br")).build();
    }



}