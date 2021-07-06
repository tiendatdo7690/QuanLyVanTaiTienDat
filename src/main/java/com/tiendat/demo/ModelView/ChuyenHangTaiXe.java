package com.tiendat.demo.ModelView;

import java.math.BigInteger;
import java.util.Map;

public class ChuyenHangTaiXe {

    public static final String So_Cont = "socont";
    public static final String Tien = "tien";
    public static final String Noi_Den = "noiden";
    public static final String Loai_Cong_Viec = "loaicongviec";

    private String socont;
    private Long tien;
    private String noiden;
    private String loaicongviec;

    public ChuyenHangTaiXe(Map<String, Object> values) {
        this.socont = values.get(So_Cont) != null ? (String) values.get(So_Cont): null;
        this.tien = values.get(Tien) != null ? ((BigInteger) values.get(Tien)).longValue() : null;
        this.noiden = values.get(Noi_Den) != null ? (String) values.get(Noi_Den) : null;
        this.loaicongviec = values.get(Loai_Cong_Viec) != null ? (String) values.get(Loai_Cong_Viec) : null;
    }

    public String getSocont() {
        return socont;
    }

    public void setSocont(String socont) {
        this.socont = socont;
    }

    public Long getTien() {
        return tien;
    }

    public void setTien(Long tien) {
        this.tien = tien;
    }

    public String getNoiden() {
        return noiden;
    }

    public void setNoiden(String noiden) {
        this.noiden = noiden;
    }

    public String getLoaicongviec() {
        return loaicongviec;
    }

    public void setLoaicongviec(String loaicongviec) {
        this.loaicongviec = loaicongviec;
    }
}
