package com.ly.springboot.controller;

import com.ly.springboot.entity.Admin;
import com.ly.springboot.service.AdminService;
import com.ly.springboot.util.ResultCode;
import com.ly.springboot.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    //根据id查询管理员信息
    @GetMapping("/admin/{id}")
    ResultVo selectById(@PathVariable int id){
        Admin admin = adminService.getById(id);
        if (admin != null){
            return new ResultVo(admin);
        }
        return new ResultVo(ResultCode.FAILED);
    }

    //查询全部管理员信息
    @GetMapping("/admins")
    ResultVo selectAll(){
        List<Admin> admin = adminService.list();
        if (admin != null){
            return new ResultVo(admin);
        }
        return new ResultVo(ResultCode.FAILED);
    }

    //根据id删除管理员信息
    @DeleteMapping("/admin/{id}")
    ResultVo deleteById(@PathVariable int id){
        boolean res = adminService.removeById(id);
        if (res){
            return new ResultVo(200,"删除成功！",res);
        }
        return new ResultVo(400,"删除失败！",res);
    }

    //更新管理员信息
    @PutMapping("/admin")
    ResultVo updateById(@RequestBody Admin admin){
        boolean res = adminService.updateById(admin);
        if (res){
            return new ResultVo(200,"更新成功！",res);
        }
        return new ResultVo(400,"更新失败！",res);
    }

    //添加管理员信息
    @PostMapping("/admin")
    ResultVo insert(@RequestBody Admin admin){
        boolean res = adminService.save(admin);
        if (res){
            return new ResultVo(200,"添加成功！",res);
        }
        return new ResultVo(400,"添加失败！",res);
    }
}
