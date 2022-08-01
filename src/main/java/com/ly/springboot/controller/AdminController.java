package com.ly.springboot.controller;

import com.ly.springboot.entity.Admin;
import com.ly.springboot.entity.ApiResult;
import com.ly.springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    //根据id查询管理员信息
    @GetMapping("/admin/{id}")
    ApiResult selectById(@PathVariable int id){
        Admin admin = adminService.getById(id);
        if (admin != null){
            return new ApiResult(200,"查询成功！",admin);
        }
        return new ApiResult(400,"查询失败！",null);
    }

    //查询全部管理员信息
    @GetMapping("/admins")
    ApiResult selectAll(){
        List<Admin> admin = adminService.list();
        if (admin != null){
            return new ApiResult(200,"查询成功！",admin);
        }
        return new ApiResult(400,"查询失败！",null);
    }

    //根据id删除管理员信息
    @DeleteMapping("/admin/{id}")
    ApiResult deleteById(@PathVariable int id){
        boolean res = adminService.removeById(id);
        if (res){
            return new ApiResult(200,"删除成功！", true);
        }
        return new ApiResult(404,"删除失败！", false);
    }

    //更新管理员信息
    @PutMapping("/admin")
    ApiResult updateById(@RequestBody Admin admin){
        boolean res = adminService.updateById(admin);
        if (res){
            return new ApiResult(200,"更新成功！", true);
        }
        return new ApiResult(400,"更新失败！", false);
    }

    //添加管理员信息
    @PostMapping("/admin")
    ApiResult insert(@RequestBody Admin admin){
        boolean res = adminService.save(admin);
        if (res){
            return new ApiResult(200,"添加成功！", true);
        }
        return new ApiResult(400,"添加失败！", false);
    }
}
