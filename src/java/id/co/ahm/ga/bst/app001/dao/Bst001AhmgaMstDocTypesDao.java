/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package id.co.ahm.ga.bst.app001.dao;

import id.co.ahm.ga.bst.app001.vo.Bst001MstDocFilterVo;
import id.co.ahm.ga.bst.app001.vo.Bst001MstDocVo;
import id.co.ahm.jxf.dao.DefaultDao;
import java.util.List;

/**
 *
 * @author aditr
 */
public interface Bst001AhmgaMstDocTypesDao extends DefaultDao<String, String>{
    public List<Bst001MstDocVo> getList();
    public List<Bst001MstDocVo> findByParameter(Bst001MstDocFilterVo filterVo);
    public List<String> findAll();
    public List<Bst001MstDocVo> findLovDocType(String documentType);
    public List<Bst001MstDocVo> findLovPurchasing(String purchOrg);
    public void deleteMasterDocById(String id);
    public void deleteAttachmentById(String id);
    public void deleteWorkflowEkternal(String id);
    public void deleteWorkflowInternal(String id);
    public void deletePropertieDoc(String id);
    public void insertMasterDoc(Bst001MstDocVo mstDocVo, String dateCreated, String username);
       
}
