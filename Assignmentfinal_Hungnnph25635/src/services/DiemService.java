package services;

import Repositories.RepositoryDiem;
import models.Diem;
import java.util.ArrayList;

public class DiemService {

    private Repositories.RepositoryDiem resDiem;
    private int i = 0;

    public DiemService() {
        this.resDiem = new RepositoryDiem();
    }

    public ArrayList<Diem> getdata() {
        return this.resDiem.getAll();
    }

    public void insert(Diem diem) {
        this.resDiem.insert(diem);
    }

    public void update(int id, Diem diem) {
        this.resDiem.upate(id, diem);
    }

    public void delete(int id) {
        this.resDiem.delete(id);
    }

    public ArrayList<Diem> Search(int id) {
        return this.resDiem.Search(id);
    }
 

    public void setIndex(Diem diem) {
        i = this.resDiem.getAll().indexOf(diem);
    }

    public Diem getIndexDiem() {
        if (this.resDiem.getAll().isEmpty()) {
            return null;
        }
        return this.resDiem.getAll().get(i);
    }

    public int getIndex() {
        return i;
    }

    public void first() {
        if (!this.resDiem.getAll().isEmpty()) {
            if (i > 0) {
                i = 0;
            }
        }
    }

    public void last() {
        if (!this.resDiem.getAll().isEmpty()) {
            i = this.resDiem.getAll().size() - 1;
        }
    }

    public void next() {
        if (i < this.resDiem.getAll().size() - 1) {
            i++;

        }
    }

    public void previous() {
        if (!this.resDiem.getAll().isEmpty()) {
            if (i > 0) {
                i--;
            }
        }
    }
}
