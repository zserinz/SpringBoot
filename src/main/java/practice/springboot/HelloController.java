package practice.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

public class HelloController {
    private final HelloService helloService;

    // 해당 부분에서 생성자로 HelloService interface를 지정해 줬으므로 빈을 호출할 때 자동으로 의존 관계를 맺도록 한다.
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name) {
        // null 인경우를 방지하기 위해 Objects 로 감싸기
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
