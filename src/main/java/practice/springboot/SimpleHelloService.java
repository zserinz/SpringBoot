package practice.springboot;

import org.springframework.stereotype.Service;

@Service // @Component가 들어있다.
public class SimpleHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
