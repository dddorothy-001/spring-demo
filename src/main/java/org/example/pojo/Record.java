package org.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 水果销售记录表
 * </p>
 *
 * @author Dorothy
 * @since 2025-06-23 15:00
 */
@Getter
@Setter
@Accessors(chain = true)
@Schema(name = "Record", description = "水果销售记录表")
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "自增ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "水果ID")
    private Integer frId;

    @Schema(description = "单价(元)")
    private BigDecimal frPrice;

    @Schema(description = "重量(kg)")
    private BigDecimal reWeight;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
