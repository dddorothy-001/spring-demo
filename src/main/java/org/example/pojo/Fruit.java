package org.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Getter
@Setter
@TableName("fruit")
@Schema(description = "水果")
public class Fruit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "编码")
    @TableField("fr_code")
    private String frCode;

    @Schema(description = "名称")
    @TableField("fr_name")
    private String frName;

    @Schema(description = "价格")
    @TableField("fr_price")
    private BigDecimal frPrice;
}
