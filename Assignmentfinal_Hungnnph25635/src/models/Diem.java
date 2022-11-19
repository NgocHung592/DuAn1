package models;

public class Diem {

    private int id;
    private String maSV;
    private String hoTen;
    private double tiengAnh;
    private double tinHoc;
    private double GDTC;

    public Diem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Diem(int id, String maSV, String hoTen, double tiengAnh, double tinHoc, double GDTC) {
        this.id = id;
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(double tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public double getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(double tinHoc) {
        this.tinHoc = tinHoc;
    }

    public double getGDTC() {
        return GDTC;
    }

    public void setGDTC(double GDTC) {
        this.GDTC = GDTC;
    }

}
