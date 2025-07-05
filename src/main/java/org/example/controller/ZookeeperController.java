package org.example.controller;

import org.example.zk.ZookeeperService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zk")
public class ZookeeperController {

    private final ZookeeperService zookeeperService;

    public ZookeeperController(ZookeeperService zookeeperService) {
        this.zookeeperService = zookeeperService;
    }

    @GetMapping("/create")
    public String create(@RequestParam String path, @RequestParam String data) throws Exception {
        zookeeperService.createNode(path, data);
        return "节点创建成功";
    }

    @GetMapping("/read")
    public String read(@RequestParam String path) throws Exception {
        return zookeeperService.getData(path);
    }

    @PostMapping("/watch")
    public String watch(@RequestParam String path) throws Exception {
        zookeeperService.watchNode(path);
        return "监听已启动";
    }
}

