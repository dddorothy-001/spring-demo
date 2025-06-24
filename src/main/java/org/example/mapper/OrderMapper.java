package org.example.mapper;

import org.example.pojo.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Dorothy
 * @since 2025-06-23 17:45
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
