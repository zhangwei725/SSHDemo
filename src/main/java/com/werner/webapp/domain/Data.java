package com.werner.webapp.domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public class Data implements Serializable {
    private List<Relation> data_type;
    private List<Banner> banner;
    private List<GoodFour> relation_good_four;

    public List<Relation> getData_type() {
        return data_type;
    }

    public void setData_type(List<Relation> data_type) {
        this.data_type = data_type;
    }

    public List<Banner> getBanner() {
        return banner;
    }

    public void setBanner(List<Banner> banner) {
        this.banner = banner;
    }

    public List<GoodFour> getRelation_good_four() {
        return relation_good_four;
    }

    public void setRelation_good_four(List<GoodFour> relation_good_four) {
        this.relation_good_four = relation_good_four;
    }

}