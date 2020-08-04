package cn.edu.hebut.ego.service.impl;

import cn.edu.hebut.ego.common.exception.BizException;
import cn.edu.hebut.ego.entity.Orders;
import cn.edu.hebut.ego.entity.Users;
import cn.edu.hebut.ego.mapper.OrdersMapper;
import cn.edu.hebut.ego.mapper.UsersMapper;
import cn.edu.hebut.ego.service.IOrdersService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-30
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    @Resource
    OrdersMapper ordersMapper;

    @Resource
    UsersMapper usersMapper;

    @Override
    public List<Orders> getReceiveOrder(Integer userId,String token){
        Users user = usersMapper.selectById(userId);
        if(Objects.isNull(user)){
            throw new BizException("用户不存在");
        }
        if(!user.getStatus().equals(10)) {
            throw new BizException("用户状态异常");
        }
        if(!user.getToken().equals(token)){
            throw new BizException("token验证失败");
        }
        Orders order = new Orders();
        order.setSalerId(userId);
        List<Orders> receiveOrderList = new ArrayList<Orders>();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(order);
        receiveOrderList = ordersMapper.selectList(queryWrapper);
        return receiveOrderList;
    }


}
