package xin.qrainly.paymentupdate.payment;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * 付款改造  测试数据
 * @author v_liuwen
 */
@Controller
@RequestMapping(value = "/pay/internal")
public class MockController {


    /**
     * 1
     * @return
     * @throws Exception
     */
    @RequestMapping("/my_pay/list")
    @ResponseBody
    public JsonResult test1() throws Exception {
        JSONObject jsonObject = getRoleJson("list.json");
        JSONObject data = jsonObject.getJSONObject("data");
        return JsonResult.okJsonResultWithData(data);
    }
    /**
     * 2
     * @return
     * @throws Exception
     */
    @RequestMapping("/edit_pay/load_basic")
    @ResponseBody
    public JsonResult test2() throws Exception {
        JSONObject jsonObject = getRoleJson("basic.json");
        JSONObject data = jsonObject.getJSONObject("data");
        return JsonResult.okJsonResultWithData(data);
    }
    /**
     * 3
     * @return
     * @throws Exception
     */
    @RequestMapping("/load_contract_info")
    @ResponseBody
    public JsonResult test3() throws Exception {
        JSONObject jsonObject = getRoleJson("contract.json");
        JSONObject data = jsonObject.getJSONObject("data");
        return JsonResult.okJsonResultWithData(data);
    }
    /**
     * 4
     * @return
     * @throws Exception
     */
    @RequestMapping("/edit_pay/load_account")
    @ResponseBody
    public JsonResult test4() throws Exception {
        JSONObject jsonObject = getRoleJson("account.json");
        JSONObject data = jsonObject.getJSONObject("data");
        return JsonResult.okJsonResultWithData(data);
    }
    /**
     * 5
     * @return
     * @throws Exception
     */
    @RequestMapping("/load_payterm_info")
    @ResponseBody
    public JsonResult test5() throws Exception {
        JSONObject jsonObject = getRoleJson("payterm.json");
        JSONArray data = jsonObject.getJSONArray("data");
        return JsonResult.okJsonResultWithData(data);
    }
    /**
     * 6
     * @return
     * @throws Exception
     */
    @RequestMapping("/edit_pay/load_costcenter")
    @ResponseBody
    public JsonResult test6() throws Exception {
        JSONObject jsonObject = getRoleJson("costcenter.json");
        JSONArray data = jsonObject.getJSONArray("data");
        return JsonResult.okJsonResultWithData(data);
    }
    /**
     * 7
     * @return
     * @throws Exception
     */
    @RequestMapping("/edit_pay/load_receipts")
    @ResponseBody
    public JsonResult test7() throws Exception {
        JSONObject jsonObject = getRoleJson("receipt.json");
        JSONObject data = jsonObject.getJSONObject("data");
        return JsonResult.okJsonResultWithData(data);
    }
    /**
     * 8
     * @return
     * @throws Exception
     */
    @RequestMapping("/edit_pay/load_invoices")
    @ResponseBody
    public JsonResult test8() throws Exception {
        JSONObject jsonObject = getRoleJson("invoice.json");
        JSONObject data = jsonObject.getJSONObject("data");
        return JsonResult.okJsonResultWithData(data);
    }
    /**
     * 9
     * @return
     * @throws Exception
     */
    @RequestMapping("/edit_pay/load_prepays")
    @ResponseBody
    public JsonResult test9() throws Exception {
        JSONObject jsonObject = getRoleJson("prepay.json");
        JSONArray data = jsonObject.getJSONArray("data");
        return JsonResult.okJsonResultWithData(data);
    }
    /**
     * 10
     * @return
     * @throws Exception
     */
    @RequestMapping("/load_receive_info")
    @ResponseBody
    public JsonResult test10() throws Exception {
        JSONObject jsonObject = getRoleJson("receive.json");
        JSONObject data = jsonObject.getJSONObject("data");
        return JsonResult.okJsonResultWithData(data);
    }


    /**
     * 读取文件
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    private JSONObject getRoleJson(String fileName) throws FileNotFoundException {
        File jsonFile = ResourceUtils.getFile("classpath:data/"+fileName);
        JSONObject jsonObject = null;
        String input;
        try {
            input = FileUtils.readFileToString(jsonFile, "UTF-8");
            jsonObject = JSONObject.parseObject(input);
            return jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}


