package springbootdatajdbc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//scanBasePackage：扫描基础包或者@ComponentScan注解包扫描

@SpringBootApplication(scanBasePackages = "springbootdatajdbc")
public class DemoApplication {

    public static void main(String[] args) {
         //返回ioc容器
        ConfigurableApplicationContext bean =  SpringApplication.run(DemoApplication.class, args);
        String[] beans = bean.getBeanDefinitionNames();
        for (String name:beans
             ) {
            System.out.println("333");
            System.out.println(name+"00000000");
        }
    }

}
