package cn.edu.hebut.ego.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tianziyi
 */
@Data
@ApiModel(value = "登陆请求参数")
public class RegisterRequest {

    @ApiModelProperty(value = "登陆用户名")
    private String userId;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "显示用户名")
    private String userName;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "性别（10男，20女）")
    private Integer sex;

    @ApiModelProperty(value = "校区（11北辰西区，12北辰东区，21红桥东院，22红桥北院，23红桥南院，30廊坊，40芬兰）")
    private Integer campus;
}

