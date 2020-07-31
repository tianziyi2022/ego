package cn.edu.hebut.ego.service;

import cn.edu.hebut.ego.entity.Goods;
import cn.edu.hebut.ego.entity.vo.SearchVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 售卖物品表 服务类
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-30
 */
public interface IGoodsService extends IService<Goods> {
    public SearchVo search(String key);
}
