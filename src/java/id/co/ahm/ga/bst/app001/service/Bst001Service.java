/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package id.co.ahm.ga.bst.app001.service;

import id.co.ahm.ga.bst.app001.vo.Bst001MstDocFilterVo;
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
}
