package test.wsz.springcloud.client.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

;import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 〈〉
 *
 * @author shuzheng_wang
 * @create 2018/5/8
 */
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    private Map<Long, String> users = new HashMap<Long, String>();

    {
        users.put(1l,"wsz");
        users.put(2l,"akq");
        users.put(3l,"ly");
        users.put(4l,"jdz");
    }

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){
        return restTemplate.getForEntity("http://cloud-service-provider/hello", String.class).getBody();
    }

    /**
     * 同步执行——HystrixCommand
     */
    @HystrixCommand
    public String hystrixCommand(){
        return restTemplate.getForEntity("http://cloud-service-provider/hello", String.class).getBody();
    }

    /**
     * 异步执行——HystrixCommand
     */
    @HystrixCommand
    public Future<String> hystrixAsynCommand(){
         return new AsyncResult<String>(){

            @Override
            public String invoke() {
                return restTemplate.getForEntity("http://cloud-service-provider/hello", String.class).getBody();
            }
        };
    }

    public String helloFallback(){
        return "error";
    }

    @HystrixCollapser(batchMethod = "getUsers",
            collapserProperties = {@HystrixProperty(name="timerDelayInMilliseconds", value = "100")})
    public String getUser(Long id) throws ExecutionException, InterruptedException {

        return null;
    }

    @HystrixCommand
    public List<String> getUsers(List<Long> ids) throws ExecutionException, InterruptedException {
        System.out.println("get users, ids" + ids);
        List<String> names = new ArrayList<String>();

        for (Long id : ids) {
            names.add(users.get(id));
        }
        return names;
    }
}
