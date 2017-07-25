package com.werner.webapp.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_RELATION")
public class Relation implements Serializable {
    /**
     * relation_id : 1040
     * relation_type : 0
     * relation_channel_id : 7
     * relation_object_type : 4
     * relation_object_id : 590
     * relation_object_title : 美酒养成记
     * relation_object_jingle : 杯酒人生
     * relation_object_image : http://yueshi.b0.upaiyun.com/cms/2017/06/30/8a1c1f2ff145071a
     * relation_state : 1
     * relation_sort : 1
     * relation_start_time : 1498752000
     * relation_end_time : 1506700800
     * relation_index_font :
     * relation_index_img : null
     * goods_special_list : [{"goods_name":"西瓜铺|丸京菓子庵夹心铜锣烧（红豆/抹茶红豆）美味早餐小零食 日期至2017.10.18 抹茶红豆味","goods_id":"1402","goods_price":"32.80","goods_img":"http://yueshi.b0.upaiyun.com/goods/171/2016/12/30/ae92681932758f074d9af215c3f2016c_616.jpg"},{"goods_name":"明治|日本进口 巧克力夹心威化饼 日期至2017.10.1","goods_id":"1566","goods_price":"15.90","goods_img":"http://yueshi.b0.upaiyun.com/goods/171/2017/06/02/0795bed92336e1443c9f181efadbecd5_493.jpg"},{"goods_name":"森永|日本进口牛奶白巧克力Madagascar White 日期至2017.10.1","goods_id":"1565","goods_price":"24.90","goods_img":"http://yueshi.b0.upaiyun.com/goods/171/2017/06/02/7a767a6d940793302970f1426c2a9800_170.jpg"},{"goods_name":"雀巢|日本进口 kitkat白巧克力威化（烤芝士味）日期至2017.9.1","goods_id":"1564","goods_price":"24.90","goods_img":"http://yueshi.b0.upaiyun.com/goods/171/2017/06/02/5785e092eb17df9e6aeddddf856463db_404.jpg"},{"goods_name":"明治|男の極旨浓厚中辛黑咖喱 日本进口 日期至2018.8.29","goods_id":"1147","goods_price":"32.80","goods_img":"http://yueshi.b0.upaiyun.com/goods/171/2016/10/28/60ee1a390fd95d01cfb4b1bc178d5c3a_566.jpg"},{"goods_name":"Hachi咖喱专门店|印度风 爪哇风味咖喱组合(蓝+黄)  两袋共400g 日期至2018.9","goods_id":"1146","goods_price":"38.60","goods_img":"http://yueshi.b0.upaiyun.com/goods/171/2016/10/28/4f97c63bf66f40832fda1abdce95a30f_166.jpg"},{"goods_name":"罗格 | 蜂蜜库尔施啤酒 4瓶装*355ml 美国进口精酿 日期至2017-10-24","goods_id":"1610","goods_price":"88.00","goods_img":"http://yueshi.b0.upaiyun.com/goods/12/2017/02/23/89a84b41a2b13ef9a86c07c3c95c0b5e_932.jpg"},{"goods_name":"罗格 | 蜂蜜库尔施啤酒 355ml*6瓶装 日期至2017-10-24","goods_id":"1609","goods_price":"109.00","goods_img":"http://yueshi.b0.upaiyun.com/goods/12/2017/06/29/9f68df98af1e80814daf930cabe81c38_812.jpg"}]
     * tag_print :
     * video_length : 19'45''
     * article_video : http://video.yueshichina.com/video/2016/0812/huang jue.mp4
     * advert_url : null
     */
    @Id
    @Column(length = 32)
    private String relation_id;
    private String relation_type;
    private String relation_channel_id;
    private String relation_object_type;
    private String relation_object_id;
    private String relation_object_title;
    private String relation_object_jingle;
    private String relation_object_image;
    private String relation_state;
    private String relation_sort;
    private String relation_start_time;
    private String relation_end_time;
    private String relation_index_font;
    private String relation_index_img;
    private String tag_print;
    private String video_length;
    private String article_video;
    private String advert_url;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="relation_id")
    private List<Special> goods_special_list;

    public String getRelation_id() {
        return relation_id;
    }

    public void setRelation_id(String relation_id) {
        this.relation_id = relation_id;
    }

    public String getRelation_type() {
        return relation_type;
    }

    public void setRelation_type(String relation_type) {
        this.relation_type = relation_type;
    }

    public String getRelation_channel_id() {
        return relation_channel_id;
    }

    public void setRelation_channel_id(String relation_channel_id) {
        this.relation_channel_id = relation_channel_id;
    }

    public String getRelation_object_type() {
        return relation_object_type;
    }

    public void setRelation_object_type(String relation_object_type) {
        this.relation_object_type = relation_object_type;
    }

    public String getRelation_object_id() {
        return relation_object_id;
    }

    public void setRelation_object_id(String relation_object_id) {
        this.relation_object_id = relation_object_id;
    }

    public String getRelation_object_title() {
        return relation_object_title;
    }

    public void setRelation_object_title(String relation_object_title) {
        this.relation_object_title = relation_object_title;
    }

    public String getRelation_object_jingle() {
        return relation_object_jingle;
    }

    public void setRelation_object_jingle(String relation_object_jingle) {
        this.relation_object_jingle = relation_object_jingle;
    }

    public String getRelation_object_image() {
        return relation_object_image;
    }

    public void setRelation_object_image(String relation_object_image) {
        this.relation_object_image = relation_object_image;
    }

    public String getRelation_state() {
        return relation_state;
    }

    public void setRelation_state(String relation_state) {
        this.relation_state = relation_state;
    }

    public String getRelation_sort() {
        return relation_sort;
    }

    public void setRelation_sort(String relation_sort) {
        this.relation_sort = relation_sort;
    }

    public String getRelation_start_time() {
        return relation_start_time;
    }

    public void setRelation_start_time(String relation_start_time) {
        this.relation_start_time = relation_start_time;
    }

    public String getRelation_end_time() {
        return relation_end_time;
    }

    public void setRelation_end_time(String relation_end_time) {
        this.relation_end_time = relation_end_time;
    }

    public String getRelation_index_font() {
        return relation_index_font;
    }

    public void setRelation_index_font(String relation_index_font) {
        this.relation_index_font = relation_index_font;
    }

    public Object getRelation_index_img() {
        return relation_index_img;
    }

    public void setRelation_index_img(String relation_index_img) {
        this.relation_index_img = relation_index_img;
    }

    public String getTag_print() {
        return tag_print;
    }

    public void setTag_print(String tag_print) {
        this.tag_print = tag_print;
    }

    public String getVideo_length() {
        return video_length;
    }

    public void setVideo_length(String video_length) {
        this.video_length = video_length;
    }

    public String getArticle_video() {
        return article_video;
    }

    public void setArticle_video(String article_video) {
        this.article_video = article_video;
    }

    public Object getAdvert_url() {
        return advert_url;
    }

    public void setAdvert_url(String advert_url) {
        this.advert_url = advert_url;
    }

    public List<Special> getGoods_special_list() {
        return goods_special_list;
    }

    public void setGoods_special_list(List<Special> goods_special_list) {
        this.goods_special_list = goods_special_list;
    }


}