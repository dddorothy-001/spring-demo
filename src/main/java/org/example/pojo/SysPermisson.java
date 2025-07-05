package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;

@TableName("sys_permission")
@Data
public class SysPermisson {
    private Integer id;
    private String name;
    private String url;
    private String method;

}
