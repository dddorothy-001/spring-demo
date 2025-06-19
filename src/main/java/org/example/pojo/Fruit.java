package org.example.pojo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.math.BigDecimal;

@Schema(description = "水果")
public class Fruit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
//    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "编码")
    private String frCode;

    @Schema(description = "名称")
    private String frName;

    @Schema(description = "价格")
    private BigDecimal frPrice;
}
