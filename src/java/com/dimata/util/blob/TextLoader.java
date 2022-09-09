/* Generated by Together */

package com.dimata.util.blob;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class TextLoader {

    
    private SmartUpload smartUploader = new SmartUpload();
    private Hashtable hsFiles = new Hashtable(); 	// key -> html_field_name(String), val -> Object_of_byte[](Object array of bayte)
    
    
    public TextLoader() { 
    }
    
 
    public int uploadText(ServletConfig conf, HttpServletRequest req, HttpServletResponse res) {
        try {
            smartUploader.initialize(conf, req, res);
            smartUploader.upload();
            return composeText();
        }catch(Exception e) {
            System.out.println("TextLoader.upload() " + e.toString());
            return 0;
        }
    }
     

    
    // get the real data from the http binary package
    private int composeText() {
        try {
            com.dimata.util.blob.Files hsBlobFiles = smartUploader.getFiles();
            System.out.println("Number of uploaded file......>> " + hsBlobFiles.getCount());
            
            for(int i = 0; i < hsBlobFiles.getCount(); i++) {
                com.dimata.util.blob.File upFile = hsBlobFiles.getFile(i);
                
                // end/start index refer to http byte data
                // substract it, to find the real data index
                int fSize = upFile.getEndData() - upFile.getStartData();
                String type = upFile.getSubTypeMIME();
                

                byte[] realBytes = new byte[fSize + 1];
                for(int j = 0;  j < fSize; j++) {
                    realBytes[j] = upFile.getBinaryData(j);
                }

                // fieldName is the field name object contaiting
                // from html fo file to be uploaded from html
                // e.g. <input type="file" name="field_name" value="">
                // field_name is fieldName
                String key = upFile.getFieldName();
                Object obj = (Object) realBytes;

                hsFiles.put(key, obj); // put byte[] object
                
            } // end for;
            
            return 0;
        } catch(Exception e){
            System.out.println("TextLoader.composeText() " + e.toString());
            return -1;
        }
    }
    


    
    public Object getTextFile(String key) {
        Object obj = (Object)hsFiles.get(key);
        return obj;
    }    
    
    
    public static int deleteChace(String absolutePath) {        
        java.io.File flImg = new java.io.File(absolutePath);
        if(flImg.exists())
            flImg.delete();
        return 0;
    }    
    
 
    public static int writeCache(InputStream ins, String fileName, boolean replace) {
        if(ins == null) return -1;
        
        java.io.File fileImg = new java.io.File(fileName);
        if(replace) {
            if(fileImg.exists()) fileImg.delete();
        }else{
            if(fileImg.exists()) return 0;
        }
        
        try{
            int size = ins.available() + 1;
            byte[] b = new byte[size];
            
            int objSize = ins.read(b);
            if(objSize < 1) return -1;
            
            FileOutputStream imgOut = null;
            imgOut = new FileOutputStream(fileImg);
            imgOut.write(b);
            
            return 0;
            
        }catch (Exception exc) {
            System.out.println("TextLoader.writeCache() " + exc.toString());
        }
        return -1;
    }

    
    
} // end of TextLoader