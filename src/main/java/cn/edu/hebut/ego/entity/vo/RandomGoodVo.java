package cn.edu.hebut.ego.entity.vo;

import cn.edu.hebut.ego.entity.Goods;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;

/**
 * <p>
 *  随机获取商品列表返回类
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-31
 */
@Data
@ApiModel(value = "随机获取商品")
public class RandomGoodVo extends ArrayList<Goods> {

}
