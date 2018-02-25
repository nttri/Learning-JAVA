/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.Serializable;

/**
 *
 * @author thanhtri
 */
public class HocSinh implements Serializable{

    private int MHS;
    private String TenHS, DiaChi, GhiChu;
    private Float Diem;

    public int getMHS() {
        return MHS;
    }

    public void setMHS(int MHS) {
        this.MHS = MHS;
    }

    public String getTenHS() {
        return TenHS;
    }

    public void setTenHS(String TenHS) {
        this.TenHS = TenHS;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public Float getDiem() {
        return Diem;
    }

    public void setDiem(Float Diem) {
        this.Diem = Diem;
    }
    
    public String toCSV(){
        return MHS + ";" + TenHS + ";" + Diem + ";" + DiaChi + ";" + GhiChu + ";" ;
    }
    
    @Override
    public String toString(){
        return "Mã HSSV: "+ MHS + ", Họ tên: " + TenHS + ", điểm: " + Diem + ", địa chỉ: " + DiaChi + ", ghi chú: "+GhiChu;
    }
    

}
