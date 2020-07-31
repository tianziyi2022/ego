package cn.edu.hebut.ego.mapper;

import cn.edu.hebut.ego.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 售卖物品表 Mapper 接口
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-30
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    @Select(" select count(*) from goods ")
    public int count();

}
