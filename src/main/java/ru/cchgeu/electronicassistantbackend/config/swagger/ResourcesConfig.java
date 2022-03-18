package ru.cchgeu.electronicassistantbackend.config.swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource(value = "classpath:cron.properties"),

})
public class ResourcesConfig {

}