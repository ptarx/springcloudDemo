package top.ptarx.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import top.ptarx.entities.Pay;
import top.ptarx.entities.PayDTO;
import top.ptarx.resp.ResultData;
import top.ptarx.service.PayService;

import java.util.List;

@RestController
@RequestMapping("/pay")
@Slf4j
@Tag(name="支付微服务模块",description = "支付CRUD")
public class PayController {
    @Resource
    private PayService payService;

    @PostMapping(value="add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData addPay(@RequestBody Pay pay){
        int add = payService.add(pay);
        return ResultData.success(add);
    }

    @PostMapping(value="del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData deletePay(@PathVariable("id") Integer id){
        int delete = payService.delete(id);
        return ResultData.success(delete);
    }

    @GetMapping(value="getById/{id}")
    @Operation(summary = "详情",description = "支付流水详情方法")
    public ResultData getById(@PathVariable("id") Integer id){
        Pay pay= payService.getById(id);
        return ResultData.success(pay);
    }

    @PutMapping(value="update")
    @Operation(summary = "更新",description = "更新支付流水方法")
    public ResultData update(@RequestBody PayDTO pay){
        Pay payReal = new Pay();
        BeanUtils.copyProperties(pay,payReal);
        payService.update(payReal);
        return ResultData.success("更新成功");
    }

    @GetMapping(value="selectAll")
    @Operation(summary = "列表",description = "支付流水列表")
    public ResultData selectAll(){
        List<Pay> all = payService.getAll();
        return ResultData.success(all);
    }
}
