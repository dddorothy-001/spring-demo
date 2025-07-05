package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.SysUser;
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    SysUser findByUsername(String username);
}
