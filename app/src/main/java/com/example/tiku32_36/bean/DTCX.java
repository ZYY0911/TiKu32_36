package com.example.tiku32_36.bean;

import java.util.List;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/10 at 20:56 ：）
 */
public class DTCX {


    /**
     * id : 1
     * name : 北京地铁1号线（M1）线路图
     * site : ["天安门站","苹果园","将军陵","故园"]
     */

    private String id;
    private String name;
    private List<String> site;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSite() {
        return site;
    }

    public void setSite(List<String> site) {
        this.site = site;
    }
}
