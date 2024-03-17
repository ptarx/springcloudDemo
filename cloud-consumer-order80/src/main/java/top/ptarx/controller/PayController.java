package top.ptarx.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.ptarx.entities.PayDTO;
import top.ptarx.resp.ResultData;

@RestController
@RequestMapping("/pay")
@Slf4j
@Tag(name="支付微服务模块",description = "支付CRUD")
public class PayController {

    private String HOST_URL="http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value="add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData addPay(@RequestBody PayDTO pay){
        return restTemplate.postForObject(HOST_URL+"/pay/add",pay,ResultData.class);
    }

    @PostMapping(value="del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData deletePay(@PathVariable("id") Integer id){
        return restTemplate.postForObject(HOST_URL+"/pay/del/"+id,null,ResultData.class);
    }

    @GetMapping(value="getById/{id}")
    @Operation(summary = "详情",description = "支付流水详情方法")
    public ResultData getById(@PathVariable("id") Integer id){
        return restTemplate.getForObject(HOST_URL+"/pay/getById/"+id,ResultData.class);
    }

    @PutMapping(value="update")
    @Operation(summary = "更新",description = "更新支付流水方法")
    public ResultData update(@RequestBody PayDTO pay){
        return restTemplate.postForObject(HOST_URL+"/pay/update",pay,ResultData.class);
    }

    @GetMapping(value="selectAll")
    @Operation(summary = "列表",description = "支付流水列表")
    public ResultData selectAll(){
        return restTemplate.getForObject(HOST_URL+"/pay/selectAll",ResultData.class);
    }


}
