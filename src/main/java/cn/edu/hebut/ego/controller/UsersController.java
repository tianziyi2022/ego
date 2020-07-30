package cn.edu.hebut.ego.controller;


import cn.edu.hebut.ego.common.ApiResponse;
import cn.edu.hebut.ego.common.ErrorCodeEnum;
import cn.edu.hebut.ego.common.exception.BizException;
import cn.edu.hebut.ego.entity.Users;
import cn.edu.hebut.ego.entity.request.LoginRequest;
import cn.edu.hebut.ego.entity.vo.LoginVo;
import cn.edu.hebut.ego.service.IUsersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "常旅客登录", tags = cn.edu.hebut.ego.common.CommonConstant.LOGIN_USER)
    @PostMapping("/login")
    public ApiResponse<LoginVo> login(
            @ApiParam(value = "登录用户名") @RequestParam(name = "userId") String userId,
            @ApiParam(value = "密码") @RequestParam(name = "password") String password
    ) {
        LoginVo loginVo = new LoginVo();
        try {
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setUserId(userId);
            loginRequest.setPassword(password);
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

}
