package cn.edu.hebut.ego.service.impl;

import cn.edu.hebut.ego.entity.Orders;
import cn.edu.hebut.ego.mapper.OrdersMapper;
import cn.edu.hebut.ego.service.IOrdersService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Orders> getReceiveOrder(Integer userId){

        Orders order = new Orders();
        order.setSalerId(userId);
        List<Orders> receiveOrderList = new ArrayList<Orders>();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(order);
        receiveOrderList = ordersMapper.selectList(queryWrapper);
        return receiveOrderList;
    }


}
