package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 水果
 * </p>
 *
 * @author Dorothy
 * @since 2025-06-20 11:16
 */
@Getter
@Setter
@Accessors(chain = true)
@Schema(description = "水果类")
@TableName("fruit")
public class Fruit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "编码")
    private String frCode;

    @Schema(description = "名称")
    private String frName;

    @Schema(description = "价格")
    private BigDecimal frPrice;
}
