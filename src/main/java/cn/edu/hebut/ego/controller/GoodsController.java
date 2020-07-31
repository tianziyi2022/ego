package cn.edu.hebut.ego.controller;


import cn.edu.hebut.ego.common.ApiResponse;
import cn.edu.hebut.ego.common.CommonConstant;
import cn.edu.hebut.ego.common.ErrorCodeEnum;
import cn.edu.hebut.ego.common.exception.BizException;
import cn.edu.hebut.ego.entity.request.LoginRequest;
import cn.edu.hebut.ego.entity.vo.LoginVo;
import cn.edu.hebut.ego.entity.vo.RandomGoodVo;
import cn.edu.hebut.ego.entity.vo.SearchVo;
import cn.edu.hebut.ego.service.IGoodsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * <p>
 * 售卖物品表 前端控制器
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-30
 */
@RestController
@RequestMapping("/ego/goods")
public class GoodsController {

    @Autowired
    IGoodsService iGoodsService;

    @ApiOperation(value = "关键字搜索", tags = CommonConstant.SEARCH)
    @PostMapping("/search")
    public ApiResponse<SearchVo> search(
            @ApiParam(value = "关键字搜索") @RequestParam(name = "key") String key
    ) {
        SearchVo searchVo = new SearchVo();
        try {
            searchVo = iGoodsService.search(key);
        } catch (BizException e) {
            e.printStackTrace();
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(searchVo);
    }

    @ApiOperation(value = "综合搜索", tags = CommonConstant.SEARCH_PLUS)
    @PostMapping("/searchPlus")
    public ApiResponse<SearchVo> searchPlus(
            @ApiParam(value = "关键字搜索") @RequestParam(name = "key") String key
    ) {
        SearchVo searchVo = new SearchVo();
        try {
            searchVo = iGoodsService.searchPlus(key);
        } catch (BizException e) {
            e.printStackTrace();
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(searchVo);
    }

    @ApiOperation(value = "随机搜索", tags = CommonConstant.RANDOM_SEARCH)
    @PostMapping("/getRandomGoods")
    public ApiResponse<RandomGoodVo> getRandomGoods(
            @ApiParam(value = "随机搜索") @RequestParam(name = "count") Integer count
    ) {
        RandomGoodVo randomGoodVo = new RandomGoodVo();
        try {
            randomGoodVo = iGoodsService.getRandomGoods(count);
        } catch (BizException e) {
            e.printStackTrace();
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(randomGoodVo);
    }

}
