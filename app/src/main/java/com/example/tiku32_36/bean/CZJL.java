package com.example.tiku32_36.bean;

import org.litepal.crud.LitePalSupport;

/**
 * @LogIn Name win10
 * @Create by 张瀛煜 on 2020/8/12 at 8:49 ：）
 */
public class CZJL extends LitePalSupport {
    private int id;
    private String carId,Cp,Sj;
    private int Je;

    public CZJL() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCp() {
        return Cp;
    }

    public void setCp(String cp) {
        Cp = cp;
    }

    public String getSj() {
        return Sj;
    }

    public void setSj(String sj) {
        Sj = sj;
    }

    public int getJe() {
        return Je;
    }

    public void setJe(int je) {
        Je = je;
    }

    public CZJL(String carId, String cp, String sj, int je) {
        this.carId = carId;
        Cp = cp;
        Sj = sj;
        Je = je;
    }
}
