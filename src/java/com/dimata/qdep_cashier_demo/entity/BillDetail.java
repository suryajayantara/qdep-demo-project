/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.qdep_cashier_demo.entity;

import com.dimata.qdep.entity.Entity;

/**
 *
 * @author suryajayantara
 */
public class BillDetail extends Entity{
    
    private int itemIndex = 0;
    private String itemName = null;
    private float itemQuantity = 0;
    private String itemPrice = null;

    /**
     * @return the itemIndex
     */
    public int getItemIndex() {
        return itemIndex;
    }

    /**
     * @param itemIndex the itemIndex to set
     */
    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemQuantity
     */
    public float getItemQuantity() {
        return itemQuantity;
    }

    /**
     * @param itemQuantity the itemQuantity to set
     */
    public void setItemQuantity(float itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /**
     * @return the itemPrice
     */
    public String getItemPrice() {
        return itemPrice;
    }

    /**
     * @param itemPrice the itemPrice to set
     */
    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
    
    
}
