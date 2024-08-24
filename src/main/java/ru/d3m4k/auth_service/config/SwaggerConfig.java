package ru.d3m4k.auth_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

//    @Bean
//    public OpenAPI api() {
//        return new OpenAPI()
//                .servers(
//                        List.of(
//                                new Server().url("http://localhost:8080")
//                        )
//                );
//    }

    @Bean
    public OpenAPI api() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Тестовое описание");

        Info info = new Info();
        info.title("Тестовый заголовок");
        info.version("1.0");

        return new OpenAPI().info(info).servers(List.of(server));
    }
}
