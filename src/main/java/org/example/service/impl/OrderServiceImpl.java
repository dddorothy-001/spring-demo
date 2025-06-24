package org.example.service.impl;

import org.example.pojo.Order;
import org.example.mapper.OrderMapper;
import org.example.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Dorothy
 * @since 2025-06-23 17:45
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
