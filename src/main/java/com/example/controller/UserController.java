package com.example.controller;

import com.example.common.Result;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")

public class UserController {
    @Resource
    private UserService userService;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping
    public Result add(@RequestBody User user){
        userService.save(user);
        return Result.success();
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PutMapping
    public Result update(@RequestBody User user){
        userService.save(user);
        return Result.success();
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        userService.del(id);
        return Result.success();
    }

    /**
     *根据id查询用户
     *
     */
    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable Long id){
        return Result.success(userService.findid(id));
    }

    /**
     * 分页模糊查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Page<User>> findPage(@RequestParam(required = false,value = "1")Integer pageNum,
                                       @RequestParam(required = false,value = "10")Integer pagesize,
                                       @RequestParam(required = false) String name) {
        return Result.success(userService.findPage(pageNum,pagesize,name));
    }
}
