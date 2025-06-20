package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.entity.Fruit;
import org.example.pojo.R;
import org.example.service.IFruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}
