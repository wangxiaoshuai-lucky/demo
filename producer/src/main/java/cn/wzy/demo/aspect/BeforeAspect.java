package cn.wzy.demo.aspect;

import cn.wzy.demo.aspect.annotation.Verify;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @ClassName BeforeAspect
 * @Author WangZY
 * @Date 2019/6/5 9:25
 * @Version 1.0
 **/
@Aspect
@Component
public class BeforeAspect {

    @Before("@annotation(verify)")
    public void authAppId(JoinPoint joinPoint, Verify verify) {
        //所有的参数和参数名
        Object[] values = joinPoint.getArgs();
        String[] names = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        JSONObject data = new JSONObject();
        for (int i = 0; i < names.length; i++) {
            data.put(names[i], values[i]);
        }
        String json = JSON.toJSONString(data);
        data = JSON.parseObject(json, JSONObject.class);
        String[] notBlank = verify.NotNull();
        for (String pattern : notBlank) {
            pattern = transform(pattern);
            checkNull(pattern, data);
        }

        String[] strSizeLimit = verify.SizeLimit();
        for (String pattern : strSizeLimit) {
            pattern = transform(pattern);
            SizeLimit limit = resolvePattern(pattern);
            checkSize(limit, data);
        }

    }

    /**
     * 验证长度是否满足条件
     *
     * @param limit
     * @param data
     */
    private void checkSize(SizeLimit limit, JSONObject data) {
        Object value = valueOfPattern(limit.name, data);
        if (value == null) {
            throw new IllegalArgumentException(limit.name + "不能为空");
        }
        if (value instanceof String) {
            String val = (String) value;
            if (!(val.length() >= limit.low && val.length() <= limit.high)) {
                throw new IllegalArgumentException(String.format("%s size越界,size:%d不在[%d,%d]内",
                        limit.name, val.length(), limit.low, limit.high));
            }
        } else if (value instanceof Collection) {
            Collection val = (Collection) value;
            if (!(val.size() >= limit.low && val.size() <= limit.high)) {
                throw new IllegalArgumentException(String.format("%s size越界,size:%d不在[%d,%d]内",
                        limit.name, val.size(), limit.low, limit.high));
            }
        }
    }

    /**
     * 从json中获取参数值
     *
     * @param pattern
     * @param data
     * @return Object
     */
    private Object valueOfPattern(String pattern, JSONObject data) {
        String[] params = pattern.split("\\.");
        Object value = null;
        for (String param : params) {
            value = data.get(param);
            if (value == null)
                return null;
            if (value instanceof JSONObject) {
                data = (JSONObject) value;
            }
        }
        return value;
    }

    /**
     * 压缩字符串
     *
     * @param str
     * @return
     */
    private String transform(String str) {
        while (str.contains(" ")) {
            str = str.replace(" ", "");
        }
        return str;
    }

    /**
     * 检验是否为空
     *
     * @param pattern
     * @param data
     */
    private void checkNull(String pattern, JSONObject data) {
        Object value = valueOfPattern(pattern, data);
        if (value == null) {
            throw new IllegalArgumentException(pattern + " 不能为空");
        }
        if (value instanceof String && !StringUtils.isNotBlank((String) value)) {
            throw new IllegalArgumentException(pattern + " 不能为空");
        }
    }

    /**
     * 获取参数的长度限制配置
     *
     * @param pattern
     * @return
     */
    private SizeLimit resolvePattern(String pattern) {
        SizeLimit res = new SizeLimit();
        int middle = pattern.indexOf("[");
        if (middle == -1) {
            throw new IllegalArgumentException(pattern + " 配置有误");
        }
        res.name = pattern.substring(0, middle);

        int index = pattern.indexOf(",");
        if (index == -1) {
            throw new IllegalArgumentException(pattern + " 配置有误");
        }
        res.low = Integer.valueOf(pattern.substring(middle + 1, index));
        res.high = Integer.valueOf(pattern.substring(index + 1, pattern.length() - 1));
        return res;
    }

    private static class SizeLimit {
        String name;
        Integer low;
        Integer high;
    }
}
