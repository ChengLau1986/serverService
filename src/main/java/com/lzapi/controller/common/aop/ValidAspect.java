package com.lzapi.controller.common.aop;

import com.lzapi.common.CodeMsg;
import com.lzapi.common.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.Valid;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lc on 2018/6/10.
 */
@Aspect
public class ValidAspect {
//    @Autowired
//    private Validator validator;

    @Around("@annotation(org.springframework.web.bind.annotation.ResponseBody)")
    public Object doTest(ProceedingJoinPoint pjp) throws Throwable{
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        if(!Result.class.equals(method.getReturnType())){
            pjp.proceed();
        }
        Object[] args = pjp.getArgs();
        Annotation[][] annotations = method.getParameterAnnotations();
        for(int i = 0; i < annotations.length; i++){
            if(!hasValidAnnotation(annotations[i])){
                continue;
            }
            if(!(i < annotations.length-1 && args[i+1] instanceof BindingResult)){
                //验证对象后面没有跟bindingResult,事实上如果没有应该到不了这一步
                continue;
            }
            BindingResult result = (BindingResult) args[i+1];
            if(result.hasErrors()){
                return Result.Error(CodeMsg.Err_Param,processErrors(result));
            }
        }
        return pjp.proceed();
    }

    private boolean hasValidAnnotation(Annotation[] annotations){
        if(annotations == null){
            return false;
        }
        for(Annotation annotation : annotations){
            if(annotation instanceof Valid){
                return true;
            }
        }
        return false;
    }

    private List<Map<String,String>> processErrors(BindingResult result){
        if(result != null && result.hasErrors()){
            List<Map<String,String>> list = new ArrayList<Map<String,String>>();
            for(ObjectError error : result.getAllErrors()){
                Map<String,String> be = new HashMap<String,String>();
                be.put("errorMsg",error.getDefaultMessage());
                be.put("name",error.getObjectName());
                list.add(be);
            }
            return list;
        }
        return null;
    }
}
