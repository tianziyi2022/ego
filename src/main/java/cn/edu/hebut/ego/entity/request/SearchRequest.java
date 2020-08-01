package cn.edu.hebut.ego.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tianziyi
 */
@Data
@ApiModel(value = "查询请求参数")
public class SearchRequest {

    @ApiModelProperty("查询关键字")
    private String key;

}
