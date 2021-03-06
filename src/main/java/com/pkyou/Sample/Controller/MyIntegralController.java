package com.pkyou.Sample.Controller;

import com.pkyou.Sample.ServiceImp.MyIntegralService;
import com.pkyou.Sample.enums.ResponseCodeEnum;
import com.pkyou.Sample.request.ExchangeIntegralRequest;
import com.pkyou.Sample.request.GetIntegralExchangeRecordRequest;
import com.pkyou.Sample.request.GetMyIntegralRequest;
import com.pkyou.Sample.response.CommonResponse;
import com.pkyou.Sample.response.ExchangeIntegralResponse;
import com.pkyou.Sample.response.GetIntegralExchangeRecordResponse;
import com.pkyou.Sample.response.GetMyIntegralResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/myIntegral")
@Api("积分api")
public class MyIntegralController {

    @Resource
    private MyIntegralService service;

    @ApiOperation("获取我的积分")
    @RequestMapping(value="/getMyIntegral",method= RequestMethod.GET)
    public CommonResponse<GetMyIntegralResponse> getMyIntegral(@ModelAttribute GetMyIntegralRequest request) {

        CommonResponse<GetMyIntegralResponse> response = new CommonResponse<GetMyIntegralResponse>();

        try {
            GetMyIntegralResponse result = service.getMyIntegral(request);
            response.setResult(result);
            response.setCode(ResponseCodeEnum.SUCCEED.getCode());
        }
        catch (Exception e){
            response.setCode(ResponseCodeEnum.FAILED.getCode());
            response.setMessage(e.getMessage());
        }

        return response;
    }

    /**
     * 获取积分交易记录
     * @param request
     * @return
     */
    public CommonResponse<List<GetIntegralExchangeRecordResponse>>  GetIntegralExchangeRecord
            (@ModelAttribute GetIntegralExchangeRecordRequest request){
        CommonResponse<List<GetIntegralExchangeRecordResponse>> response = new CommonResponse<List<GetIntegralExchangeRecordResponse>>();
        try {
            List<GetIntegralExchangeRecordResponse> result = new ArrayList<GetIntegralExchangeRecordResponse>();
            response.setCode(ResponseCodeEnum.SUCCEED.getCode());
            response.setResult(result);
        }catch (Exception e){
            response.setCode(ResponseCodeEnum.FAILED.getCode());
            response.setMessage(e.getMessage());
        }
        return response;
    }


    /**
     *
     * 兑换积分
     * @return
     * {
     *   "commodities": [
     *     {
     *       "commodityId": 0,
     *       "count": 0,
     *       "value": 0
     *     }
     *   ],
     *   "userId": 0
     * }
     */
    @ApiOperation("兑换积分")
    @RequestMapping(value="/exchangeIntegral",method= RequestMethod.POST)
    public CommonResponse<ExchangeIntegralResponse> exchangeIntegral(@RequestBody ExchangeIntegralRequest request){
        CommonResponse<ExchangeIntegralResponse> response = new CommonResponse<ExchangeIntegralResponse>();

        try {
            ExchangeIntegralResponse result = new ExchangeIntegralResponse();

            response.setCode(ResponseCodeEnum.SUCCEED.getCode());
            response.setResult(result);
        }catch (Exception e){
            response.setCode(ResponseCodeEnum.FAILED.getCode());
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
