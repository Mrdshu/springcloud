package test.wsz.springcloud.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

;

/**
 * 〈〉
 *
 * @author shuzheng_wang
 * @create 2018/5/31
 */
@EnableBinding({Sink.class, SinKSender.class})
public class SinKReceiver {
    private static Logger logger = LoggerFactory.getLogger(StreamApplication.class);

    @StreamListener("myChannel")
    public void receive(Object payLoad){
        logger.info("Received: {}", payLoad);
    }
}
