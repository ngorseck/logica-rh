package com.logica.rh;

import com.logica.rh.config.LoggingAspect;
import com.logica.rh.domain.Department;
import com.logica.rh.domain.Employee;
import com.logica.rh.domain.Gender;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;

@Import({TestSecurityConfig.class, AopAutoConfiguration.class, LoggingAspect.class})
public abstract class BaseTestClass {

    protected Employee getEmployee() {
        return new Employee(1L, "Mamadou Lamine", "Ba", Gender.M, "France", "Paris", "Paris defance");
    }

    protected Department getDepartment() {
        return new Department("HR", getEmployee());
    }
    protected String getToken() {
        return "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJycFFqYnhHa2dMamtGRGVRVTRfUGZvdms4SkdqUy1lVEFoazVrZ2MzeVJRIn0.eyJleHAiOjE2NjAwODY5NDIsImlhdCI6MTY2MDA4NTE0MiwiYXV0aF90aW1lIjoxNjYwMDg1MTQxLCJqdGkiOiIyNWU5ZmU5OS1jODlhLTRhN2ItODEzZC0zY2I2MThhNmU0ZmYiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvcmVhbG1zL2xvZ2ljYS1yaCIsInN1YiI6IjU2ODgwOWRjLWVkYTQtNDJjNi04ZmEzLTZjYjE4MGYwMjRhZiIsInR5cCI6IkJlYXJlciIsImF6cCI6ImFjY291bnQiLCJzZXNzaW9uX3N0YXRlIjoiZGI0ZTI3MjQtZTM4Yy00YTllLWFjODYtNmRmZjMxZGM1MzI5IiwiYWNyIjoiMSIsInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJzaWQiOiJkYjRlMjcyNC1lMzhjLTRhOWUtYWM4Ni02ZGZmMzFkYzUzMjkiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwibmFtZSI6Ik5nb3IgU2VjayIsInByZWZlcnJlZF91c2VybmFtZSI6Im5nb3JzZWNrIiwiZ2l2ZW5fbmFtZSI6Ik5nb3IiLCJmYW1pbHlfbmFtZSI6IlNlY2siLCJlbWFpbCI6Im5nb3JzZWNrYUBnbWFpbC5jb20ifQ.KZiEqAiM_bc5MBnetxg5PUPu97hNU98L4ML4X8WopgQkXBTp967PTF2c3DbmNrEqOoL-LEGmMwP6HNXfDjuS_uIUXXjkJWcHGBn_sONDGjcixg2ZJ5Th9iItAVaUD5KtyXz7mrutUfTH1kGjYbf6_TA50FF3RmZHN0n1Ga61EfF2ZOE76qo2OUJrbCZ9BOBCYOQfmC1tvTFeVaK6ijJfgTy82pKp-8v2tYbVMuhF3NyHP2z0ytvF6W_xzVVFsIfXJs1aT5atpz2STtK5lBM0J_8EV518J1qnD2xak0oUOpU_7-4zcSR8trDKhlzsxq2u_N0OYoDhFun9cDaop7119A";
    }

    protected MessageSource getMessageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
