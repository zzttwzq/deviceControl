package com.qlzw.smartwc.service;

import com.qlzw.smartwc.utils.RESPONSE_STATUS;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ResponseService {

    public HashMap<String,Object> getReturnResponse(RESPONSE_STATUS status, String msg, Object data) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", this.getCode(status));
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }

    public HashMap<String,Object> getReturnResponse(RESPONSE_STATUS status, String msg) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", this.getCode(status));
        map.put("msg", msg);
        map.put("data", null);
        return map;
    }

    public HashMap<String,Object> getReturnResponse(RESPONSE_STATUS status, Object data) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", this.getCode(status));
        map.put("msg", this.getMsg(status));
        map.put("data", data);
        return map;
    }

    public HashMap<String,Object> getReturnResponse(RESPONSE_STATUS status) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", this.getCode(status));
        map.put("msg", this.getMsg(status));
        map.put("data", null);
        return map;
    }

    public Integer getCode(RESPONSE_STATUS status) {

        if (status == RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS) {

            return 200;
        }
        else if (status == RESPONSE_STATUS.RESPONSE_STATUS_ERROR) {

            return 500;
        }

        return 0;
    }

    public String getMsg(RESPONSE_STATUS status) {

        if (status == RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS) {

            return "成功！";
        }
        else if (status == RESPONSE_STATUS.RESPONSE_STATUS_ERROR) {

            return "失败！";
        }

        return "";
    }
}
