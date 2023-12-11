package practice.springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {
    @Test // DI 수준에서 테스트 코드를 실행하므로 매우 빠르고 간결하다.
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService();

        String ret = helloService.sayHello("Test");
        Assertions.assertThat(ret).isEqualTo("hello Test");
    }
}
