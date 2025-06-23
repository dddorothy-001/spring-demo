package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.pojo.Fruit;
import org.example.pojo.R;
import org.example.service.IFruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 水果 前端控制器
 * </p>
 *
 * @author Dorothy
 * @since 2025-06-20 11:16
 */
@Tag(name = "TestController", description = "水果相关接口")
@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    private IFruitService fruitService;

    @GetMapping("/getAllFruits")
    @Operation(summary  = "获取所有水果", description = "获取所有水果")
    public Object getAllFruits() {
        List<Fruit> list = fruitService.list();
        return R.success(list);
    }

    @GetMapping("/getPriceByName")
    @Operation(summary = "通过水果名获取价格", description = "通过水果名获取价格")
    public Object getPriceByName(@Parameter(description = "水果名", example = "苹果") @RequestParam String name) {
        Fruit fruit = fruitService.selectByName(name);
        if (fruit == null) {
            return R.error("水果不存在");
        }
        return R.success(fruit);
    }

    @PostMapping("/calcPrice")
    @Operation(summary = "计算总价", description = "计算总价")
    public Object calcPrice(@RequestBody Map<Integer, BigDecimal> map) {
        BigDecimal bigDecimal = fruitService.calcPrice(map);
        return R.success(bigDecimal);
    }

    @PostMapping("/pay")
    @Operation(summary = "支付钱财", description = "支付钱财")
    public Object pay(@RequestBody Map<Integer, BigDecimal> map) {
        fruitService.pay(map);
        return R.success("ok");
    }


}
