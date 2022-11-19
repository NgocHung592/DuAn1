package Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Diem;
import utilis.jdbcUtil;

public class RepositoryDiem {

    public ArrayList<Diem> getAll() {

        ArrayList<Diem> listDiem = new ArrayList<>();
        try {
            Connection conn = utilis.jdbcUtil.getConnection();
            String sql = "select *from Diems";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String masv = rs.getString("masv");
                String tensv = rs.getString("tensv");
                double diemta = rs.getDouble("diem_tienganh");
                double diemth = rs.getDouble("diem_tinhoc");
                double diemgdtc = rs.getDouble("diem_gdtc");

                Diem diem = new Diem(id, masv, tensv, diemta, diemth, diemgdtc);

                listDiem.add(diem);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listDiem;
    }

    public void insert(Diem diem) {
        try {
            Connection conn = utilis.jdbcUtil.getConnection();

            String sql = "insert into Diems(masv,tensv,diem_tienganh,diem_tinhoc,diem_gdtc) values(?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, diem.getMaSV());
            ps.setString(2, diem.getHoTen());
            ps.setDouble(3, diem.getTiengAnh());
            ps.setDouble(4, diem.getTinHoc());
            ps.setDouble(5, diem.getGDTC());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void upate(int id, Diem diem) {
        try {
            Connection conn = utilis.jdbcUtil.getConnection();

            String sql = "update Diems set masv=?,tensv=?,diem_tienganh=?,diem_tinhoc=?,diem_gdtc=? where id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, diem.getMaSV());
            ps.setString(2, diem.getHoTen());
            ps.setDouble(3, diem.getTiengAnh());
            ps.setDouble(4, diem.getTinHoc());
            ps.setDouble(5, diem.getGDTC());
            ps.setInt(6, id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Connection conn = utilis.jdbcUtil.getConnection();

            String sql = "delete from Diems where id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Diem> Search(int id) {

        ArrayList<Diem> listSearch = new ArrayList<>();
        try {
            Connection conn = utilis.jdbcUtil.getConnection();
            String sql = "select *from Diems where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            
            while (rs.next()) {
               
                String masv = rs.getString("masv");
                String tensv = rs.getString("tensv");
                double diemta = rs.getDouble("diem_tienganh");
                double diemth = rs.getDouble("diem_tinhoc");
                double diemgdtc = rs.getDouble("diem_gdtc");

                Diem diem = new Diem(id, masv, tensv, diemta, diemth, diemgdtc);
                listSearch.add(diem);
               
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listSearch;
    }
}
