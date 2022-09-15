/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.qdep_cashier_demo.form;

import com.dimata.qdep.db.DBException;
import com.dimata.qdep.form.Control;
import com.dimata.qdep.system.I_DBExceptionInfo;
import com.dimata.qdep_cashier_demo.entity.BillMain;
import com.dimata.qdep_cashier_demo.entity.PstBillMain;
import com.dimata.util.Command;
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
    public static int RSLT_EST_CODE_EXIST = 2;
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
    private BillMain entBillMain;
    private PstBillMain pstBillMain;

    /* 
    
    Pada Contstructor diberikan params servlet, buat apa ?
    Servlet ini gunanya untuk ngambil body dari response form 
     
     */
    public CtrlBillMain(HttpServletResponse response) {
        msgString = "";
        entBillMain = new BillMain();

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
    private int getControlMsgId(int msgCode) {
        switch (msgCode) {
            case I_DBExceptionInfo.MULTIPLE_ID:
                return RSLT_EST_CODE_EXIST;
            default:
                return RSLT_UNKNOWN_ERROR;
        }
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public BillMain getBillMain() {
        return entBillMain;
    }

//    public F getForm() {
//        return frmDivisi;
//    }
    public String getMessage() {
        return msgString;
    }

    public int getStart() {
        return start;
    }

    /*
        Action Method
    
        Method ini berguna untuk melakukan proses CRUD, proses akan dilakukan 
        berdasarkan command yang dikirimkan ke dalam parameter
     */
    public int action(int cmd, long oidBillMain, long userId, String userName) {
        msgString = "";
        int excCode = I_DBExceptionInfo.NO_EXCEPTION;
        int rsCode = RSLT_OK;

        switch (cmd) {

            case Command.ADD:
                break;

            /*
                 
                Command SAVE
                 
                Case ini berjalan ketika command save dipanggil, command ini berfungsi untuk melakukan
                saving data
             */
            case Command.SAVE:
                   if(oidBillMain != 0){
                       try {
                           entBillMain = PstBillMain.fetchExc(oidBillMain);
                       } catch (Exception e) {
                       }
                   }
                   
                   
                   
                   
                break;

            /*
                 
                 Command EDIT
                 
                Case ini berjalan ketika command save dipanggil, command ini berfungsi untuk melakukan
                 editing pada data
             */
            case Command.EDIT:
                break;

            /*
                 
                Command ASK
                 
                Case ini berjalan ketika command save dipanggil, command ini berfungsi untuk melakukan
                 Memanggil Message ketika edit 
             */
            case Command.ASK:
                break;

            /*
                 
                 Command Edit
                 
                Case ini berjalan ketika command save dipanggil, command ini berfungsi untuk melakukan
                Delete pada data
             */
            case Command.DELETE:
                break;
            default:
        }

        return rsCode;

    }

}
