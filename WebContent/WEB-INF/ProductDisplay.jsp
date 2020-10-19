<%@page import="java.util.ArrayList"%>
<%@page import="datamodel.CPU"%>
<%@page import="datamodel.GPU"%>
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
      			<th><b>Manufacturer</b></th>
      			<th><b>Model Name</b></th>
      			<th><b>Number of Cores</b></th>
      			<th><b>Cache Size</b></th> 
      			<th><b></b>Socket Type</th>
   			</tr> 
	         
			<%ArrayList<CPU> cpu =  (ArrayList<CPU>)request.getAttribute("cpus");
			
			for(CPU c : cpu){%>
			<tr>
				<td><%=c.getId()%></td>
				<td><%=c.getManufacturer()%></td> 
				<td><%=c.getModelName()%></td> 
				<td><%=c.getNumOfCores()%></td> 
				<td><%=c.getFreq()%></td> 
				<td><%=c.getSocketCompatibility()%></td>
		    </tr> 
		    <%}%>
    	</table>
        
        <br>
		<h3 align="center">GPUs</h3> 
		<table border ="1" width="500" align="center">
			<tr bgcolor="FFFFFF">
				<th><b>ID</b></th> 
				<th><b>Manufacturer</b></th> 
				<th><b>Model Name</b></th> 
				<th><b></b>Port Type</th> 
				<th><b></b>Interface</th>
				<th><b></b>Memory Size</th>
			</tr> 
		   
			<%ArrayList<GPU> gpu =  (ArrayList<GPU>)request.getAttribute("gpus");
			
			for(GPU g : gpu){%> 
			<tr>
				<td><%=g.getId()%></td>
				<td><%=g.getManufacturer()%></td> 
				<td><%=g.getModelName()%></td> 
				<td><%=g.getPortType()%></td>
				<td><%=g.interfaceType()%></td> 
				<td><%=g.getMemorySize()%></td> 
			</tr> 
			<%}%> 
		</table>
        
        <br>
        <h4 align="center">Hard Drives</h4>
		<table border ="1" width="500" align="center"> 
			<tr bgcolor="FFFFFF">
				<th><b>ID</b></th>
				<th><b>Manufacturer</b></th>
				<th><b>Model Name</b></th> 
				<th><b>Storage Size</b></th> 
				<th><b>RPM</b></th>
			</tr> 
        
			<%ArrayList<Hard_Drive> hd =  (ArrayList<Hard_Drive>)request.getAttribute("hds");
        
			for(Hard_Drive h : hd){%> 
			<tr>
				<td><%=h.getId()%></td> 
				<td><%=h.getManufacturer()%></td>
				<td><%=h.getModelName()%></td> 
				<td><%=h.getStorageSpace()%></td> 
				<td><%=h.getRotationsPerMinute()%></td>  
			</tr> 
			<%}%>
		</table>
          
        <br>
       
        <h5 align="center">Motherboards</h5>
        <table border ="1" width="500" align="center"> 
			<tr bgcolor="FFFFFF">
				<th><b>ID</b></th>
				<th><b>Manufacturer</b></th>
				<th><b>Model Name</b></th>  
				<th><b>Socket Type</b></th> 
				<th><b>Expansion Slots</b></th>
				<th><b>Form Factor</b></th>
			</tr> 
       
       		<%ArrayList<Motherboard> mobo =  (ArrayList<Motherboard>)request.getAttribute("mobos");
        
			for(Motherboard m : mobo){%> 
			<tr> 
				<td><%=m.getId()%></td>
				<td><%=m.getManufacturer()%></td>
				<td><%=m.getModelName()%></td> 
				<td><%=m.getSocket()%></td> 
				<td><%=m.getExpansionSlots()%></td>
				<td><%=m.getForm()%></td>  
			</tr> 
			<%}%>
		</table>
        <hr/> 
    </body> 
</html> 