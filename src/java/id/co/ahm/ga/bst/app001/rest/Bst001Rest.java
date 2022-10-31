/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.ahm.ga.bst.app001.rest;

import id.co.ahm.ga.bst.app001.service.Bst001Service;
import id.co.ahm.ga.bst.app001.vo.Bst001MstDocFilterVo;
import id.co.ahm.jxf.constant.CommonConstant;
import id.co.ahm.jxf.dto.DtoResponseWorkspace;
import id.co.ahm.jxf.security.TokenPstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
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
    
    @RequestMapping(value = "list", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
//    DtoResponseWorkspace searchFAQ(@RequestHeader(value = "token", defaultValue = "") String token,
//            @RequestBody Ism039Search input) {        
    DtoResponseWorkspace getList(@RequestHeader(value = CommonConstant.JXID, defaultValue = "") String token) {
 
        return bst001Service.getListMasterDocument();
    }
    
    @RequestMapping(value = "list/search", method = RequestMethod.POST,
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
    
}
