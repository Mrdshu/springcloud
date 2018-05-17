package test.wsz.springcloud.service.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

;

/**
 * 〈〉
 *
 * @author shuzheng_wang
 * @create 2018/4/24
 */
@RequestMapping("refactor")
public interface HelloService {

    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    public String hello3() ;

    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    public String hello4(@RequestParam("name") String name);
}
