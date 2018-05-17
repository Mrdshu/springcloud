package test.wsz.springcloud.client.consumer.controller;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.wsz.springcloud.client.consumer.service.FeignExtendService;
import test.wsz.springcloud.client.consumer.service.FeignHelloService;
import test.wsz.springcloud.client.consumer.service.HelloService;

;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 〈〉
 *
 * @author shuzheng_wang
 * @create 2018/4/24
 */
@RestController
public class ConsumerController {
    protected Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private HelloService helloService;

    @Autowired
    private FeignHelloService feignHelloService;

    @Autowired
    private FeignExtendService feignExtendService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.helloService();
    }

    @RequestMapping(value = "/hystrix-command", method = RequestMethod.GET)
    public String helloConsumer2() {
        return helloService.hystrixCommand();
    }

    @RequestMapping(value = "/hystrix-asyncommand", method = RequestMethod.GET)
    public String helloConsumer3() throws ExecutionException, InterruptedException {
        Future<String> rs = helloService.hystrixAsynCommand();

        return rs.get();
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser(Long id) throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String name1 = helloService.getUser(1L);
        String name2 = helloService.getUser(2L);
        context.shutdown();
        return name1 + name2;
    }

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String feignHelloConsumer() {
        return feignHelloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String feignHelloConsumer2() {
        return feignHelloService.hello2("wsz");
    }

    @RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
    public String feignHelloConsumer3() {
        return feignExtendService.hello3();
    }

    @RequestMapping(value = "/feign-consumer4", method = RequestMethod.GET)
    public String feignHelloConsumer4() {
        return feignExtendService.hello4("wsz");
    }

}
