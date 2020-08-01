package cn.edu.hebut.ego.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tianziyi
 */
@Data
@ApiModel(value = "获取随机商品请求参数")
public class RandomGoodsRequest {
    @ApiModelProperty(value = "获取随机商品请求数量")
    private Integer count;
}
