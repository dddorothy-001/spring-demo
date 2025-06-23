package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.pojo.Fruit;

import java.math.BigDecimal;
import java.util.Map;

/**
 * <p>
 * 水果 服务类
 * </p>
 *
 * @author Dorothy
 * @since 2025-06-20 11:16
 */
public interface IFruitService extends IService<Fruit> {

    Fruit selectByName(String name);

    BigDecimal calcPrice(Map<Integer, BigDecimal> map);

    void pay(Map<Integer, BigDecimal> map);
}
