package Lesson11;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("Lesson11")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

}
