package com.ssl.springbootdemo.web;

import com.ssl.springbootdemo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api
public class WebController {
    @ApiOperation(value = "保存用户")
    @RequestMapping("/saveUser")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户实体类"),
            @ApiImplicitParam(name = "result", value = "格式验证结果集")
    })
    public void saveUser(@Valid User user, BindingResult result) {
        System.out.println("user:" + user);
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error :
                    list) {
                System.out.println(error.getCode() + "-" + error.getDefaultMessage());
            }
        }
    }
}
