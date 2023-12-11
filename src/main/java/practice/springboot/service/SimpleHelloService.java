package practice.springboot.service;

import org.springframework.stereotype.Service;
import practice.springboot.service.HelloService;

@Service // @Component가 들어있다.
public class SimpleHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
