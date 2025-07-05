package org.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sys_user")
@Data
public class SysUser {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private Boolean enabled;
}
