package cn.edu.hebut.ego.service.impl;

import cn.edu.hebut.ego.common.annotation.AccessToken;
import cn.edu.hebut.ego.common.exception.BizException;
import cn.edu.hebut.ego.entity.Goods;
import cn.edu.hebut.ego.entity.vo.RandomGoodVo;
import cn.edu.hebut.ego.entity.vo.SearchVo;
import cn.edu.hebut.ego.mapper.GoodsMapper;
import cn.edu.hebut.ego.service.IGoodsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

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
        searchVo.setCount(goodsList.size());
        goodsList.removeIf(good -> (good.getStatus()!=10) && (good.getStatus()!=12));
        searchVo.setGoodsList(goodsList);
        return searchVo;
    }

    @Override
    public SearchVo searchPlus(String key) {
        SearchVo searchVo = new SearchVo();
        QueryWrapper<Goods> queryWrapper1 = new QueryWrapper<Goods>();
        queryWrapper1.like("good_name",key);
        List<Goods> goodsList1 = goodsMapper.selectList(queryWrapper1);
        QueryWrapper<Goods> queryWrapper2 = new QueryWrapper<Goods>();
        queryWrapper2.like("description",key);
        List<Goods> goodsList2 = goodsMapper.selectList(queryWrapper2);
        QueryWrapper<Goods> queryWrapper3 = new QueryWrapper<Goods>();
        queryWrapper3.like("note",key);
        List<Goods> goodsList3 = goodsMapper.selectList(queryWrapper3);
        goodsList1.removeIf(goodsList2::contains);
        goodsList1.addAll(goodsList2);
        goodsList3.removeIf(goodsList1::contains);
        goodsList1.addAll(goodsList3);
        goodsList1.removeIf(good -> (good.getStatus()!=10) && (good.getStatus()!=12));
        searchVo.setCount(goodsList1.size());
        searchVo.setGoodsList(goodsList1);
        return searchVo;
    }

    @Override
    public RandomGoodVo getRandomGoods(Integer count) {
        if(count<=0) {
            throw new BizException("获取数量有误");
        }
        RandomGoodVo randomGoodVo = new RandomGoodVo();
        int account = goodsMapper.count();
        int accountAll = goodsMapper.countAll();
        List<Integer> randomIdList = new ArrayList<Integer>();
        Random random = new Random();
        int goodi = 1;
        if(count >= account){
            for(int i = 0; i < count; i++) {
                Goods good = goodsMapper.selectById(goodi);
                if(goodi==accountAll+1){
                    goodi=1;
                }else if (Objects.isNull(good)||good.getStatus()!=10&&good.getStatus()!=12) {
                    i--;
                    goodi++;
                }else{
                    randomGoodVo.add(good);
                    goodi++;
                }

            }
        } else {
            for (int i = 0; i < count; i++) {
                int randomId = random.nextInt(account)+1;
                Goods good = goodsMapper.selectById(randomId);
                if (randomIdList.contains(randomId)|| Objects.isNull(good)||(good.getStatus()!=10&&good.getStatus()!=12)) {
                    i--;
                } else {
                    randomIdList.add(randomId);
                    randomGoodVo.add(goodsMapper.selectById(randomId));
                }
            }
        }
        return randomGoodVo;
    }


}
