package cn.wzy.demo.aspect.annotation;

import java.lang.annotation.*;
/**
 * @ClassName Verify
 * @Author WangZY
 * @Date 2019/6/5 9:25
 * @Version 1.0
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Verify {
    String[] NotNull() default {};

    String[] SizeLimit() default {};
}
