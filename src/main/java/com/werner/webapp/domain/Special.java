package com.werner.webapp.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "TB_SPECIAL")
public class Special implements Serializable {
    /**
     * goods_name : 西瓜铺|丸京菓子庵夹心铜锣烧（红豆/抹茶红豆）美味早餐小零食 日期至2017.10.18 抹茶红豆味
     * goods_id : 1402
     * goods_price : 32.80
     * goods_img : http://yueshi.b0.upaiyun.com/goods/171/2016/12/30/ae92681932758f074d9af215c3f2016c_616.jpg
     */
    private String goods_name;
    @Id
    @Column(length = 32)
    private String goods_id;
    private String goods_price;
    private String goods_img;

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }
}