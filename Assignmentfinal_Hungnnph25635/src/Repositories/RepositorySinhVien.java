package Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.SinhVien;

public class RepositorySinhVien {

    public ArrayList<SinhVien> getAll() {

        ArrayList<SinhVien> listSV = new ArrayList<>();
        try {
            Connection conn = utilis.jdbcUtil.getConnection();
            String sql = "select *from SinhViens";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String masv = rs.getString("masv");
                String tensv = rs.getString("tensv");
                String email = rs.getString("email");
                String sdt = rs.getString("sdt");
                int gioiTinh = rs.getInt("gioi_tinh");
                String diachi = rs.getString("dia_chi");
                String hinhAnh = rs.getString("hinh_anh");

                SinhVien sv = new SinhVien(id, masv, tensv, email, sdt, gioiTinh, diachi, hinhAnh);
                listSV.add(sv);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listSV;
    }

    public void insert(SinhVien sinhVien) {
        try {
            Connection conn = utilis.jdbcUtil.getConnection();

            String sql = "insert into SinhViens(masv,tensv,email,sdt,gioi_tinh,dia_chi,hinh_anh) values(?,?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, sinhVien.getMaSV());
            ps.setString(2, sinhVien.getTen());
            ps.setString(3, sinhVien.getEmail());
            ps.setString(4, sinhVien.getSDT());
            ps.setInt(5, sinhVien.getGioiTinh());
            ps.setString(6, sinhVien.getDiaChi());
            ps.setString(7, sinhVien.getHinhAnh());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Connection conn = utilis.jdbcUtil.getConnection();

            String sql = "delete from SinhViens where id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, SinhVien sinhVien) {
        try {
            Connection conn = utilis.jdbcUtil.getConnection();

            String sql = "update SinhViens set masv=?,tensv=?,email=?,sdt=?,gioi_tinh=?,dia_chi=?,hinh_anh=? where id =?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, sinhVien.getMaSV());
            ps.setString(2, sinhVien.getTen());
            ps.setString(3, sinhVien.getEmail());
            ps.setString(4, sinhVien.getSDT());
            ps.setInt(5, sinhVien.getGioiTinh());
            ps.setString(6, sinhVien.getDiaChi());
            ps.setString(7, sinhVien.getHinhAnh());
            ps.setInt(8, id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
