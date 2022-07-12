package com.company.qlns.service.ungvien;

import com.company.qlns.entity.UngVien;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@Service(UngVienService.NAME)
public class UngVienServiceBean implements UngVienService {
    @Inject
    private Persistence persistence;

    @Override
    public void setDiemUngVien(int tongSoCauHoi, int tongSoCauTraLoiDung, int tongSoCauTraLoiDuoc, float diemUngVien,Boolean ketQuaPheDuyet, String email) {
        try (Transaction tx = persistence.createTransaction()) {
            EntityManager entityManager = persistence.getEntityManager();
            Query query = entityManager.createNativeQuery("UPDATE qlns_ung_vien SET tong_so_cau_hoi = #tongSoCauHoi,tong_so_cau_tra_loi_dung=#tongSoCauTraLoiDung,tong_so_cau_tra_loi_duoc=#tongSoCauTraLoiDuoc,so_diem_dat_duoc=#diemUngVien,ket_qua_phe_duyet=#ketQuaPheDuyet WHERE qlns_ung_vien.email = #email")
                    .setParameter("tongSoCauHoi", tongSoCauHoi)
                    .setParameter("tongSoCauTraLoiDung", tongSoCauTraLoiDung)
                    .setParameter("tongSoCauTraLoiDuoc", tongSoCauTraLoiDuoc)
                    .setParameter("diemUngVien", diemUngVien)
                    .setParameter("ketQuaPheDuyet",ketQuaPheDuyet)
                    .setParameter("email", email);
            query.executeUpdate();
            tx.commit();
        }
    }

    @Override
    public boolean checkEmailUngVien(String email) {
        List<UUID> uuid ;
        try(Transaction tx = persistence.createTransaction()) {
            EntityManager entityManager = persistence.getEntityManager();
            Query query = entityManager.createNativeQuery("select e.id from qlns_ung_vien e where e.email = #email")
                    .setParameter("email",email);
            uuid = query.getResultList();
            tx.commit();
            if (uuid.size() > 0) {
                return true;
            }
        } catch (NoResultException exception) {
        }
        return false;
    }

    @Override
    public boolean checkUngVien(UUID idUngVien) {
        String email;
        try(Transaction tx = persistence.createTransaction()) {
            EntityManager entityManager = persistence.getEntityManager();
            Query query = entityManager.createQuery("select e.email from qlns_UngVien e where e.id = :idUngVien")
                    .setParameter("idUngVien",idUngVien);
            email = (String)query.getSingleResult();
            tx.commit();
            if(email != null || !email.isEmpty()) {
                return true;
            }
        } catch (NoResultException exception) {
        }
        return false;
    }

    @Override
    public String getNameUngVien(String email) {
        try(Transaction tx = persistence.createTransaction()) {
            String tenUngVien;
            EntityManager entityManager = persistence.getEntityManager();
            Query query = entityManager.createNativeQuery("select e.ten_ungvien from qlns_ung_vien e where e.email = #email")
                    .setParameter("email", email);
            tenUngVien = (String)query.getSingleResult();
            tx.commit();
            return tenUngVien;
        }
    }

    @Override
    public UngVien getUngVien(UUID idUngVien) {
        try(Transaction transaction = persistence.createTransaction()) {
            UngVien ungVien;
            EntityManager entityManager = persistence.getEntityManager();
            Query query = entityManager.createQuery("select e from qlns_UngVien e where e.id = :idUngVien")
                    .setParameter("idUngVien", idUngVien);
            ungVien = (UngVien)query.getSingleResult();
            transaction.commit();
            return ungVien;
        }
    }
}