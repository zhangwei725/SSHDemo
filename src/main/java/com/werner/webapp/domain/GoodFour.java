package com.werner.webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TB_GOOD_FOUR")
public class GoodFour implements Serializable {
    /**
     * relation_id : 775
     * relation_type : 0
     * relation_channel_id : 9
     * relation_object_type : 4
     * relation_object_id : 477
     * relation_object_title : 土产市集
     * relation_object_jingle :
     * relation_object_image : http://res.yueshichina.com/upload/shop/store/goods/181/181_05255263647066832_360.jpg
     * relation_state : 1
     * relation_sort : 255
     * relation_start_time : 0
     * relation_end_time : 0
     * relation_index_font : 土产市集
     * relation_index_img : http://yueshi.b0.upaiyun.com/banner/1.png
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

    public String getRelation_index_img() {
        return relation_index_img;
    }

    public void setRelation_index_img(String relation_index_img) {
        this.relation_index_img = relation_index_img;
    }
}