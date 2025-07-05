package org.example.controller;


import org.example.config.LoginUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class TestController {


    @GetMapping("/list")
    public String list(@AuthenticationPrincipal LoginUser loginUser) {
        return "用户是： " + loginUser.getUsername() + "📄 用户列表（需要 READ_PRIVILEGE）;";
    }

    @PostMapping("/add")
    public String add() {
        return "➕ 添加用户（需要 WRITE_PRIVILEGE）";
    }

    @PutMapping("/update")
    public String update() {
        return "✏️ 更新用户（需要 UPDATE_PRIVILEGE）";
    }

    @DeleteMapping("/delete")
    public String delete() {
        return "❌ 删除用户（需要 DELETE_PRIVILEGE）";
    }

    @GetMapping("/public")
    public String open(@AuthenticationPrincipal LoginUser loginUser) {
        return "用户是： " + loginUser.getUsername() + "🌍 公开页面，任何人都能访问";
    }
}
