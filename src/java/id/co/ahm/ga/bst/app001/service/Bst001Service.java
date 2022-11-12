/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package id.co.ahm.ga.bst.app001.service;

import id.co.ahm.ga.bst.app001.vo.Bst001MstAttachmentInsertVo;
import id.co.ahm.ga.bst.app001.vo.Bst001MstDocFilterVo;
import id.co.ahm.ga.bst.app001.vo.Bst001MstDocInsertVo;
import id.co.ahm.ga.bst.app001.vo.Bst001MstPropertieInsertVo;
import id.co.ahm.jxf.dto.DtoResponseWorkspace;

/**
 *
 * @author aditr
 */
public interface Bst001Service {
    public DtoResponseWorkspace getListMasterDocument();
    public DtoResponseWorkspace getListMasterDocumentFiltered(Bst001MstDocFilterVo filterVo);
    public DtoResponseWorkspace getLovDocType(String documentType);
    public DtoResponseWorkspace getLovPurchasing(String purchasingOrg);
    public DtoResponseWorkspace deleteMasterDocById(String id);
    public DtoResponseWorkspace deleteAttachmentById(String id);
    public DtoResponseWorkspace deleteWorkflowEkternal(String id);
    public DtoResponseWorkspace deleteWorkflowInternal(String id);
    public DtoResponseWorkspace deletePropertieDoc(String id);
    public DtoResponseWorkspace insertMasterDoc(Bst001MstDocInsertVo mstDocVo, String username);
    public DtoResponseWorkspace insertAttachment(Bst001MstAttachmentInsertVo mstAttachmentVo, String username);
    public DtoResponseWorkspace insertPropertie(Bst001MstPropertieInsertVo mstPropertiesVo, String username);
    public DtoResponseWorkspace editMasterDoc(Bst001MstDocInsertVo mstDocVo, String username);
    public DtoResponseWorkspace editAttachment(Bst001MstAttachmentInsertVo mstAttachmentVo, String username);
    public DtoResponseWorkspace editPropertie(Bst001MstPropertieInsertVo mstPropertiesVo, String username);
}
