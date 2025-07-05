package org.example.designPattern;

import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {

    private static final Map<Class<?>, Object> services = new HashMap<>();


    //注册服务
    public static <T> void registerService(Class<T> service, T serviceImpl) {
        services.put(service, serviceImpl);
    }

    //获取服务
    public static <T> T getService(Class<T> serviceClass) {
        return serviceClass.cast(services.get(serviceClass));
    }
}
