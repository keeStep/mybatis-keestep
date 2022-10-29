package org.kee.mybatis.builder;

import org.kee.mybatis.session.Configuration;
import org.kee.mybatis.type.TypeAliasRegistry;

/**
 * @description 构建器的基类，建造者模式
 * @author kee
 * @date 2022/10/29
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
