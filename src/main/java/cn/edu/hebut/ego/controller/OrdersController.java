package cn.edu.hebut.ego.controller;


import cn.edu.hebut.ego.common.ApiResponse;
import cn.edu.hebut.ego.common.CommonConstant;
import cn.edu.hebut.ego.common.ErrorCodeEnum;
import cn.edu.hebut.ego.common.TokenCheck;
import cn.edu.hebut.ego.common.exception.BizException;
import cn.edu.hebut.ego.common.exception.ErrorTokenException;
import cn.edu.hebut.ego.entity.Orders;
import cn.edu.hebut.ego.entity.request.LoginRequest;
import cn.edu.hebut.ego.entity.request.ReceiveOrderRequest;
import cn.edu.hebut.ego.entity.vo.LoginVo;
import cn.edu.hebut.ego.service.IOrdersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-30
 */
@RestController
@RequestMapping("/ego/orders")
public class OrdersController {

    @Autowired
    IOrdersService iOrdersService;

    @CrossOrigin
    @ApiOperation(value = "查看收到的订单", tags = CommonConstant.GET_RECIEVE_ORDER)
    @PostMapping("/getReceiveOrder")
    public ApiResponse<List<Orders>> getReceiveOrder(
//            @ApiParam(value = "用户自增id") @RequestParam(name = "userId") Integer userId
            @RequestBody ReceiveOrderRequest receiveOrderRequest
            ) {
        List<Orders> receiveOrderList = new ArrayList<Orders>();
        try {
            TokenCheck tokenCheck = new TokenCheck();
            tokenCheck.check(receiveOrderRequest.getId(), receiveOrderRequest.getToken());
            receiveOrderList = iOrdersService.getReceiveOrder(receiveOrderRequest.getId());
        } catch (ErrorTokenException e){
            return ApiResponse.error(401,e.getErrMessage(),null);
        } catch (BizException e) {
//            logger.error("登录失败", e);
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
//            logger.error("登录失败", e);
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(receiveOrderList);
    }
}
