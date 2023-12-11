package practice.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.springboot.service.HelloService;
import practice.springboot.component.MyComponent;

@MyComponent
@RestController // 이 애노테이션에도 이미 @Component가 들어있다.
@RequestMapping("/hello")
public class HelloController {
    private final HelloService helloService;

    // 해당 부분에서 생성자로 HelloService interface를 지정해 줬으므로 빈을 호출할 때 자동으로 의존 관계를 맺도록 한다.
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    public String hello(String name) {
        if (name == null || name.trim().length() == 0) throw new IllegalArgumentException();

        // null 인경우를 방지하기 위해 Objects 로 감싸기
        return helloService.sayHello(name);
    }
}
