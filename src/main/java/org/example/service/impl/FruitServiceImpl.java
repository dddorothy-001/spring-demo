package org.example.service.impl;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.example.mapper.FruitMapper;
import org.example.pojo.Fruit;
import org.example.service.IFruitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 水果 服务实现类
 * </p>
 *
 * @author Dorothy
 * @since 2025-06-20 11:16
 */
@Service
public class FruitServiceImpl extends ServiceImpl<FruitMapper, Fruit> implements IFruitService {


    @Override
    public Fruit selectByName(String frName) {
        Fruit one = lambdaQuery().eq(Fruit::getFrName, frName).one();
        return one;
    }

    @Override
    public BigDecimal calcPrice(Map<Integer, BigDecimal> map) {
        Set<Integer> keySet = map.keySet();
        Map<Integer, BigDecimal> fruitMap = lambdaQuery().select(Fruit::getId, Fruit::getFrPrice)
                .in(Fruit::getId, keySet)
                .list()
                .stream()
                .collect(Collectors.toMap(Fruit::getId, Fruit::getFrPrice));

        BigDecimal sum = map.entrySet().stream().map(entry -> {
            Integer fruitId = entry.getKey();
            BigDecimal value = entry.getValue();
            BigDecimal price = fruitMap.get(fruitId);

            if (price == null) {
                price = BigDecimal.ZERO;
            }

            if (value == null) {
                return BigDecimal.ZERO;
            }

            return price.multiply(value);
        }).reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum;
    }

    @Override
    public void pay(Map<Integer, BigDecimal> map) {
        //1、
    }
}
