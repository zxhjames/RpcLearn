package org.example.Prc.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: NacosLearn
 * @description: 反射测试
 * @author: 占翔昊
 * @create 2020-10-21 15:13
 **/
public class MethodInvokeTest {
    private int age;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        // 获取类名
        Class<?> classes = MethodGroup.class;
        Method[] methods = classes.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            Arrays.stream(method.getParameters()).forEach(
                    v -> {
                        System.out.println(v.getName());
                    }
            );
            Arrays.stream(method.getParameterTypes()).forEach(
                    v -> {
                        System.out.println(v.getName());
                    }
            );
           // System.out.println(Arrays.stream(method.getParameterTypes()));
        }
    }
}
