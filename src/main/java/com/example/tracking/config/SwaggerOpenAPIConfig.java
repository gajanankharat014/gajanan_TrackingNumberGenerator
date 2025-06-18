package com.example.tracking.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Scalable Tracking Number Generator API",
                description = " API endpoint accessible via GET /next-tracking-number",
                version = "1.0"
        )
)
public class SwaggerOpenAPIConfig {

        @Value("${swagger.server-url}")
        private String serverUrl;

        @Value("${spring.profiles.active:default}")
        private String activeProfile;

        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                        .addServersItem(new io.swagger.v3.oas.models.servers.Server()
                                .url(serverUrl)
                                                .description("API server for the " + activeProfile + " environment")
                        );
        }
}
