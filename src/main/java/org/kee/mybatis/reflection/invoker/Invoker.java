package org.kee.mybatis.reflection.invoker;

/**
 * <p> 反射调用者
 *
 * @author Eric
 * @date 2022/11/6 17:51
 */
public interface Invoker {

    Object invoke(Object target, Object[] args) throws Exception;

    Class<?> getType();
}
