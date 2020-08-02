package cn.edu.hebut.ego.controller;


import cn.edu.hebut.ego.common.ApiResponse;
import cn.edu.hebut.ego.common.CommonConstant;
import cn.edu.hebut.ego.common.ErrorCodeEnum;
import cn.edu.hebut.ego.common.exception.BizException;
import cn.edu.hebut.ego.entity.request.LoginRequest;
import cn.edu.hebut.ego.entity.request.RandomGoodsRequest;
import cn.edu.hebut.ego.entity.request.SearchRequest;
import cn.edu.hebut.ego.entity.vo.LoginVo;
import cn.edu.hebut.ego.entity.vo.RandomGoodVo;
import cn.edu.hebut.ego.entity.vo.SearchVo;
import cn.edu.hebut.ego.service.IGoodsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin
    @ApiOperation(value = "关键字搜索", tags = CommonConstant.SEARCH)
    @PostMapping("/search")
    public ApiResponse<SearchVo> search(
//            @ApiParam(value = "关键字搜索") @RequestParam(name = "key") String key
            @RequestBody SearchRequest searchRequest
            ) {
        SearchVo searchVo = new SearchVo();
        try {
            searchVo = iGoodsService.search(searchRequest.getKey());
        } catch (BizException e) {
            e.printStackTrace();
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(searchVo);
    }

    @CrossOrigin
    @ApiOperation(value = "综合搜索", tags = CommonConstant.SEARCH_PLUS)
    @PostMapping("/searchPlus")
    public ApiResponse<SearchVo> searchPlus(
//            @ApiParam(value = "关键字搜索") @RequestParam(name = "key") String key
            @RequestBody SearchRequest searchRequest
    ) {
        SearchVo searchVo = new SearchVo();
        try {
            searchVo = iGoodsService.searchPlus(searchRequest.getKey());
        } catch (BizException e) {
            e.printStackTrace();
            return ApiResponse.error(e.getErrMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.error(ErrorCodeEnum.SYSTEM_DEFAULT_ERROR);
        }
        return ApiResponse.success(searchVo);
    }

    @CrossOrigin
    @ApiOperation(value = "随机搜索", tags = CommonConstant.RANDOM_SEARCH)
    @PostMapping("/getRandomGoods")
    public ApiResponse<RandomGoodVo> getRandomGoods(
//            @ApiParam(value = "随机搜索") @RequestParam(name = "count") Integer count
            @RequestBody RandomGoodsRequest randomGoodsRequest
            ) {
        RandomGoodVo randomGoodVo = new RandomGoodVo();
        try {
            randomGoodVo = iGoodsService.getRandomGoods(randomGoodsRequest.getCount());
//            randomGoodVo = iGoodsService.getRandomGoods(count);
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
