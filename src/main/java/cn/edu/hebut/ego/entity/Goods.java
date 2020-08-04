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
 * 售卖物品表
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Goods对象", description="售卖物品表")
public class Goods extends Model<Goods> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    private Integer id;

    @ApiModelProperty(value = "物品名称")
    private String goodName;

    @ApiModelProperty(value = "物品编号")
    private String goodId;

    @ApiModelProperty(value = "物品价格")
    private Double price;

    @ApiModelProperty(value = "库存数量")
    private Integer quantity;

    @ApiModelProperty(value = "物品描述/详情")
    private String description;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "状态（0未发布，10正在发布，11发布后撤回，12修改后发布，20已售出）")
    private Integer status;

    @ApiModelProperty(value = "卖家用户id")
    private Integer salerId;

    @ApiModelProperty(value = "类型（0未分类，11主食，12零食，13生鲜，21男装，22女装，23箱包，24鞋靴，25内衣，26运动装，31数码，32家装，33电器，41饰品，42洗护，50百货）")
    private Integer goodType;

    @ApiModelProperty(value = "图片数量（最少0，最多5）")
    private Integer pictureCount;

    @ApiModelProperty(value = "图片1地址")
    private String picture1Url;

    @ApiModelProperty(value = "图片2地址")
    private String picture2Url;

    @ApiModelProperty(value = "图片3地址")
    private String picture3Url;

    @ApiModelProperty(value = "图片4地址")
    private String picture4Url;

    @ApiModelProperty(value = "图片5地址")
    private String picture5Url;

    @ApiModelProperty(value = "校区（11北辰西区，12北辰东区，21红桥东院，22红桥北院，23红桥南院，30廊坊，40芬兰）")
    private Integer campus;

    @ApiModelProperty(value = "新旧程度（100全新未开封，95已开封未使用，90九成新，80八成新，以此类推10的倍数低至30，除95外非10的倍数和29以下数字报错）")
    private Integer depreciation;

    @ApiModelProperty(value = "原价/购买价格")
    private Double originalPrice;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
