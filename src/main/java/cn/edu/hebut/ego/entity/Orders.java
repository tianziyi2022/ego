package cn.edu.hebut.ego.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Orders对象", description="")
public class Orders extends Model<Orders> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    private Integer id;

    @ApiModelProperty(value = "订单号")
    private String orderId;

    @ApiModelProperty(value = "购买方id")
    private Integer userId;

    @ApiModelProperty(value = "商家id")
    private Integer salerId;

    @ApiModelProperty(value = "购买商品id")
    private Integer goodId;

    @ApiModelProperty(value = "成交金额")
    private Double price;

    @ApiModelProperty(value = "收件人姓名")
    private String receiveName;

    @ApiModelProperty(value = "收件人电话")
    private String receivePhone;

    @ApiModelProperty(value = "收件人地址")
    private String receiveAddress;

    @ApiModelProperty(value = "快递单号")
    private String expressId;

    @ApiModelProperty(value = "发货时间")
    private Long sendTime;

    @ApiModelProperty(value = "订单备注")
    private String note;

    @ApiModelProperty(value = "订单状态（0未付款，10已付款，1未付款时取消订单，11付款后取消订单，15付款后退款成功，20已发货，21发货后取消订单，22发货后货物返回，25发货后退款成功，99订单强制取消）")
    private Integer status;

    @ApiModelProperty(value = "支付方式（0未支付，100现金支付，210微信支付，220支付宝，230云闪付，300银联支付，400VISA支付）")
    private Integer payMethod;

    @ApiModelProperty(value = "支付时间")
    private Long payTime;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
