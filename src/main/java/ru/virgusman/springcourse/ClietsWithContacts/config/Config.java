package ru.virgusman.springcourse.ClietsWithContacts.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Учёт клиентов с контактами")
                                .version("1.0.0")
                );
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
