package top.smalldai.opensource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class OpenSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenSourceApplication.class, args);
    }

}
