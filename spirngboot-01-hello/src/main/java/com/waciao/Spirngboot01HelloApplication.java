package com.waciao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author byoji
 * // 标注这个类是一个 springboot 的应用，启动类下的所有资源被导入
 * @SpringBootApplication
 *      // springboot 的配置
 *      @SpringBootConfiguration
 *          // spring 配置类
 *          @Configuration
 *              // 说明这也是一个 spring 的组件
 *              @Component
 *      // 开启自动配置
 *      @EnableAutoConfiguration
 *          // 自动配置包
 *          @AutoConfigurationPackage
 *              // 自动配置`包注册`
 *              @Import({Registrar.class})
 *              // 自动配置导入选择
 *              @Import({AutoConfigurationImportSelector.class})
 *                  // 获取所有的配置     getCandidateConfigurations:获取候选的配置
 *                  List<String> configurations = this.getCandidateConfigurations(annotationMetadata, attributes);
 *
 *  结论：springboot 所有自动配置都是在启动的时候扫描并加载的，spring.factories 所有的自动配置类都在这里面，但是不一定生效，要判断条件是否成立，
 *       只要导入对应的 start，就有了对应的启动器，有了启动器，我们自动装配就会生效，然后就配置成功。
 */
@SpringBootApplication
public class Spirngboot01HelloApplication {
    /**
     * 将 springboot 应用启动
     *
     * SpringApplication 类
     * run 方法：开启了一个服务
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Spirngboot01HelloApplication.class, args);
    }

}
