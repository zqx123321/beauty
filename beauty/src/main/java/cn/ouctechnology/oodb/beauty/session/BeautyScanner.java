package cn.ouctechnology.oodb.beauty.session;

import cn.ouctechnology.oodb.beauty.annotation.Beauty;
import org.reflections.Reflections;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.util.StringUtils;

import java.util.Set;

import static org.springframework.util.Assert.notNull;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-14 10:41
 * @description: TODO
 **/
public class BeautyScanner implements BeanDefinitionRegistryPostProcessor, InitializingBean {

    private String basePackage;

    private SessionFactory sessionFactory;

    public BeautyScanner() {
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void afterPropertiesSet() {
        notNull(this.basePackage, "Property 'basePackage' is required");
        notNull(this.sessionFactory, "Property 'sessionFactory' is required");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        Reflections reflections = new Reflections(basePackage);
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Beauty.class);
        Session session = sessionFactory.getSession();
        for (Class<?> clz : classSet) {
            //向spring容器中动态添加代理对象的时候，不能简单使用Proxy.newProxyInstance来创建，必须是
            //有构造函数，可以直接new，获取使用FactoryBean接口来创建
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(clz);
            GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
            definition.getPropertyValues().add("interfaceClass", definition.getBeanClassName());
            definition.getPropertyValues().add("session", session);
            definition.setBeanClass(BeautyProxyFactory.class);
            definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
            // 注册bean名,一般为类名首字母小写
            beanDefinitionRegistry.registerBeanDefinition(StringUtils.uncapitalize(clz.getSimpleName()), definition);
        }
    }

    //bean已经被创建，但是没有初始化
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        // left intentionally blank
    }

}
