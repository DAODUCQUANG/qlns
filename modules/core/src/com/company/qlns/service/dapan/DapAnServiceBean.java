package com.company.qlns.service.dapan;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service(DapAnService.NAME)
public class DapAnServiceBean implements DapAnService {
    @Inject
    private Persistence persistence;
    @Override
    public List<String> getDanhSachDapAn(UUID idCauHoi) {
        List<String> danhSachDapAn = new ArrayList<>();
        try (Transaction tx = persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            Query query = em.createNativeQuery(
                    "select e.ten_dapan from qlns_dap_an e,qlns_cau_hoi b where e.cau_hoi_id = b.id and b.id = #idCauHoi")
                    .setParameter("idCauHoi",idCauHoi);
            danhSachDapAn = (List<String>) query.getResultList();
            tx.commit();
            return danhSachDapAn;
        }
    }
}