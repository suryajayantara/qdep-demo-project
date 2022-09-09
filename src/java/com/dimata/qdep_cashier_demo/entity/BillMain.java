/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.qdep_cashier_demo.entity;

import com.dimata.qdep.entity.Entity;
import java.util.Date;

/**
 *
 * @author suryajayantara
 */
public class BillMain extends Entity{
    
    private Date billDate = null;
    private String billNumber = null;
    private long cashierId = 0;

    /**
     * @return the billDate
     */
    public Date getBillDate() {
        return billDate;
    }

    /**
     * @param billDate the billDate to set
     */
    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    /**
     * @return the billNumber
     */
    public String getBillNumber() {
        return billNumber;
    }

    /**
     * @param billNumber the billNumber to set
     */
    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    /**
     * @return the cashierId
     */
    public long getCashierId() {
        return cashierId;
    }

    /**
     * @param cashierId the cashierId to set
     */
    public void setCashierId(long cashierId) {
        this.cashierId = cashierId;
    }
    
    
}
