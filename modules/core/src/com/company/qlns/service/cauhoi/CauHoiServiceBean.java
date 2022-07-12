package com.company.qlns.service.cauhoi;

import com.company.qlns.entity.CauHoi;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service(CauHoiService.NAME)
public class CauHoiServiceBean implements CauHoiService {
    @Inject
    private Persistence persistence;
    @Override
    public List<CauHoi> getListCauHoi(UUID idChuyenNganh) {
        List<CauHoi> cauHois = new ArrayList<CauHoi>();
        try (Transaction tx= persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            Query query = em.createNativeQuery("select * from qlns_cau_hoi e,qlns_chuyen_nganh b where e.chuyen_nganh_id = b.id and b.id = #idChuyenNganh",CauHoi.class)
                    .setParameter("idChuyenNganh", idChuyenNganh);
            cauHois = (List<CauHoi>) query.getResultList();
            tx.commit();
            return cauHois;
        }
    }

    @Override
    public String getDapAnDung(UUID idCauHoi) {
        String dapAnDung = new String();
        try (Transaction tx= persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            Query query = em.createNativeQuery("select b.ten_dapan from qlns_cau_hoi e,qlns_dap_an b where e.id = #idCauHoi \n" +
                    "and b.id = e.dap_an_dung").setParameter("idCauHoi", idCauHoi);
            dapAnDung = (String) query.getSingleResult();
            tx.commit();
            return dapAnDung;
        }
    }
}