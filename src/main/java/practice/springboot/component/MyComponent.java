package practice.springboot.component;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface MyComponent {
    // Bean object로 자동으로 등록된다.
    // 전통적인 계층을 구분해서 애노테이션을 통해 지칭해줄 수 있다.
}
