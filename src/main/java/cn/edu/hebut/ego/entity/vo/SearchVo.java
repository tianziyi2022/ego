package cn.edu.hebut.ego.entity.vo;

import cn.edu.hebut.ego.entity.Goods;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianziyi
 */
@Data
@ApiModel(value = "搜索返回类")
public class SearchVo  {

    @ApiModelProperty(value = "搜索到的数量")
    private Integer count;

    @ApiModelProperty(value = "搜索结果")
    private List<Goods> goodsList;
}
