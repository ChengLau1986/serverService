package test.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by lc on 2018/4/14.
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Async
    public void onApplicationEvent(DemoEvent demoEvent){
        try {
            Thread.sleep(5000);
        }
        catch (Exception e){

        }
        System.out.println("我收到DemoEvent的事件了:"+demoEvent.getMsg());
    }
}
