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
@ApiModel(value="Messages对象", description="")
public class Messages extends Model<Messages> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    private Integer id;

    @ApiModelProperty(value = "留言编号")
    private String messageId;

    @ApiModelProperty(value = "留言类型（10买家给商家私密留言，11买家给商品公开评论，12买家给店铺公开评论，15买家公开回复买家留言，20商家私密回复买家留言，21商家公开回复商品留言，22商家公开回复商铺留言，99留言无效）")
    private Integer messageType;

    @ApiModelProperty(value = "发送人id（用户登录名或商家编号）")
    private Integer sendId;

    @ApiModelProperty(value = "被回复者id（用户显示名或商家编号）")
    private Integer receiveId;

    @ApiModelProperty(value = "留言内容正文")
    private String context;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "修改时间")
    private Long updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
