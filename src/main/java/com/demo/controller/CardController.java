package com.demo.controller;

import com.demo.domains.Card;
import com.demo.service.CardService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fxy
 * @version 1.0
 * @date 2021/9/12 14:48
 * @description TODO
 */
@RestController
@RequestMapping("api/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("getCardMsg")
    public JSONObject getCardMsg(@RequestBody Card pojo) {
        JSONObject jsonObject = new JSONObject();
        List<Card> select = cardService.select(pojo);
        if (select.size() > 0) {
            jsonObject.put("errorMsg", "");
            jsonObject.put("success", true);
            jsonObject.put("data", select.get(0));
            return jsonObject;
        }

        //错误信息
        jsonObject.put("errorMsg", "查询失败");
        //是否成功
        jsonObject.put("success", false);
        //返回的数据
        jsonObject.put("data", "");
        return jsonObject;
    }
    @PutMapping("addCard")
    public JSONObject addCard(@RequestBody Card card) {
        JSONObject jsonObject = new JSONObject();
        int insert = cardService.insert(card);
        if (insert > 0) {
            jsonObject.put("errorMsg", "");
            jsonObject.put("success", true);
            jsonObject.put("data", "");
            return jsonObject;
        }

        //错误信息
        jsonObject.put("errorMsg", "新增失败");
        //是否成功
        jsonObject.put("success", false);
        //返回的数据
        jsonObject.put("data", "");
        return jsonObject;
    }


    /**
     * TODO 对于卡片的删除操作应该在硬件设备进行匹配，如果有删除接口此处可以提供
     * @param card
     * @return
     */
    @PostMapping("delCard")
    public JSONObject delCard(@RequestBody Card card) {
        JSONObject jsonObject = new JSONObject();
        int update = cardService.update(card);
        if (update > 0) {
            jsonObject.put("errorMsg", "");
            jsonObject.put("success", true);
            jsonObject.put("data", "");
            return jsonObject;
        }

        //错误信息
        jsonObject.put("errorMsg", "删除失败");
        //是否成功
        jsonObject.put("success", false);
        //返回的数据
        jsonObject.put("data", "");
        return jsonObject;
    }


}
