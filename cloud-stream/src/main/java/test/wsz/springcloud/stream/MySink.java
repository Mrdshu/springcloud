package test.wsz.springcloud.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

;

/**
 * 〈〉
 *
 * @author shuzheng_wang
 * @create 2018/5/31
 */
public interface MySink {
    String INPUT = "myChannel";

    @Input(INPUT)
    SubscribableChannel input();
}
