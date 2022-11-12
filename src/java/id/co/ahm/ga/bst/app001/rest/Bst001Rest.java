/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.ahm.ga.bst.app001.rest;

import id.co.ahm.ga.bst.app001.service.Bst001Service;
import id.co.ahm.ga.bst.app001.vo.Bst001MstAttachmentInsertVo;
import id.co.ahm.ga.bst.app001.vo.Bst001MstDocFilterVo;
import id.co.ahm.ga.bst.app001.vo.Bst001MstDocInsertVo;
import id.co.ahm.ga.bst.app001.vo.Bst001MstPropertieInsertVo;
import id.co.ahm.jxf.constant.CommonConstant;
import id.co.ahm.jxf.dto.DtoResponseWorkspace;
import id.co.ahm.jxf.security.TokenPstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aditr
 */
@RestController
@RequestMapping("/ga/bst")
public class Bst001Rest {
    
    @Autowired
    @Qualifier(value = "tokenPstUtil")
    private TokenPstUtil tokenPstUtil;
    
    @Autowired
    private Bst001Service bst001Service;
    
    @RequestMapping(value = "list", method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
//    DtoResponseWorkspace searchFAQ(@RequestHeader(value = "token", defaultValue = "") String token,
//            @RequestBody Ism039Search input) {        
    DtoResponseWorkspace getList(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token) {
 
        return bst001Service.getListMasterDocument();
    }
    
    @RequestMapping(value = "list/search", method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
//    DtoResponseWorkspace searchFAQ(@RequestHeader(value = "token", defaultValue = "") String token,
//            @RequestBody Ism039Search input) {        
    DtoResponseWorkspace getListSearch(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestHeader(value = "jenisBast") String jenisBast,
            @RequestHeader(value = "documentType") String documentType,
            @RequestHeader(value = "purchOrg") String purchOrg,
            @RequestHeader(value = "validDateFrom") String validDateFrom,
            @RequestHeader(value = "validDateTo") String validDateTo,
            @RequestHeader(value = "status") String status,
            @RequestHeader(value = "modifiedDate") String modifiedDate,
            @RequestHeader(value = "modifiedBy") String modifiedBy) {
        Bst001MstDocFilterVo filterVo = new Bst001MstDocFilterVo();
        filterVo.setDocumentType(documentType);
        filterVo.setJenisBast(jenisBast);
        filterVo.setPurchOrg(purchOrg);
        filterVo.setValidDateFrom(validDateFrom);
        filterVo.setValidDateTo(validDateTo);
        filterVo.setStatus(status);
        filterVo.setModifiedDate(modifiedDate);
        filterVo.setModifiedBy(modifiedBy);
 
        return bst001Service.getListMasterDocumentFiltered(filterVo);
    }
    
    @RequestMapping(value = "lov-doc", method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
//    DtoResponseWorkspace searchFAQ(@RequestHeader(value = "token", defaultValue = "") String token,
//            @RequestBody Ism039Search input) {        
    DtoResponseWorkspace getLovDoc(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestHeader(value = "documentType", defaultValue = "") String documentType) {
 
        return bst001Service.getLovDocType(documentType);
    }
    
    @RequestMapping(value = "lov-purchase", method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
//    DtoResponseWorkspace searchFAQ(@RequestHeader(value = "token", defaultValue = "") String token,
//            @RequestBody Ism039Search input) {        
    DtoResponseWorkspace getLovPurchaseOrg(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestHeader(value = "purchasingOrg", defaultValue = "") String purchasingOrg) {
 
        return bst001Service.getLovPurchasing(purchasingOrg);
    }
    
    @PostMapping(value = "insert/master",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
//    DtoResponseWorkspace searchFAQ(@RequestHeader(value = "token", defaultValue = "") String token,
//            @RequestBody Ism039Search input) {        
    DtoResponseWorkspace insertMasterDoc(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody Bst001MstDocInsertVo mstInsertVo) {
 
        return bst001Service.insertMasterDoc(mstInsertVo, token);
    }
    
    @PostMapping(value = "insert/attachment",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
//    DtoResponseWorkspace searchFAQ(@RequestHeader(value = "token", defaultValue = "") String token,
//            @RequestBody Ism039Search input) {        
    DtoResponseWorkspace insertAttachment(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody Bst001MstAttachmentInsertVo attachInsertVo) {
 
        return bst001Service.insertAttachment(attachInsertVo, token);
    }
    
    @PostMapping(value = "insert/propertie",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
//    DtoResponseWorkspace searchFAQ(@RequestHeader(value = "token", defaultValue = "") String token,
//            @RequestBody Ism039Search input) {        
    DtoResponseWorkspace insertPropertie(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody Bst001MstPropertieInsertVo propertieInsertVo) {
 
        return bst001Service.insertPropertie(propertieInsertVo, token);
    }
    
    @PutMapping(value = "update/master",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
//    DtoResponseWorkspace searchFAQ(@RequestHeader(value = "token", defaultValue = "") String token,
//            @RequestBody Ism039Search input) {        
    DtoResponseWorkspace updateMasterDoc(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody Bst001MstDocInsertVo mstInsertVo) {
 
        return bst001Service.editMasterDoc(mstInsertVo, token);
    }
    
    @PutMapping(value = "update/attachment",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
//    DtoResponseWorkspace searchFAQ(@RequestHeader(value = "token", defaultValue = "") String token,
//            @RequestBody Ism039Search input) {        
    DtoResponseWorkspace updateAttachment(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody Bst001MstAttachmentInsertVo attachInsertVo) {
 
        return bst001Service.editAttachment(attachInsertVo, token);
    }
    
    @PutMapping(value = "update/propertie",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
//    DtoResponseWorkspace searchFAQ(@RequestHeader(value = "token", defaultValue = "") String token,
//            @RequestBody Ism039Search input) {        
    DtoResponseWorkspace updatePropertie(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token,
            @RequestBody Bst001MstPropertieInsertVo propertieInsertVo) {
 
        return bst001Service.editPropertie(propertieInsertVo, token);
    }
    
}
