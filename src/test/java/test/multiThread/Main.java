package test.multiThread;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by sang on 16-12-14.
 */
public class Main {
  /*  public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService bean = context.getBean(AsyncTaskService.class);
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            bean.executeAsyncTask(i);
            bean.executeAsyncTask2(i);
        }
        context.close();
    }*/

    public static void main(String[] args) {
        Map<String,Object> sf = new Hashtable<>();
        sf.put(null,12);
        sf.put(null,123);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test/multiThread.xml");
        AsyncTaskService bean = context.getBean(AsyncTaskService.class);
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            bean.executeAsyncTask(i);
            bean.executeAsyncTask2(i);
        }
        context.close();
    }
}
