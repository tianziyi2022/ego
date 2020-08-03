package cn.edu.hebut.ego.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author tianziyi
 */
@Data
@ApiModel(value = "用户详情返回类")
public class UserDetailVo {

    @ApiModelProperty(value = "用户登录名")
    private String userId;

    @ApiModelProperty(value = "用户昵称")
    private String userName;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "校区")
    private Integer campus;

}
