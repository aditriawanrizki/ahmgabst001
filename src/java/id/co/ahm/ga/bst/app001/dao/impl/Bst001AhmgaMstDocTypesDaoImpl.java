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
import id.co.ahm.ga.bst.app001.vo.Bst001MstAttachmentInsertVo;
import id.co.ahm.ga.bst.app001.vo.Bst001MstDocFilterVo;
import id.co.ahm.ga.bst.app001.vo.Bst001MstDocInsertVo;
import id.co.ahm.ga.bst.app001.vo.Bst001MstDocVo;
import id.co.ahm.ga.bst.app001.vo.Bst001MstPropertieInsertVo;

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
        sql.append("UPDATE AHMGABST_MSTDOCTYPE\n"
                + " SET BPRELIMNRY = :BPRELIMNRY "
                + "WHERE IDOCTYPEID = :IDOCTYPEID");
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        q.setParameter("IDOCTYPEID", id);
        q.setParameter("BPRELIMNRY", 0);
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
    public void insertMasterDoc(Bst001MstDocInsertVo mstDocVo, String dateCreated, String username) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO AHMGABST_MSTDOCTYPE\n" +
        "(IDOCTYPEID,VPURCHORG,DVALIDFROM,DVALIDTO,DCREA,DMODI,IPOTYPEID,BPRELIMNRY,VNAME,BQUANTITY,VTEMPLATE,VCREA,VMODI)\n" +
        "values (:IDOCTYPEID,:VPURCHORG,:DVALIDFROM,:DVALIDTO,:DCREA,:DMODI,:IPOTYPEID,:BPRELIMNRY,:VNAME,:BQUANTITY,:VTEMPLATE,:VCREA,:VMODI)");
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        q.setParameter("IDOCTYPEID",mstDocVo.getDocumentType());
        q.setParameter("VPURCHORG",mstDocVo.getPurchOrg());
        q.setParameter("DVALIDFROM",mstDocVo.getValidDateFrom());
        q.setParameter("DVALIDTO",mstDocVo.getValidDateTo());
        q.setParameter("DCREA", dateCreated);
        q.setParameter("DMODI", mstDocVo.getModifiedDate());
        q.setParameter("IPOTYPEID", mstDocVo.getPoType());
        q.setParameter("BPRELIMNRY", mstDocVo.getBprelimnry());
        q.setParameter("VNAME", mstDocVo.getDocName());
        q.setParameter("BQUANTITY", mstDocVo.getQuantity());
        q.setParameter("VTEMPLATE", mstDocVo.getTemplateName());
        q.setParameter("VCREA", username);
        q.setParameter("VMODI", mstDocVo.getModifiedBy());
        q.executeUpdate();
    }

    @Override
    public void insertAttachment(Bst001MstAttachmentInsertVo mstAttachmentVo, String dateCreated, String username, String attachmenName) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO AHMGABST_MSTATCHMNTS\n" +
        "(IMATCHMNTID,IDOCTYPEID,VNAME,DVALIDFROM,DVALIDTO,VCREA,VMODI,DCREA,DMODI,AHMGABST_DTLSETTINGSETTINGID)\n" +
        "values (:IMATCHMNTID,:IDOCTYPEID,:VNAME,:DVALIDFROM,:DVALIDTO,:VCREA,:VMODI,:DCREA,:DMODI,:AHMGABST_DTLSETTINGSETTINGID)");
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        q.setParameter("IMATCHMNTID", mstAttachmentVo.getAttachmentId());
        q.setParameter("IDOCTYPEID", mstAttachmentVo.getDocumentId());
        q.setParameter("VNAME", mstAttachmentVo.getAttachmentName());
        q.setParameter("DVALIDFROM", mstAttachmentVo.getValidDateFrom());
        q.setParameter("DVALIDTO", mstAttachmentVo.getValidDateTo());
        q.setParameter("VCREA", username);
        q.setParameter("VMODI", null);
        q.setParameter("DCREA", dateCreated);
        q.setParameter("DMODI", null);
        q.setParameter("AHMGABST_DTLSETTINGSETTINGID", null);
        q.executeUpdate();
    }

    @Override
    public void insertPropertie(Bst001MstPropertieInsertVo mstPropertiesVo, String dateCreated, String username) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO AHMGABST_MSTDOCPROPS\n" +
        "(IMDOCPROPID,IDOCTYPEID,IFIELDID,VCREA,VMODI,DCREA,DMODI)\n" +
        "values (:IMDOCPROPID,:IDOCTYPEID,:IFIELDID,:VCREA,:VMODI,:DCREA,:DMODI)");
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        q.setParameter("IMDOCPROPID",mstPropertiesVo.getProppertieId());
        q.setParameter("IDOCTYPEID", mstPropertiesVo.getDocumentId());
        q.setParameter("IFIELDID", mstPropertiesVo.getFieldId());
        q.setParameter("VCREA", username);
        q.setParameter("VMODI", null);
        q.setParameter("DCREA", dateCreated);
        q.setParameter("DMODI", null);
        q.executeUpdate();
    }

    @Override
    public void editMasterDoc(Bst001MstDocInsertVo mstDocVo, String dateCreated, String username) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE AHMGABST_MSTDOCTYPE SET \n"
         + "VPURCHORG = :VPURCHORG,DVALIDFROM = :DVALIDFROM,"
                + "DVALIDTO = :DVALIDTO ,DMODI = :DMODI,IPOTYPEID = :IPOTYPEID, BPRELIMNRY = :BPRELIMNRY,"
                + "VNAME = :VNAME,BQUANTITY = :BQUANTITY,VTEMPLATE = :VTEMPLATE,VMODI = :VMODI "
                + "WHERE IDOCTYPEID = :IDOCTYPEID");
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        q.setParameter("IDOCTYPEID",mstDocVo.getDocumentType());
        q.setParameter("VPURCHORG",mstDocVo.getPurchOrg());
        q.setParameter("DVALIDFROM",mstDocVo.getValidDateFrom());
        q.setParameter("DVALIDTO",mstDocVo.getValidDateTo());
        q.setParameter("DMODI", mstDocVo.getModifiedDate());
        q.setParameter("IPOTYPEID", mstDocVo.getPoType());
        q.setParameter("BPRELIMNRY", mstDocVo.getBprelimnry());
        q.setParameter("VNAME", mstDocVo.getDocName());
        q.setParameter("BQUANTITY", mstDocVo.getQuantity());
        q.setParameter("VTEMPLATE", mstDocVo.getTemplateName());
        q.setParameter("VMODI", username);
        q.executeUpdate();
    }

    @Override
    public void editAttachment(Bst001MstAttachmentInsertVo mstAttachmentVo, String dateCreated, String username, String attachmentName) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE AHMGABST_MSTATCHMNTS SET\n" +
        "VNAME = :VNAME, DVALIDFROM = :DVALIDFROM, DVALIDTO = :DVALIDTO, "
                + "VMODI = :VMODI, DMODI = :DMODI, AHMGABST_DTLSETTINGSETTINGID = :SETTINGID \n"
                + "WHERE IDOCTYPEID = :IDOCTYPEID "
                + "and IMATCHMNTID = :IMATCHMNTID ");
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        q.setParameter("IMATCHMNTID", mstAttachmentVo.getAttachmentId());
        q.setParameter("IDOCTYPEID", mstAttachmentVo.getDocumentId());
        q.setParameter("VNAME", attachmentName);
        q.setParameter("DVALIDFROM", mstAttachmentVo.getValidDateFrom());
        q.setParameter("DVALIDTO", mstAttachmentVo.getValidDateTo());
        q.setParameter("VMODI", username);
        q.setParameter("DMODI", dateCreated);
        q.setParameter("SETTINGID ", null);
        q.executeUpdate();
    }

    @Override
    public void editPropertie(Bst001MstPropertieInsertVo mstPropertiesVo, String dateCreated, String username) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE AHMGABST_MSTDOCPROPS SET\n" +
        "IDOCTYPEID = :IDOCTYPEID, IFIELDID = :IFIELDID, VCREA = :VCREA, VMODI = :VMODI, DCREA = :DCREA, DMODI = :DMODI \n"
                + "WHERE IDOCTYPEID = :IDOCTYPEID "
                + "AND IMDOCPROPID = :IMDOCPROPID");
        Query q = getCurrentSession().createSQLQuery(sql.toString());
        q.setParameter("IMDOCPROPID",mstPropertiesVo.getProppertieId());
        q.setParameter("IDOCTYPEID", mstPropertiesVo.getDocumentId());
        q.setParameter("IFIELDID", mstPropertiesVo.getFieldId());
        q.setParameter("VMODI", username);
        q.setParameter("DMODI", dateCreated);
        q.executeUpdate();
    }
    
    
    
    
    
}
