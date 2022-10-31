/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.ahm.ga.bst.app001.dao.impl;

import id.co.ahm.jxf.dao.DefaultHibernateDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import id.co.ahm.ga.bst.app001.dao.Bst001AhmgaMstDocTypesDao;
import id.co.ahm.ga.bst.app001.vo.Bst001MstDocFilterVo;
import id.co.ahm.ga.bst.app001.vo.Bst001MstDocVo;

/**
 *
 * @author aditr
 */
@Repository("bst001AhmgaMstDocTypesDao")
public class Bst001AhmgaMstDocTypesDaoImpl extends DefaultHibernateDao<String, String> implements Bst001AhmgaMstDocTypesDao{

    @Override
    public List<Bst001MstDocVo> getList() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT VDOCTYPE,VPURCHAS,DCREA,DMODI,VSTATUS FROM AHMGABST_MSTDOCTYPE");
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        
        return q.list();
    }

    @Override
    public List<String> findAll() {
        return super.findAll(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public List<Bst001MstDocVo> findByParameter(Bst001MstDocFilterVo filterVo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT VDOCTYPE,VPURCHAS,DCREA,DMODI,VSTATUS FROM AHMGABST_MSTDOCTYPE WHERE ");
        if (filterVo.getDocumentType() !=null){
            sql.append("UPPER (VDOCTYPE)LIKE UPPER ('%'||:VDOCTYPE||'%')");
        }
        if (filterVo.getJenisBast() != null) {
            sql.append("UPPER (IPODTYPE) LIKE UPPER ('%'||:IPODTYPE||'%')");
        }
        if (filterVo.getPurchOrg()!=null){
            sql.append("UPPER (VPURCHAS) LIKE UPPER ('%'||:VPURCHASE||'%')");
        }
        if (filterVo.getValidDateFrom() != null && filterVo.getValidDateTo() != null){
            sql.append("DVALIDFROM => :DVALIDFROM");
            sql.append("DVALIDTO =< :DVALIDTO");
        }
        if (filterVo.getStatus() != null){
            sql.append("UPPER(VSTATUS) LIKE UPPER('%'||:VSTATUS||'%') ");
        }
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        if (filterVo.getDocumentType() !=null)q.setParameter("VDOCTYPE", filterVo.getDocumentType());
        if (filterVo.getJenisBast() != null)q.setParameter("IPODTYPE", filterVo.getJenisBast());
        if (filterVo.getPurchOrg()!=null)q.setParameter("VPURCHASE", filterVo.getPurchOrg());
        if (filterVo.getValidDateFrom()!=null)q.setParameter("DVALIDFROM", filterVo.getValidDateFrom());
        if (filterVo.getValidDateTo() != null)q.setParameter("DVALIDTO", filterVo.getValidDateTo());
        if (filterVo.getStatus() != null)q.setParameter("VSTATUS", filterVo.getStatus());
        return q.list();
    }

    @Override
    public List<Bst001MstDocVo> findLovDocType(String documentType) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT VDOCTYPE,VPURCHAS,DCREA,DMODI,VSTATUS\n" +
                   "FROM AHMGABST_MSTDOCTYPE\n" +
                   "WHERE UPPER (VDOCTYPE)LIKE UPPER ('%'||:VDOCTYPE||'%')");
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        q.setParameter("VDOCTYPE", documentType);
        
        return q.list();
    }

    @Override
    public List<Bst001MstDocVo> findLovPurchasing(String purchOrg) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT VDOCTYPE,VPURCHAS,DCREA,DMODI,VSTATUS\n" +
        "FROM AHMGABST_MSTDOCTYPE\n" +
        "WHERE UPPER (VPURCHAS)LIKE UPPER ('%'||:VPURCHAS||'%')");
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        q.setParameter("VPURCHAS", purchOrg);
        
        return q.list();
    }

    @Override
    public void deleteMasterDocById(String id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM AHMGABST_MSTDOCTYPE\n" +
        "WHERE IDOCTYPEID = :IDOCTYPEID");
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        q.setParameter("IDOCTYPEID", id);
    }

    @Override
    public void deleteAttachmentById(String id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM AHMGABST_MSTATCHMNTS\n" +
        "WHERE IMATCHMNTID = :IMATCHMNTID");
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        q.setParameter("IMATCHMNTID", id);
    }

    @Override
    public void deleteWorkflowEkternal(String id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM AHMGABST_MSTATCHMNTS\n" +
        "WHERE IMATCHMNTID = :IMATCHMNTID");
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        q.setParameter("IMATCHMNTID", id);
    }

    @Override
    public void deleteWorkflowInternal(String id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM AHMGABST_MSTATCHMNTS\n" +
        "WHERE IMATCHMNTID = :IMATCHMNTID");
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        q.setParameter("IMATCHMNTID", id);
    }

    @Override
    public void deletePropertieDoc(String id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM AHMGABST_MSTATCHMNTS\n" +
        "WHERE IMATCHMNTID = :IMATCHMNTID");
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        q.setParameter("IMATCHMNTID", id);
    }

    @Override
    public void insertMasterDoc(Bst001MstDocVo mstDocVo, String dateCreated, String username) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO AHMGABST_MSTATCHMNTS\n" +
        "(IDOCTYPEID,VPURCHORG,DVALIDFROM,DVALIDTO,DCREA,DMODI,IPOTYPEID,BPRELIMNRY,VNAME,BQUANTITY,VTEMPLATE,VCREA,VMODI)\n" +
        "values (:IDOCTYPEID,:VPURCHORG,:DVALIDFROM,:DVALIDTO,:DCREA,:DMODI,:IPOTYPEID,:BPRELIMNRY,:VNAME,:BQUANTITY,:VTEMPLATE,:VCREA,:VMODI)");
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        q.setParameter("IDOCTYPEID",mstDocVo.getDocumentType());
        q.setParameter("VPURCHORG",mstDocVo.getPurchOrg());
        q.setParameter("DVALIDFROM",mstDocVo.getValidDateFrom());
        q.setParameter("DVALIDTO",mstDocVo.getValidDateTo());
        q.setParameter("DCREA", dateCreated);
        q.setParameter("DMODI", mstDocVo.getModifiedDate());
        q.setParameter("IPOTYPEID", null);
        q.setParameter("BPRELIMNRY", null);
        q.setParameter("VNAME", null);
        q.setParameter("BQUANTITY", null);
        q.setParameter("VTEMPLATE",null);
        q.setParameter("VCREA", username);
        q.setParameter("VMODI", mstDocVo.getModifiedBy());
        q.executeUpdate();
    }
    
    
    
    
    
}
