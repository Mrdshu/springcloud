package test.wsz.springcloud.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

;

/**
 * 〈〉
 *
 * @author shuzheng_wang
 * @create 2018/5/31
 */
public interface SinKSender {

    @Output("myChannel")
    MessageChannel output();
}
