package org.example.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "统一返回结果")
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "状态码")
    private Integer code;

    @Schema(description = "返回消息")
    private String message;

    @Schema(description = "返回数据")
    private T data;

    @Schema(description = "时间戳")
    private long timestamp = System.currentTimeMillis();

    public static <T> R<T> success(T data) {
        R<T> r = new R<>();
        r.setCode(200);
        r.setMessage("成功");
        r.setData(data);
        return r;
    }

    public static <T> R<T> error(String message) {
        R<T> r = new R<>();
        r.setCode(500);
        r.setMessage(message);
        return r;
    }
}