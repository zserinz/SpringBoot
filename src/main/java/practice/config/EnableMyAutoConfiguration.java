package practice.config;

import org.springframework.context.annotation.Import;
import practice.config.autoconfig.DispatcherServletConfig;
import practice.config.autoconfig.TomcatWebServerConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({DispatcherServletConfig.class, TomcatWebServerConfig.class}) // Config 설정 파일을 주입시키기 위해 작성 (1개 이상의 configure를 관리할 때에도 사용)
public @interface EnableMyAutoConfiguration {
}
