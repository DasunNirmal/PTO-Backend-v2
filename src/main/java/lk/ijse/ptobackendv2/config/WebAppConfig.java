package lk.ijse.ptobackendv2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.ptobackendv2")
@EnableWebMvc
public class WebAppConfig {
}
