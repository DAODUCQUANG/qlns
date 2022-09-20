package com.company.qlns.service.chuyennganh;

import com.company.qlns.entity.ChuyenNganh;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Service(ChuyenNganhService.NAME)
public class ChuyenNganhServiceBean implements ChuyenNganhService {
    @Inject
    private Persistence persistence;
    @Override
    public UUID getIdChuyenNganh(String email) {
        UUID idChuyenNganh;
        try (Transaction tx= persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            Query query = em.createNativeQuery("select e.chuyen_nganh_id from qlns_phan_cong e,qlns_ung_vien b where b.id = e.ung_vien_id and b.email = #email")
                    .setParameter("email",email);
            idChuyenNganh = (UUID) query.getSingleResult();
            tx.commit();
            return idChuyenNganh;
        }
    }

    @Override
    public List<String> getTenChuyenNganh() {
        List<String> listTenChuyenNganh;
        try(Transaction tx = persistence.createTransaction()) {

            EntityManager em = persistence.getEntityManager();
            Query query = em.createNativeQuery("SELECT e.ten_chuyen_nganh FROM qlns_chuyen_nganh e\n" +
                    "ORDER BY id ASC ");
            listTenChuyenNganh = query.getResultList();
            tx.commit();
            return  listTenChuyenNganh;
        }
    }

    @Override
    public ChuyenNganh getChuyenNganh(UUID idChuyenNganh) {
        ChuyenNganh chuyenNganh;
        try(Transaction tx = persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            Query query = em.createQuery("select e from qlns_ChuyenNganh e where e.id = :idChuyenNganh")
                    .setParameter("idChuyenNganh", idChuyenNganh);
            chuyenNganh = (ChuyenNganh) query.getSingleResult();
            tx.commit();
            return chuyenNganh;
        }
    }
    @Override
    public ChuyenNganh getChuyenNganhByName(String tenChuyenNganh) {
        ChuyenNganh chuyenNganh;
        try(Transaction tx = persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            Query query = em.createNativeQuery("select * from qlns_chuyen_nganh e where e.ten_chuyen_nganh = #tenChuyenNganh",ChuyenNganh.class)
                    .setParameter("tenChuyenNganh", tenChuyenNganh);
            chuyenNganh = (ChuyenNganh) query.getSingleResult();
            tx.commit();
            return chuyenNganh;
        }
    }
}