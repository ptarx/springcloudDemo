package top.ptarx.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import top.ptarx.entities.Pay;
import top.ptarx.entities.PayDTO;
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
    public Integer addPay(@RequestBody Pay pay){
        return payService.add(pay);
    }

    @PostMapping(value="del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public Integer deletePay(@PathVariable("id") Integer id){
        return payService.delete(id);
    }

    @GetMapping(value="getById/{id}")
    @Operation(summary = "详情",description = "支付流水详情方法")
    public Pay getById(@PathVariable("id") Integer id){
        return payService.getById(id);
    }

    @PutMapping(value="update")
    @Operation(summary = "更新",description = "更新支付流水方法")
    public Integer update(@RequestBody PayDTO pay){
        Pay payReal = new Pay();
        BeanUtils.copyProperties(pay,payReal);
        return payService.update(payReal);
    }

    @GetMapping(value="selectAll")
    @Operation(summary = "列表",description = "支付流水列表")
    public List<Pay> selectAll(){
        return payService.getAll();
    }
}
