package com.introduccion.springnott.web.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({
    "classpath:values.properties",
    "classpath:values2.properties",
})
public class ValuesConfig {

}
