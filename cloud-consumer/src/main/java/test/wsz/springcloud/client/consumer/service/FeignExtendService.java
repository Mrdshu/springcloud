package test.wsz.springcloud.client.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import test.wsz.springcloud.service.api.HelloService;

@FeignClient("cloud-service-provider")
public interface FeignExtendService extends HelloService {

}
