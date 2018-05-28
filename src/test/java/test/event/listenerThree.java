package test.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by lc on 2018/4/14.
 * 定义有序监听器 
 */
@Component
public class listenerThree implements SmartApplicationListener{

    @Override
    public boolean supportsEventType(final Class<? extends ApplicationEvent> eventType) {
        return eventType == DemoEvent.class;
    }
    @Override
    public boolean supportsSourceType(final Class<?> sourceType) {
        return sourceType == String.class;
    }

    @Override
    public void onApplicationEvent(final ApplicationEvent  event) {
        System.out.println("UserThreeListener：" + event.getSource());
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
