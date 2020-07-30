package cn.edu.hebut.ego.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *  登陆返回类
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-29
 */
@Data
@ApiModel(value = "登陆")
public class LoginVo {

    @ApiModelProperty(value = "用户id")
    private Integer id;

    @ApiModelProperty(value = "用户昵称")
    private String userName;

    @ApiModelProperty(value = "登陆令牌")
    private String token;

}
