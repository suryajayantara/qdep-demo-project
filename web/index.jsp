<%-- 
    Document   : index
    Created on : Sep 8, 2022, 5:46:36 PM
    Author     : suryajayantara
--%>


<%@page import="java.util.Date"%>
<%@page import="com.dimata.qdep_cashier_demo.entity.PstBillMain"%>
<%@page import="com.dimata.qdep_cashier_demo.entity.BillMain"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1> <% 
                
            BillMain billMain = new BillMain();
            
            billMain.setBillNumber("123");
            billMain.setCashierId(1);
            billMain.setBillDate(new Date());
            PstBillMain pstBillMain = new PstBillMain();
//            
//            try {
//                    pstBillMain.insertExc(billMain);
//                } catch (Exception e) {
//                    throw e;
//                }
//            
            %> </h1>
            
            
            <div> </div>
    </body>
</html>
