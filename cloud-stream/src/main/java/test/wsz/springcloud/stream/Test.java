package test.wsz.springcloud.stream;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 〈〉
 *
 * @author shuzheng_wang
 * @create 2018/5/31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = StreamApplication.class)
public class Test {

    @Autowired
    private SinKSender sinKSender;

    @org.junit.Test
    public void contextLoads(){
        sinKSender.output().send(MessageBuilder.withPayload("hello 123").build());
    }
}



