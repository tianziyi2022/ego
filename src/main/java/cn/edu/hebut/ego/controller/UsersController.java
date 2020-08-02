package cn.edu.hebut.ego.controller;


import cn.edu.hebut.ego.common.ApiResponse;
import cn.edu.hebut.ego.common.CommonConstant;
import cn.edu.hebut.ego.common.ErrorCodeEnum;
import cn.edu.hebut.ego.common.exception.BizException;
import cn.edu.hebut.ego.entity.Users;
import cn.edu.hebut.ego.entity.request.LoginRequest;
import cn.edu.hebut.ego.entity.request.RegisterRequest;
import cn.edu.hebut.ego.entity.vo.LoginVo;
import cn.edu.hebut.ego.entity.vo.RegisterVo;
import cn.edu.hebut.ego.service.IUsersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-30
 */
@RestController
@RequestMapping("/ego/users")
public class UsersController {

    @Autowired
    IUsersService iUsersService;

    @CrossOrigin
    @ApiOperation(value = "用户登陆", tags = CommonConstant.LOGIN_USER)
    @PostMapping("/login")
    public ApiResponse<LoginVo> login(
            @RequestBody LoginRequest loginRequest
    ) {
        LoginVo loginVo = new LoginVo();
        try {
//            LoginRequest loginRequest = new LoginRequest();
//            loginRequest.setUserId(userId);
//            loginRequest.setPassword(password);
            loginVo = iUsersService.login(loginRequest);
        } catch (BizException e) {
//            logger.error("登录失败", e);
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
//            logger.error("登录失败", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(loginVo);
    }

    @CrossOrigin
    @ApiOperation(value = "用户注册", tags = CommonConstant.REGISTER_USER)
    @PostMapping("/register")
    public ApiResponse<RegisterVo> register(
//            @ApiParam(value = "登录用户名") @RequestParam(name = "userId") String userId,
//            @ApiParam(value = "密码") @RequestParam(name = "password") String password,
//            @ApiParam(value = "显示用户名") @RequestParam(name = "userName") String userName,
//            @ApiParam(value = "电话号码") @RequestParam(name = "phone") String phone,
//            @ApiParam(value = "性别") @RequestParam(name = "sex") Integer sex,
//            @ApiParam(value = "校区") @RequestParam(name = "campus") Integer campus
            @RequestBody RegisterRequest registerRequest
    ) {
        RegisterVo registerVo = new RegisterVo();
        try {
//            RegisterRequest registerRequest = new RegisterRequest();
//            registerRequest.setUserId(userId);
//            registerRequest.setPassword(password);
//            registerRequest.setUserName(userName);
//            registerRequest.setPhone(phone);
//            registerRequest.setSex(sex);
//            registerRequest.setCampus(campus);
            registerVo = iUsersService.register(registerRequest);
        } catch (BizException e) {
//            logger.error("登录失败", e);
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
//            logger.error("登录失败", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(registerVo);
    }

}
