package cn.edu.hebut.ego.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Users对象", description="用户表")
public class Users extends Model<Users> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "登陆用户名")
    private String userId;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "显示用户名")
    private String userName;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "账号状态（10可用，0被锁定，20已注销）")
    private Integer status;

    @ApiModelProperty(value = "会员积分")
    private Integer memberPoint;

    @ApiModelProperty(value = "收件人姓名")
    private String receiveName;

    @ApiModelProperty(value = "收件人电话号")
    private String receivePhone;

    @ApiModelProperty(value = "收件人地址")
    private String receiveAddress;

    @ApiModelProperty(value = "性别（10男，20女）")
    private Integer sex;

    @ApiModelProperty(value = "QQ号")
    private String qqAccount;

    @ApiModelProperty(value = "微信账号")
    private String wechatAccount;

    @ApiModelProperty(value = "支付宝账号")
    private String alipayAccount;

    @ApiModelProperty(value = "校区（11北辰西区，12北辰东区，21红桥东院，22红桥北院，23红桥南院，30廊坊，40芬兰）")
    private Integer campus;

    @ApiModelProperty(value = "账号备注")
    private String note;

    @ApiModelProperty(value = "登陆令牌")
    private String token;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "修改时间")
    private Long updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
