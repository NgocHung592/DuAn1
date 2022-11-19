package services;

import Repositories.RepositorySinhVien;
import models.SinhVien;
import java.util.ArrayList;

public class SinhVienService {

    private Repositories.RepositorySinhVien resSinhVien;

    public SinhVienService() {
        this.resSinhVien = new RepositorySinhVien();
    }

    public ArrayList<SinhVien> getData() {
        return this.resSinhVien.getAll();
    }

    public void insert(SinhVien sv) {
        this.resSinhVien.insert(sv);
    }

    public void delete(int id) {
        this.resSinhVien.delete(id);
    }

    public void update(int id, SinhVien sv) {
        this.resSinhVien.update(id, sv);
    }

}
