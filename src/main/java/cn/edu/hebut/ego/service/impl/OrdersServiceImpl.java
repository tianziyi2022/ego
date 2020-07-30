package cn.edu.hebut.ego.service.impl;

import cn.edu.hebut.ego.entity.Orders;
import cn.edu.hebut.ego.mapper.OrdersMapper;
import cn.edu.hebut.ego.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
