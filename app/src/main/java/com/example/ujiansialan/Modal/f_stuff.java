package com.example.ujiansialan.Modal;

public class f_stuff {
    String img_st, tl_st, prc_st, bearer_id;

    public f_stuff(String img_st, String tl_st, String prc_st, String bearer_id) {
        this.img_st = img_st;
        this.tl_st = tl_st;
        this.prc_st = prc_st;
        this.bearer_id = bearer_id;
    }

    public String getImg_st() {
        return img_st;
    }

    public void setImg_st(String img_st) {
        this.img_st = img_st;
    }

    public String getTl_st() {
        return tl_st;
    }

    public void setTl_st(String tl_st) {
        this.tl_st = tl_st;
    }

    public String getPrc_st() {
        return prc_st;
    }

    public void setPrc_st(String prc_st) {
        this.prc_st = prc_st;
    }

    public String getBearer_id() {
        return bearer_id;
    }

    public void setBearer_id(String bearer_id) {
        this.bearer_id = bearer_id;
    }
}
