package cn.edu.hebut.ego.entity.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *  注册返回类
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-29
 */
@Data
@ApiModel(value = "注册")
public class RegisterVo {
    @ApiModelProperty(value = "用户id")
    private Integer id;

    @ApiModelProperty(value = "用户昵称")
    private String userName;

}
