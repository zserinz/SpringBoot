package practice.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {
    @Test
    void configuration() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh();

        Bean1 bean1 = ac.getBean(Bean1.class);
        Bean2 bean2 = ac.getBean(Bean2.class);

        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    @Test
    void proxyCommonMethod() {
        MyConfigProxy myConfigProxy = new MyConfigProxy(); // 확장해서 대체하는 방식으로 동작한다.

        Bean1 bean1 = myConfigProxy.bean1();
        Bean2 bean2 = myConfigProxy.bean2();

        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    // 아래 형태를 가정하자.
    // Bean1 <-의존- Common
    // Bean2 <-의존- Common

    // 스프링 버전(5.2)에서는 프록시 동작 방식을 끌 수 있도록 업데이트 되었다. -> 해당 부분 확인!
    static class MyConfigProxy extends MyConfig {
        private Common common;
        @Override
        Common common() {
            // 접근 방식을 제어하는 프록시를 생성
            if (this.common == null) this.common = super.common();

            return common;
        }
    }

    @Configuration
    static class MyConfig {
        @Bean
        Common common() {
            return new Common();
        }

        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }

        @Bean
        Bean2 bean2() {
            return new Bean2(common());
        }
    }

    static class Bean1 {
        private final Common common;
        Bean1(Common common) {
            this.common = common;
        }
    }

    static class Bean2 {
        private final Common common;
        Bean2(Common common) {
            this.common = common;
        }
    }

    static class Common {

    }
}
