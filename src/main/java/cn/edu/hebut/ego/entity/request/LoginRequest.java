package cn.edu.hebut.ego.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tianziyi
 */
@Data
@ApiModel(value = "登陆请求参数")
public class LoginRequest {

    @ApiModelProperty(value = "用户名/电话号码")
    private String userId;

    @ApiModelProperty(value = "密码")
    private String password;

}

