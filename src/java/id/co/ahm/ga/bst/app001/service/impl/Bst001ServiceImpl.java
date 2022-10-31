/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.ahm.ga.bst.app001.service.impl;

import id.co.ahm.ga.bst.app001.dao.Bst001AhmgaMstDocTypesDao;
import id.co.ahm.ga.bst.app001.service.Bst001Service;
import id.co.ahm.ga.bst.app001.vo.Bst001MstDocFilterVo;
import id.co.ahm.ga.bst.app001.vo.Bst001MstDocVo;
import id.co.ahm.jxf.dto.DtoResponseWorkspace;
import java.util.List;
import org.apache.zookeeper.proto.DeleteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author aditr
 */
public class Bst001ServiceImpl implements Bst001Service{

    @Autowired
    @Qualifier("ism036AhmitismHdrticketsDao")
    Bst001AhmgaMstDocTypesDao mstDocDao;
    
    private DtoResponseWorkspace setupDtoResponse(DtoResponseWorkspace dto, boolean status){
        if (status == true){
            dto.setStatus("1");
            dto.setMessage("SUKSES");
        } else {
            dto.setStatus("0");
            dto.setMessage("Data not found");
        }
        
        return dto;    
    }
    
    
    @Override
    public DtoResponseWorkspace getListMasterDocument() {
        DtoResponseWorkspace dto = new DtoResponseWorkspace(); 
        List<Bst001MstDocVo> masterDocs = mstDocDao.getList();
        
        if (masterDocs.isEmpty()){
            dto.setStatus("1");
            dto.setMessage("SUKSES");
        } else {
            dto.setStatus("0");
            dto.setMessage("Data not found");
        }
        
        dto.setData(masterDocs);
        
        return dto;
    }

    @Override
    public DtoResponseWorkspace getListMasterDocumentFiltered(Bst001MstDocFilterVo filterVo) {
        DtoResponseWorkspace dto = new DtoResponseWorkspace(); 
        List<Bst001MstDocVo> masterDocs = mstDocDao.findByParameter(filterVo);
        boolean statusCheck;
        
        if (!masterDocs.isEmpty()){
            statusCheck = true;
            dto.setData(masterDocs);
        } else {
            statusCheck = false;
        }
        
        this.setupDtoResponse(dto, statusCheck);        
        
        return dto;
    }

    @Override
    public DtoResponseWorkspace getLovDocType(String documentType) {
        DtoResponseWorkspace dto = new DtoResponseWorkspace(); 
        List<Bst001MstDocVo> masterDocs = mstDocDao.findLovDocType(documentType);
        boolean statusCheck;
        
        if (!masterDocs.isEmpty()){
            statusCheck = true;
            dto.setData(masterDocs);
        } else {
            statusCheck = false;
        }
        
        this.setupDtoResponse(dto, statusCheck);        
        
        return dto;
    }

    @Override
    public DtoResponseWorkspace getLovPurchasing(String purchasingOrg) {
        DtoResponseWorkspace dto = new DtoResponseWorkspace(); 
        List<Bst001MstDocVo> masterDocs = mstDocDao.findLovPurchasing(purchasingOrg);
        boolean statusCheck;
        
        if (!masterDocs.isEmpty()){
            statusCheck = true;
            dto.setData(masterDocs);
        } else {
            statusCheck = false;
        }
        
        this.setupDtoResponse(dto, statusCheck);        
        
        return dto;
    }

    @Override
    public DtoResponseWorkspace deleteMasterDocById(String id) {
        DtoResponseWorkspace dto = new DtoResponseWorkspace(); 
        boolean statusCheck;
        
        try {
            mstDocDao.deleteMasterDocById(id);
            statusCheck = true;
        } catch (Exception e) {
            statusCheck = false;
        }
        
        this.setupDtoResponse(dto, statusCheck);        
        
        return dto;
    }

    @Override
    public DtoResponseWorkspace deleteAttachmentById(String id) {
        DtoResponseWorkspace dto = new DtoResponseWorkspace(); 
        boolean statusCheck;
        
        try {
            mstDocDao.deleteAttachmentById(id);
            statusCheck = true;
        } catch (Exception e) {
            statusCheck = false;
        }
        
        this.setupDtoResponse(dto, statusCheck);        
        
        return dto;
    }

    @Override
    public DtoResponseWorkspace deleteWorkflowEkternal(String id) {
        DtoResponseWorkspace dto = new DtoResponseWorkspace(); 
        boolean statusCheck;
        
        try {
            mstDocDao.deleteWorkflowEkternal(id);
            statusCheck = true;
        } catch (Exception e) {
            statusCheck = false;
        }
        
        this.setupDtoResponse(dto, statusCheck);        
        
        return dto;
    }

    @Override
    public DtoResponseWorkspace deleteWorkflowInternal(String id) {
        DtoResponseWorkspace dto = new DtoResponseWorkspace(); 
        boolean statusCheck;
        
        try {
            mstDocDao.deleteWorkflowInternal(id);
            statusCheck = true;
        } catch (Exception e) {
            statusCheck = false;
        }
        
        this.setupDtoResponse(dto, statusCheck);        
        
        return dto;
    }

    @Override
    public DtoResponseWorkspace deletePropertieDoc(String id) {
        DtoResponseWorkspace dto = new DtoResponseWorkspace(); 
        boolean statusCheck;
        
        try {
            mstDocDao.deletePropertieDoc(id);
            statusCheck = true;
        } catch (Exception e) {
            statusCheck = false;
        }
        
        this.setupDtoResponse(dto, statusCheck);        
        
        return dto;
    }
    
}
