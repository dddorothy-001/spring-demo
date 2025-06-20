package org.example.service.impl;

import org.example.entity.Fruit;
import org.example.mapper.FruitMapper;
import org.example.service.IFruitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
