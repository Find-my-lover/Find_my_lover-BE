package com.gamjaring.web.springboot.config;

import com.gamjaring.web.springboot.config.auth.WebSecurityConfig;
import com.gamjaring.web.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//api취급 판별기 class
@Configuration
@EnableSwagger2
public class Swagger2Config{
    //WebSecurityConfig extend없앤 상태

    @Autowired
    UserService userService;


    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                //.apis(RequestHandlerSelectors.basePackage(""))
                //문제시 패키지 명 지정해주기
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("RingMyBell project")
                .description("당신이 좋아할만한 애인상을 찾아주는 서비스입니다.")
                .version("0.8.0")
                .termsOfServiceUrl("https://rough-activity-cea.notion.site/9b7590273c084988b4bce1b51c8be066")
                //설명서
                .license("LICENSE")
                .licenseUrl("")
                .build();
    }
}



/*package com.gamjaring.web.springboot.config.swagger;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger2Config {

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("ringmybell")
                .pathsToMatch("/api(/**")
                //https://localhost:8080/api/~를 기본경로로 매핑하겠습니다
                .build();
    }


    @Bean
    public OpenAPI springShopOpenAPI(){
        return new OpenAPI()
                .info(new Info().title("RingMyBell API")
                        .description("RingMyBEll API 명세서")
                        .version("v0.0.1"));
    }
}
*/