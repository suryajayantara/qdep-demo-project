/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.qdep_cashier_demo.form;

import com.dimata.qdep.form.FRMHandler;
import com.dimata.qdep.form.I_FRMInterface;
import com.dimata.qdep.form.I_FRMType;
import com.dimata.qdep_cashier_demo.entity.BillMain;

/**
 *
 * @author suryajayantara
 */
public class FrmBillMain extends FRMHandler implements I_FRMInterface, I_FRMType{

    private BillMain entBillMain;
    public static final String FRM_NAME_BILL_MAIN = "FRM_NAME_BILL_NAME";
    public static final int FRM_FIELD_BILL_OID = 0;
    public static final int FRM_FIELD_BILL_DATE = 1;
    public static final int FRM_FIELD_CASHIER_ID = 2;
    
    public static String[] fieldNames = {
        "FRM_FIELD_BILL_OID",
        "FRM_FIELD_BILL_DATE",
        "FRM_FIELD_CASHIER_ID",
    };
    
    public static int[] fieldTypes = {
        TYPE_LONG,
        TYPE_STRING,
        TYPE_STRING
    };
    
    
    @Override
    public int getFieldSize() {
      return fieldNames.length;  
    }

    @Override
    public String getFormName() {
        return FRM_NAME_BILL_MAIN;
    }

    @Override
    public String[] getFieldNames() {
        return fieldNames;
    }

    @Override
    public int[] getFieldTypes() {
        return fieldTypes;
    }
    
    public void requestEntityObject(BillMain entBillMain){
        try {
            this.requestParam();
            entBillMain.setBillDate(getDate(FRM_FIELD_BILL_DATE));
            entBillMain.setCashierId(getLong(FRM_FIELD_CASHIER_ID));
        } catch (Exception e) {
        }
        
    }
    
    
    
}
