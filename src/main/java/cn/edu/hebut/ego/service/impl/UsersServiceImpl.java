package cn.edu.hebut.ego.service.impl;

import cn.edu.hebut.ego.common.exception.BizException;
import cn.edu.hebut.ego.entity.Users;
import cn.edu.hebut.ego.entity.request.LoginRequest;
import cn.edu.hebut.ego.entity.request.RegisterRequest;
import cn.edu.hebut.ego.entity.vo.LoginVo;
import cn.edu.hebut.ego.entity.vo.RegisterVo;
import cn.edu.hebut.ego.mapper.UsersMapper;
import cn.edu.hebut.ego.service.IUsersService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-30
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Resource
    UsersMapper usersMapper;

    @Override
    public LoginVo login(LoginRequest loginRequest) {
        String userId = loginRequest.getUserId();
        String password = loginRequest.getPassword();
        Users users1 = new Users();
        users1.setUserId(userId);
        QueryWrapper queryWrapper1 = new QueryWrapper();
        queryWrapper1.setEntity(users1);
        Users user1 = usersMapper.selectOne(queryWrapper1);
        if (Objects.isNull(user1)) {
            users1 = new Users();
            users1.setPhone(userId);
            QueryWrapper queryWrapper2 = new QueryWrapper();
            queryWrapper2.setEntity(users1);
            user1 = usersMapper.selectOne(queryWrapper2);
        }
        if (Objects.isNull(user1)) {
            throw new BizException("用户名不存在");
        }
        else if (user1.getStatus() == 20) {
            throw new BizException("该账户已注销");
        }
        else if (user1.getStatus() == 0) {
            throw new BizException("该账户被锁定");
        }
        else if (user1.getStatus() != 10) {
            throw new BizException("该账户状态异常");
        }
        else if(!user1.getPassword().equals(password)){
            throw new BizException("密码不正确");
        }
        user1.setToken("token-" + UUID.randomUUID());
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.setEntity(users1);
        usersMapper.update(user1, updateWrapper);
        LoginVo loginVo = new LoginVo();
        loginVo.setId(user1.getId());
        loginVo.setToken(user1.getToken());
        loginVo.setUserName(user1.getUserName());
        return loginVo;
    }

    @Override
    public RegisterVo register(RegisterRequest registerRequest) {
        Users user0 = new Users();
        user0.setUserId(registerRequest.getUserId());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(user0);
        Users user = usersMapper.selectOne(queryWrapper);
        if (!Objects.isNull(user)) {
            throw new BizException("用户名重复");
        }
        user0 = new Users();
        user0.setPhone(registerRequest.getPhone());
        user0.setStatus(10);
        queryWrapper.setEntity(user0);
        user = usersMapper.selectOne(queryWrapper);
        if (!Objects.isNull(user)) {
            throw new BizException("电话号码重复");
        }
        if (registerRequest.getPhone().length() != 0 && registerRequest.getPhone().length() != 11) {
            throw new BizException("电话号码输入非法");
        }
        user0 = new Users();
        user0.setUserId(registerRequest.getUserId());
        user0.setUserName(registerRequest.getUserName());
        user0.setPassword(registerRequest.getPassword());
        user0.setPhone(registerRequest.getPhone());
        user0.setStatus(10);
        user0.setMemberPoint(0);
        user0.setCampus(registerRequest.getCampus());
        user0.setCreateTime(System.currentTimeMillis());
        user0.setUpdateTime(System.currentTimeMillis());
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.setEntity(user0);
        usersMapper.insert(user0);
        QueryWrapper queryWrapper1 = new QueryWrapper();
        queryWrapper1.setEntity(user0);
        Users passenger1 = usersMapper.selectOne(queryWrapper1);
        UpdateWrapper updateWrapper1 = new UpdateWrapper();
        updateWrapper1.setEntity(user0);
        usersMapper.update(passenger1, updateWrapper1);
        QueryWrapper queryWrapper2 = new QueryWrapper();
        queryWrapper1.setEntity(user0);
        Users user1 = usersMapper.selectOne(queryWrapper1);
        RegisterVo registerVo = new RegisterVo();
        registerVo.setId(user1.getId());
        registerVo.setUserName(user1.getUserName());
        return registerVo;
    }


}
