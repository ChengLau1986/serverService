package test;

import com.lzapi.pojo.ShiroFilter;
import com.lzapi.service.LoginService;
import com.lzapi.service.ShiroFilterService;
import com.lzapi.service.UserService;
import com.lzapi.service.impl.LoginImpl;
import com.lzapi.service.impl.ShiroFilterImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by lc on 2018/7/2.
 */
public class controller {
    @Test
    public void getShiroFilter(){
        String[] locations = {"spring.xml"};
        ApplicationContext context = new ClassPathXmlApplicationContext(locations);
//        LoginService userService = context.getBean(LoginImpl.class);
//        userService.getUser("user","123456");
        ShiroFilterService customService = (ShiroFilterService)context.getBean(ShiroFilterImpl.class);
        List<ShiroFilter> filters = customService.getShiroFilter();

    }
}
