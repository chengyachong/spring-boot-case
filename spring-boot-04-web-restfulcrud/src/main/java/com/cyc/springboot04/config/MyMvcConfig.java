package com.cyc.springboot04.config;


import com.cyc.springboot04.component.LoginHandlerInterceptor;
import com.cyc.springboot04.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       //浏览器发送cyc请求也跳转success
        registry.addViewController("/cyc").setViewName("success");
    }

   /* //所有的WebMvcConfigurerAdapter组件都会一起起作用
    public WebMvcConfigurer  webMvcConfigurer(){
        WebMvcConfigurer mvcConfigurer = new WebMvcConfigurer() {

        }
    }*/
   //所有的WebMvcConfigurerAdapter组件都会一起起作用
   @Bean //将组件注册在容器
   public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
       WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
           @Override
           public void addViewControllers(ViewControllerRegistry registry) {
               registry.addViewController("/").setViewName("login");
               registry.addViewController("/index.html").setViewName("login");
               registry.addViewController("/main.html").setViewName("dashboard");
           }

           //注册拦截器
           @Override
           public void addInterceptors(InterceptorRegistry registry) {
               //super.addInterceptors(registry);
               //静态资源；  *.css , *.js
               //SpringBoot已经做好了静态资源映射

             /* registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login");*/
           }
       };
       return adapter;
   }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
