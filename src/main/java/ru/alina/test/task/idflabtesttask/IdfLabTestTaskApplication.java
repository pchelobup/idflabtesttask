package ru.alina.test.task.idflabtesttask;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class IdfLabTestTaskApplication {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer addCustomBigDecimalDeserialization() {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8090");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Alina");
        myContact.setEmail("alinadavydova0710@gmail.com");

        Info information = new Info()
                .title("Тестовое задание IDF LAB")
                .version("1.0")
                .description("API для прототипа микросервиса, без разграничений доступа к API, который будет интегрирован в существующую банковскую систему")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }

    public static void main(String[] args) {
        SpringApplication.run(IdfLabTestTaskApplication.class, args);
    }

}
