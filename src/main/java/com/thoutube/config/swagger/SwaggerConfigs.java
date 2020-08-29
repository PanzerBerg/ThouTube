package com.thoutube.config.swagger;

import java.util.Arrays;

import com.amazonaws.services.appstream.model.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigs {
    
    @Bean
    public Docket thoutubeApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                        .select()
                        .apis(RequestHandlerSelectors.basePackage("com.thoutube"))
                        .paths(PathSelectors.ant("/**"))
                        .build()
                        .ignoredParameterTypes(User.class)
                        .globalOperationParameters(Arrays.asList(
                            new ParameterBuilder()
                            .name("Authorization")
                            .description("JWT authorization header")
                            .modelRef(new ModelRef("string"))
                            .parameterType("header")
                            .required(false)
                            .build()
                        ));
    }
}