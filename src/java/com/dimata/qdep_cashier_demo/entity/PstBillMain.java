/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.qdep_cashier_demo.entity;

import com.dimata.qdep.db.DBException;
import com.dimata.qdep.db.DBHandler;
import com.dimata.qdep.db.I_DBInterface;
import com.dimata.qdep.db.I_DBType;
import com.dimata.qdep.entity.Entity;
import com.dimata.qdep.entity.I_PersintentExc;

/**
 *
 * @author suryajayantara
 */
public class PstBillMain extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc{
    
    // untuk penanda ini table apa
    public static final String TBL_BILL_MAIN = "mq_bill_main";
    
    //field yang di isi
    public static final int FLD_BILL_MAIN_ID = 0;
    public static final int FLD_BILL_DATE = 1;
    public static final int FLD_BILL_NUMBER = 2;
    public static final int FLD_CASHIER_ID = 3;
    
    public static final String[] fieldNames = {
        "BILL_MAIN_ID",
        "BILL_DATE",
        "BILL_NUMBER",
        "CASHIER_ID",
    };
    
    public static int[] fieldTypes = {
        TYPE_PK + TYPE_LONG + TYPE_ID,
        TYPE_DATE,
        TYPE_STRING,
        TYPE_LONG + TYPE_PK,
    };
    
    // Constructor
    
    public PstBillMain() {
    }
    
    public PstBillMain(int i) throws DBException {
        super(new PstBillMain());
    }
    
    public PstBillMain(String sOid) throws DBException {
        super(new PstBillMain(0));
        if (!locate(sOid))
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        else
            return;
    }
    
    public PstBillMain(long lOid) throws DBException {
        super(new PstBillMain(0));
        String sOid = "0";
        try {
            sOid = String.valueOf(lOid);
        } catch(Exception e) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        if (!locate(sOid))
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        else
            return;
    }
    
    
    // Abstract dari 
    @Override
    public int getFieldSize() {
        return fieldNames.length; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTableName() {
        return TBL_BILL_MAIN; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getFieldNames() {
        return fieldNames; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] getFieldTypes() {
        return fieldTypes; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPersistentName() {
        return new PstBillMain().getClass().getName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long fetchExc(Entity ent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long updateExc(Entity ent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long deleteExc(Entity ent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long insertExc(Entity ent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public long insertExc(BillMain billMain) throws Exception {
         try {
            PstBillMain pstBillMain = new PstBillMain(0);
            pstBillMain.setDate(FLD_BILL_DATE, billMain.getBillDate());
            pstBillMain.setString(FLD_BILL_NUMBER, billMain.getBillNumber());
            pstBillMain.setLong(FLD_CASHIER_ID, billMain.getCashierId());
            
            pstBillMain.insert();
            
            
            billMain.setOID(pstBillMain.getLong(FLD_BILL_MAIN_ID));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstBillMain(0), DBException.UNKNOWN);
        }
        return billMain.getOID(); 
    }
    
    
    
}
