package com.lzapi.controller.common.annotation;

import java.lang.annotation.*;

/**
 * Created by lc on 2018/4/3.
 */
@Retention(RetentionPolicy.RUNTIME) //在编译以后仍然起作用
@Target({ElementType.METHOD}) //表明该注解对成员方法起作用
@Documented //支持JavaDoc文档注释
public @interface LogDesc {
    String actionType() default "默认动作类型"; //一般有增加, 删除, 修改, 查询
    String businessLogic() default "默认业务逻辑";
}
