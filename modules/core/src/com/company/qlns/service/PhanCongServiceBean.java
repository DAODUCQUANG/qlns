package com.company.qlns.service;

import com.company.qlns.entity.ChuyenNganh;
import com.company.qlns.entity.UngVien;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import org.springframework.stereotype.Service;
import com.company.qlns.service.phancong.PhanCongService;

import javax.inject.Inject;
import javax.persistence.NoResultException;

@Service(PhanCongService.NAME)
public class PhanCongServiceBean implements PhanCongService {
    @Inject
    private Persistence persistence;
    @Override
    public boolean checkUngVienDuocPhanCong(UngVien ungVien) {
        ChuyenNganh chuyenNganh;
        try(Transaction transaction = persistence.createTransaction()){
            EntityManager entityManager = persistence.getEntityManager();
            Query query = entityManager.createQuery("select e.chuyenNganh from qlns_PhanCong e where e.ungVien = :ungVien", ChuyenNganh.class)
                    .setParameter("ungVien",ungVien);
            chuyenNganh = (ChuyenNganh) query.getSingleResult();
            transaction.commit();
            if(chuyenNganh.getId() != null){
                return true;
            }
        } catch (NoResultException exception) {
        }
        return false;
    }

    @Override
    public boolean checkChuyenNganh(UngVien ungVien,ChuyenNganh chuyenNganh) {
        try(Transaction transaction = persistence.createTransaction()){
            ChuyenNganh chuyenNganh1;
            EntityManager entityManager = persistence.getEntityManager();
            Query query = entityManager.createQuery("select e.chuyenNganh from qlns_PhanCong e where e.ungVien = :ungVien", ChuyenNganh.class)
                    .setParameter("ungVien",ungVien);
            chuyenNganh1 = (ChuyenNganh) query.getSingleResult();
            transaction.commit();
            System.out.println("SEVICE");
            System.out.println(chuyenNganh.getId());
            System.out.println(chuyenNganh.getId());
            if(chuyenNganh.getId().toString().equals(chuyenNganh1.getId().toString())) {
                return true;
            }
        } catch (NoResultException exception) {
        }
        return false;
    }
}