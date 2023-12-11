package practice.springboot.decorator;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import practice.springboot.service.HelloService;

@Service
@Primary // bean 후보 중, 가장 먼저 취급되도록 한다.
public class HelloDecorator implements HelloService {
    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        return "*" + helloService.sayHello(name) + "*";
    }
}
