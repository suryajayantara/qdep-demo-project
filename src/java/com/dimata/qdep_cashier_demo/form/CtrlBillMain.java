/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.qdep_cashier_demo.form;

import com.dimata.qdep.db.DBException;
import com.dimata.qdep.form.Control;
import com.dimata.qdep_cashier_demo.entity.BillMain;
import com.dimata.qdep_cashier_demo.entity.PstBillMain;
import com.dimata.util.lang.I_Language;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author suryajayantara
 */
public class CtrlBillMain extends Control implements I_Language {

    
    /* 
        Enumerasi bagian massages 
     */
    public static int RSLT_OK = 0;
    public static int RSLT_UNKNOWN_ERROR = 1;
    public static int RSLT_OID_CODE_EXIST = 2;
    public static int RSLT_FORM_INCOMPLETE = 3;

    public static String[][] resultText = {
        {"Berhasil", "Tidak dapat diproses", "NoPerkiraan sudah ada", "Data tidak lengkap"},
        {"Succes", "Can not process", "Estimation code exist", "Data incomplete"}
    };

    private int start;
    private String msgString;
    int language = LANGUAGE_DEFAULT;

    /* 
        Bagian Koneksi ke Database 
     */
    private BillMain billMain;
    private PstBillMain pstBillMain;

    
    
    /* 
    
    Pada Contstructor diberikan params servlet, buat apa ?
    Servlet ini gunanya untuk ngambil body dari response form 
     
     */
    public CtrlBillMain(HttpServletResponse response) {
        msgString = "";
        billMain = new BillMain();

        // eksekusi 
        try {
            pstBillMain = new PstBillMain(0);
        } catch (DBException e) {
            
        }
    }
    
    /* 
    
    Pada Contstructor diberikan params servlet, buat apa ?
    Servlet ini gunanya untuk ngambil body dari response form 
     
     */
    
    
    
    
    

}
