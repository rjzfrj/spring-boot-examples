package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path = "rest")
public class DemoRest {

    @Autowired
    private KVBean kvBean;

    @GetMapping(path = "show")
    public String showKv(String key) {
        Map<String, String> result = new HashMap<>(16);

        // kv test
        String kvKey = "kvKey";
        String kvVal = UUID.randomUUID().toString();
        kvBean.setValue(kvKey, kvVal);
        String kvRes = new String(kvBean.getValue(kvKey));
        result.put("kv get set", kvRes + "==>" + kvVal.equals(kvRes));


        // kv getSet

        // 如果原始数据存在时
        String kvOldRes = new String(kvBean.setAndGetOldValue(kvKey, kvVal + "==>new"));
        result.put("kv setAndGet", kvOldRes + " # " + new String(kvBean.getValue(kvKey)));

        // 如果原始数据不存在时
        byte[] kvOldResNull = kvBean.setAndGetOldValue("not exists", "...");
        result.put("kv setAndGet not exists", kvOldResNull == null ? "null" : new String(kvOldResNull));


        // 自增
        String cntKey = "kvIncrKey";
        long val = 10L;
        long incrRet = kvBean.incr(cntKey, val);
        String incrRes = new String(kvBean.getValue(cntKey));
        result.put("kv incr", incrRet + "#" + incrRes);


        // bitmap 测试
        String bitMapKey = "bitmapKey";
        kvBean.setBit(bitMapKey, 100, true);
        boolean bitRes = kvBean.getBit(bitMapKey, 100);
        boolean bitRes2 = kvBean.getBit(bitMapKey, 101);
        result.put("bitMap", bitRes + ">> true | " + bitRes2 + ">> false");
        return JSONObject.toJSONString(result);
    }
}
