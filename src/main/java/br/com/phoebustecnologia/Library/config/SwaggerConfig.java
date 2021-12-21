package br.com.phoebustecnologia.Library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.phoebustecnologia.Library"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }
    public ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "LibraryAPI",
                "API book sales.",
                "API Version 1.0",
                "Terms of services",
                new Contact("Hugo Silva Martins",
                            "API URL",
                            "hugo.silva@gmail.com"),
                            "API Licence",
                            "API Licence URL",
                             new ArrayList<VendorExtension>());

        return apiInfo;
    }

}
