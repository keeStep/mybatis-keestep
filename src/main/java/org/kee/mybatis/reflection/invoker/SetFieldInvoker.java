package org.kee.mybatis.reflection.invoker;

import java.lang.reflect.Field;

/**
 * <p> Setter 调用者
 *
 * @author Eric
 * @date 2022/11/6 20:08
 */
public class SetFieldInvoker implements Invoker {

    private Field field;

    public SetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        field.set(target, args[0]);
        return null;
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
