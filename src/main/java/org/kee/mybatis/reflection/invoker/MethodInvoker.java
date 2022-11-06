package org.kee.mybatis.reflection.invoker;

import java.lang.reflect.Method;

/**
 * <p> 对象方法调用者
 *
 * @author Eric
 * @date 2022/11/6 20:11
 */
public class MethodInvoker implements Invoker {

    private Method method;
    private Class<?> type;

    public MethodInvoker(Method method) {
        this.method = method;

        // 如果只有一个参数，返回参数类型；否则返回 returnType
        if (method.getParameterTypes().length == 1) {
            type = method.getParameterTypes()[0];
        } else {
            type = method.getReturnType();
        }
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return method.invoke(target, args);
    }

    @Override
    public Class<?> getType() {
        return type;
    }
}
