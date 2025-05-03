package com.introduccion.springnott.web.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(
    "classpath:values2.properties")
 @PropertySource(value="classpath:values.properties",
  encoding = "UTF-8")
public class ValuesConfig {

}
