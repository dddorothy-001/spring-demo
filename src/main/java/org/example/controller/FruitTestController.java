package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "TestController", description = "水果相关接口")
@RestController
@RequestMapping("/goods/fruit")
public class FruitTestController {

//    @PutMapping("/update")
//    @Operation(summary = "update", description = "更新水果信息")
//    @Parameter(name = "fruit",description = "需要更新的水果")
//    public Object update(Fruit fruit) {
//        return fruitService.updateById(fruit);
//    }

    @GetMapping("/hello")
    @Operation(summary  = "一个用于打招呼的接口", description = "输入名字，回复招呼内容")
    public Object hello(@Parameter(description = "需要打招呼的人",example="Dorothy") @RequestParam String userName) {
        return "hello" + userName;
    }


}
