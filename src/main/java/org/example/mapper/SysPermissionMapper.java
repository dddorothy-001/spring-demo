package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.SysPermisson;

import java.util.List;

@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermisson> {
    List<String> findPermissionsByUserId(Integer id);
}
