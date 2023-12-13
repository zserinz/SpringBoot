package practice.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyAutoConfigImportSelector.class) // 직접 클래스를 하드코딩해서 넣지 않고, 동적으로 String[]에서 관리될 수 있도록 한다.
public @interface EnableMyAutoConfiguration {
}
