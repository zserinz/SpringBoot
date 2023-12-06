package practice.springboot;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;

public class PracticeSpringBootApplication {

    public static void main(String[] args) {
        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
        applicationContext.registerBean(SimpleHelloService.class); // bean 등록 완료
        applicationContext.registerBean(HelloController.class);
        applicationContext.refresh(); // bean object 로서 초기화

        // 내장형 톰캣의 초기화 작업과 간편한 설정을 지원하도록 스프링 부트가 제공하는 라이브러리가 존재한다.
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        // 서블릿 컨테이너 생성
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("dispatcherServlet",
                    new DispatcherServlet(applicationContext)
            ).addMapping("/*");
        });
        webServer.start();
    }
}
