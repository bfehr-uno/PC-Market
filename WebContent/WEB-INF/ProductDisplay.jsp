<%@page import="datamodel.CPU"%> 
<%@page import="java.util.ArrayList"%>
<%@page import="datamodel.Hard_Drive"%>
<%@page import="datamodel.Motherboard"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
  <head> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
   <title>Product List</title> 
  </head> 
  <body> 
      <h1 align="center">PC-Market Product List</h1>
      <br>
      <h2 align="center">CPUs</h2> 
      <table border ="1" width="500" align="center"> 
         <tr bgcolor="FFFFFF">
          <th><b>ID</b></th> 
          <th><b>Number of Cores</b></th> 
          <th><b>Cache Size</b></th> 
          <th><b></b>Socket Type</th> 
         </tr> 
         
        <%ArrayList<CPU> cpu =  (ArrayList<CPU>)request.getAttribute("cpus");
        
        for(CPU c : cpu){%> 
            <tr> 
            	<td><%=c.getId()%></td>
                <td><%=c.getNumOfCores()%></td> 
                <td><%=c.getCacheSize()%></td> 
                <td><%=c.getSocketCompatibility()%></td> 
            </tr> 
            <%}%> 
        </table>
        
        <br>
        <h3 align="center">Hard Drives</h3>
        <table border ="1" width="500" align="center"> 
         <tr bgcolor="FFFFFF">
         <th><b>ID</b></th> 
          <th><b>Storage Size</b></th> 
          <th><b>RPM</b></th>  
         </tr> 
        
        <%ArrayList<Hard_Drive> hd =  (ArrayList<Hard_Drive>)request.getAttribute("hds");
        
        for(Hard_Drive h : hd){%> 
            <tr>
            	<td><%=h.getId()%></td> 
                <td><%=h.getStorageSpace()%></td> 
                <td><%=h.getRotationsPerMinute()%></td>  
            </tr> 
            <%}%> 
        </table>
          
        <br>
       
        <h4 align="center">Motherboards</h4>
        <table border ="1" width="500" align="center"> 
         <tr bgcolor="FFFFFF">
          <th><b>ID</b></th> 
          <th><b>Socket Type</b></th> 
          <th><b>Form Factor</b></th>  
         </tr> 
       
        <%ArrayList<Motherboard> mobo =  (ArrayList<Motherboard>)request.getAttribute("mobos");
        
        for(Motherboard m : mobo){%> 
            <tr> 
            	<td><%=m.getId()%></td>
                <td><%=m.getSocket()%></td> 
                <td><%=m.getForm()%></td>  
            </tr> 
            <%}%> 
        </table>
        <hr/> 
    </body> 
</html> 