package test.shiro;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author weilai <br/>
 * ==========================
 * Created with IDEA
 * Date: 2018/5/14
 * Time: 下午11:06
 * ==========================
 */
public class JdbcRealmTest {

    DruidDataSource druidDataSource = new DruidDataSource();

    {
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/shiro_test");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("5261336");
    }


    @Test
    public void testAuthentication() {

        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(druidDataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);

        String sql = "select password from test_user where username = ?";
        jdbcRealm.setAuthenticationQuery(sql);

        sql = "select role_name from test_user_role where username = ?";
        jdbcRealm.setUserRolesQuery(sql);

        // 1. 构建 SecurityManager 环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);

        // 2. 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

//        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "123456");
        UsernamePasswordToken token = new UsernamePasswordToken("lc1", "123");
        subject.login(token);

        System.out.println("isAuthenticated: " + subject.isAuthenticated());

//        subject.checkRoles("admin", "user");
        subject.checkRoles("visitor");
//        subject.checkPermission("user:select");

    }

}
