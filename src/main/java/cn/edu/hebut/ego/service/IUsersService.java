package cn.edu.hebut.ego.service;

import cn.edu.hebut.ego.entity.Users;
import cn.edu.hebut.ego.entity.request.LoginRequest;
import cn.edu.hebut.ego.entity.vo.LoginVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-30
 */
public interface IUsersService extends IService<Users> {
    public LoginVo login(LoginRequest loginRequest);
}
