package cn.edu.hebut.ego.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tianziyi
 */
@Data
@ApiModel(value = "商家获取订单请求参数")
public class ReceiveOrderRequest {

    @ApiModelProperty(value = "用户id")
    private Integer id;

}
