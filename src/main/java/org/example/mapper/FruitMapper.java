package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Fruit;

/**
 * <p>
 * 水果 Mapper 接口
 * </p>
 *
 * @author Dorothy
 * @since 2025-06-20 11:16
 */
@Mapper
public interface FruitMapper extends BaseMapper<Fruit> {

}
