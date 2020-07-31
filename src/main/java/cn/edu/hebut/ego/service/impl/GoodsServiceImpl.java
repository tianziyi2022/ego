package cn.edu.hebut.ego.service.impl;

import cn.edu.hebut.ego.entity.Goods;
import cn.edu.hebut.ego.entity.vo.SearchVo;
import cn.edu.hebut.ego.mapper.GoodsMapper;
import cn.edu.hebut.ego.service.IGoodsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 售卖物品表 服务实现类
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-30
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
    @Resource
    GoodsMapper goodsMapper;

    @Override
    public SearchVo search(String key) {
        SearchVo searchVo = new SearchVo();
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<Goods>();
        queryWrapper.like("good_name",key);
        List<Goods> goodsList = goodsMapper.selectList(queryWrapper);
        searchVo.addAll(goodsList);
        return searchVo;
    }
}
