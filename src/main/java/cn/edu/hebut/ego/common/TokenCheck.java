package cn.edu.hebut.ego.common;

import cn.edu.hebut.ego.common.exception.ErrorTokenException;
import cn.edu.hebut.ego.entity.Users;
import cn.edu.hebut.ego.mapper.UsersMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author tianziyi
 */
public class TokenCheck {

    UsersMapper usersMapper;

    public void check(Integer id,String token){
        Users users1 = new Users();
//        users1.setId(id);
//        QueryWrapper queryWrapper1 = new QueryWrapper();
//        queryWrapper1.setEntity(users1);
        Users user1 = usersMapper.selectById(id);
        if (Objects.isNull(user1)) {
            throw new ErrorTokenException("用户不存在");
        }else if(!user1.getToken().equals(token)){
            throw new ErrorTokenException("token验证失效");
        }
    }
}
