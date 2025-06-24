package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Record;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 水果销售记录表 Mapper 接口
 * </p>
 *
 * @author Dorothy
 * @since 2025-06-23 15:00
 */
@Mapper
public interface RecordMapper extends BaseMapper<Record> {

    int insertBatchColumn(@Param("list") List<Record> records);

}
