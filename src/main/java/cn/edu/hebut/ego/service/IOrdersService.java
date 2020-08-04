package cn.edu.hebut.ego.service;

import cn.edu.hebut.ego.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-30
 */
public interface IOrdersService extends IService<Orders> {

    List<Orders> getReceiveOrder(Integer userId,String token);
}
