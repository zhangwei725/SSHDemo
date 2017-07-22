package com.werner.webapp.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Service;
import sun.security.util.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_BANNER")
public class Banner implements Serializable {

    @Id
    @Column(length = 32)
    @GeneratedValue(generator = "h_uuid")
    @GenericGenerator(name = "h_uuid",strategy = "uuid")
    private String advert_id;
    @JSONField(name = "advertTitle")
    private String advert_title;
    @JSONField(name = "advertImg")
    private String advert_img;
    @JSONField(name = "advertText")
    private String advert_text;
    @JSONField(name = "advertUrl")
    private String advert_url;
    @JSONField(name = "advertVideoUrl")
    private String advert_video_url;
    @JSONField(name = "videoShareUrl")
    private String video_share_url;
    @Transient
    private int isMark;

    public Banner() {
    }

    public Banner(String advert_title, String advert_img, String advert_text, String advert_url, String advert_video_url, String video_share_url) {
        this.advert_title = advert_title;
        this.advert_img = advert_img;
        this.advert_text = advert_text;
        this.advert_url = advert_url;
        this.advert_video_url = advert_video_url;
        this.video_share_url = video_share_url;
    }

    public String getAdvert_id() {
        return advert_id;
    }

    public void setAdvert_id(String advert_id) {
        this.advert_id = advert_id;
    }

    public String getAdvert_title() {
        return advert_title;
    }

    public void setAdvert_title(String advert_title) {
        this.advert_title = advert_title;
    }

    public String getAdvert_img() {
        return advert_img;
    }

    public void setAdvert_img(String advert_img) {
        this.advert_img = advert_img;
    }

    public String getAdvert_text() {
        return advert_text;
    }

    public void setAdvert_text(String advert_text) {
        this.advert_text = advert_text;
    }

    public String getAdvert_url() {
        return advert_url;
    }

    public void setAdvert_url(String advert_url) {
        this.advert_url = advert_url;
    }

    public String getAdvert_video_url() {
        return advert_video_url;
    }

    public void setAdvert_video_url(String advert_video_url) {
        this.advert_video_url = advert_video_url;
    }

    public String getVideo_share_url() {
        return video_share_url;
    }

    public void setVideo_share_url(String video_share_url) {
        this.video_share_url = video_share_url;
    }

    public int getIsMark() {
        return isMark;
    }

    public void setIsMark(int isMark) {
        this.isMark = isMark;
    }
}