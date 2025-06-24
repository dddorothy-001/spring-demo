package org.example.service.impl;

import org.example.pojo.Record;
import org.example.mapper.RecordMapper;
import org.example.service.IRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 水果销售记录表 服务实现类
 * </p>
 *
 * @author Dorothy
 * @since 2025-06-23 15:00
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {

}
