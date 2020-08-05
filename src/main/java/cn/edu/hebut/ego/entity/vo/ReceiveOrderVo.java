package cn.edu.hebut.ego.entity.vo;

import cn.edu.hebut.ego.entity.Goods;
import cn.edu.hebut.ego.entity.Orders;
import cn.edu.hebut.ego.mapper.GoodsMapper;
import cn.edu.hebut.ego.mapper.UsersMapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.core.annotation.Order;

import javax.annotation.Resource;

/**
 * @author tianziyi
 */
@Data
@ApiModel(value = "收到订单返回类")
public class ReceiveOrderVo{

    @ApiModelProperty(value = "物品名称")
    private String goodName;

    @ApiModelProperty(value = "订单号")
    private String orderId;

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

    public ReceiveOrderVo(String goodName,Orders order) {
        this.goodName = goodName;
        this.expressId = order.getExpressId();
        this.goodId = order.getGoodId();
        this.note = order.getNote();
        this.orderId = order.getOrderId();
        this.payMethod = order.getPayMethod();
        this.payTime = order.getPayTime();
        this.price = order.getPrice();
        this.receiveAddress = order.getReceiveAddress();
        this.receiveName = order.getReceiveName();
        this.receivePhone = order.getReceivePhone();
        this.status = order.getStatus();
        this.sendTime = order.getSendTime();
    }
}
