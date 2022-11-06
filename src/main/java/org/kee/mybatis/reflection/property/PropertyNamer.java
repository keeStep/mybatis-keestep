package org.kee.mybatis.reflection.property;

import java.util.Locale;

/**
 * <p> 属性命名器
 *
 * @author Eric
 * @date 2022/11/6 20:55
 */
public final class PropertyNamer {

    private PropertyNamer() {
        // Prevent Instantiation of Static Class
    }

    /**
     * 方法转为属性
     * @param name
     * @return
     */
    public static String methodToProperty(String name) {
        if (name.startsWith("is")) {
            name = name.substring(2);
        } else if (name.startsWith("get") || name.startsWith("set")) {
            name = name.substring(3);
        } else {
            throw new RuntimeException("Error parsing property name '" + name + "'.  Didn't start with 'is', 'get' or 'set'.");
        }

        /*
         * 如果只有一个字母，转换为小写
         * 如果大于一个字母，且第二个字母非大写，首字母转换为小写
         */
        if (name.length() == 1 || (name.length() > 1 && !Character.isUpperCase(name.charAt(1)))) {
            name = name.substring(0, 1).toLowerCase(Locale.ENGLISH) + name.substring(1);
        }

        return name;
    }

    /**
     * 是否为属性
     * @param name
     * @return
     */
    public static boolean isProperty(String name) {
        return isGetter(name) || isSetter(name);
    }


    /**
     * 是否为 getter
     * @param name
     * @return
     */
    public static boolean isGetter(String name) {
        return (name.startsWith("get") && name.length() > 3) || (name.startsWith("is") && name.length() > 2);
    }

    /**
     * 是否为 setter
     * @param name
     * @return
     */
    public static boolean isSetter(String name) {
        return name.startsWith("set") && name.length() > 3;
    }
}
