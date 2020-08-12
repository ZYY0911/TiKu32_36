package com.example.tiku32_36.bean;

import java.util.List;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/12 at 14:52 ：）
 */
public class GSLK {

    /**
     * roadid : G06
     * road : 滨海高速
     * type : 较少
     * site : ["大钟寺","西直门","大钟寺"]
     */

    private String roadid;
    private String road;
    private String type;
    private List<String> site;

    public String getRoadid() {
        return roadid;
    }

    public void setRoadid(String roadid) {
        this.roadid = roadid;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getSite() {
        return site;
    }

    public void setSite(List<String> site) {
        this.site = site;
    }
}
