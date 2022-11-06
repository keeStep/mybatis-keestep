package org.kee.mybatis.reflection.invoker;

import java.lang.reflect.Field;

/**
 * <p> Getter 调用者
 *
 * @author Eric
 * @date 2022/11/6 20:08
 */
public class GetFieldInvoker implements Invoker {

    private Field field;

    public GetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return field.get(target);
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
