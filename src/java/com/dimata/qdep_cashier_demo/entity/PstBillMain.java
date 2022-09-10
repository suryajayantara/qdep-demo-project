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
public class PstBillMain extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc {

    // TBL_TABLE_NAME => static variable yang menyimpan nama table yang akan diguanakan untuk menyimpan data
    public static final String TBL_BILL_MAIN = "mq_bill_main";

    /*
        FIELD INITIATION 
    
        Proses Inisiasi nama kolom yang akan digunakan, ini akan merepresentasikan 
        kolom yang akan dipanggil saat nanti
        
        Format inisiasi variable : 
        public static final int FLD_FIELD_NAME_SATU = 0
        public static final int FLD_FIELD_NAME_DUA = 1
     */
    public static final int FLD_BILL_MAIN_ID = 0;
    public static final int FLD_BILL_DATE = 1;
    public static final int FLD_BILL_NUMBER = 2;
    public static final int FLD_CASHIER_ID = 3;

    /*
        FIELD Name
        
        Fieldname sendiri merupakan variable array yang menyimpan nama dari 
        kolom yang terdapat di database,nilai pada variable FLD akan merepresentasikan 
        index pada array ini sendiri 
     */
    public static final String[] fieldNames = {
        "BILL_MAIN_ID",
        "BILL_DATE",
        "BILL_NUMBER",
        "CASHIER_ID",};

    /*
        FIELD Type
        
        Fieldname sendiri merupakan variable array yang tipe Data dari 
        kolom yang terdapat di database,nilai pada variable FLD akan merepresentasikan 
        index pada array ini sendiri 
    
     */
    public static int[] fieldTypes = {
        TYPE_PK + TYPE_LONG + TYPE_ID,
        TYPE_DATE,
        TYPE_STRING,
        TYPE_LONG + TYPE_PK,};

    /*
        Constructor 
    
        Constructor merupakan fungsi yang akan dijalankan pertama kali ketika 
        class di intialisasi / ketika object di buat. terdapat beberapa constructor 
        yang akan berjalan sesuai dengan parameter yang dikirimkan pertama kali
     */
    public PstBillMain() {
    }

    public PstBillMain(int i) throws DBException {
        super(new PstBillMain());
    }

    public PstBillMain(String sOid) throws DBException {
        super(new PstBillMain(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstBillMain(long lOid) throws DBException {
        super(new PstBillMain(0));
        String sOid = "0";
        try {
            sOid = String.valueOf(lOid);
        } catch (Exception e) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    /*
        UTILITY FUNCTION
        
        Tugas dari utility function sendiri adalah untuk membantu developer 
        dalam mendapatkan metadata dari Persistance itu sendiri
    
        List Function 
        - getFieldSize => berguna untuk mendapatkan jumlah dari field yang akan di input
        - getTableName => berguna untuk mendapatkan nama dari table yang terkoneksi ke persistance 
        - getFieldNames => berguna untuk mendapatkan field apa saja yang ada dalam persistance ( berdasarkan column di table)
        - getFieldTypes => berguna untuk mendapatkan tipe dari field yang akan di inputkan
        - getPersistentName => berguna untuk mendapatkan nama dari persistance itu sendiri
     */
    @Override
    public int getFieldSize() {
        return fieldNames.length;
    }

    @Override
    public String getTableName() {
        return TBL_BILL_MAIN;
    }

    @Override
    public String[] getFieldNames() {
        return fieldNames;
    }

    @Override
    public int[] getFieldTypes() {
        return fieldTypes;
    }

    @Override
    public String getPersistentName() {
        return new PstBillMain().getClass().getName();
    }

    // CRUD FUNCTION

    /*
            Fetch Method [DB Interface]

            Method yang digunakan untuk mengambil data dari database
     */
    @Override
    public long fetchExc(Entity ent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /*
            Update Method [DB Interface]

            Method yang digunakan untuk mengupdate data berdasarkan id/oid 
     */
    @Override
    public long updateExc(Entity ent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /*
            Delete Method / Destroy Method [DB Interface]

            Method yang digunakan untuk menghapus data berdasarkan id/oid 
            *Note : gunakan method yang parameternya Entity yang kalian buat , bukan yang @Override
     */
    @Override
    public long deleteExc(Entity ent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long deleteExc(long oid) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /*
    
        Create Method / Insert Method [DB Interface]

        Method yang digunakan untuk memasukan data kedalam database
        *Note : gunakan method yang parameternya Entity yang kalian buat , bukan yang @Override
        
     */
    @Override
    public long insertExc(Entity ent) throws Exception {
        return insertExc((BillDetail) ent);
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
