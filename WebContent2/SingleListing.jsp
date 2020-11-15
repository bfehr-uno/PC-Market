<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datamodel2.*"%>
<%@page import="util2.UtilDBPCMarket"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/SingleListing.css">
	</head>
	<jsp:include page="MenuBar.jsp" />
	<div class="container">
		<div class="listing">
			<%
			String listinginfo = request.getParameter("listinginfo");
			String listingInfo[] = listinginfo.split(",");
			String id = listingInfo[0];
			String partType = listingInfo[2];
			
			if (partType.equals("CPU")) {
				CPU cpu = UtilDBPCMarket.getCPU(id);
				%>
				<div class="leftside">
					<div class="cpu-model"><%=cpu.getManufacturer() + " " + cpu.getModelName()%></div>
					<div class="cpu-cores">Number of Cores: <%=cpu.getNumOfCores() %></div>
					<div class="cpu-freq">Frequency: <%=cpu.getFreq()%> gHz</div>
					<div class="cpu-socket">Socket Compatibility: <%=cpu.getSocketCompatibility() %></div>
				</div>
				<div class="rightside">
					<div class="image"><img class="part" src="photos/genericcpu.jpg"></div>
					<div class="purchase"><%=cpu.getPrice() %><a href="PurchaseConfirmation.jsp?listinginfo=<%=id + ',' + cpu.getModelName() + ',' + partType + ',' + cpu.getPrice()%>"><button>purchase</button></a></div>
				</div>
			<%
			} else if (partType.equals("GPU")) {
				GPU gpu = UtilDBPCMarket.getGPU(id);%>
				<div class="leftside">
					<div class="gpu-model"><%=gpu.getManufacturer() + " " + gpu.getModelName()%></div>
					<div class="gpu-clockspeed">Clock Speed: <%=gpu.getClockSpeed() %></div>
					<div class="gpu-interface">Interface Type: <%=gpu.getInterfaceType()%></div>
					<div class="gpu-memory">Memory Size: <%=gpu.getMemorySize() %></div>
				</div>
				<div class="rightside">
					<div class="image"><img class="part" src="photos/genericgpu.jpg"></div>
					<div class="purchase"><%=gpu.getPrice() %><a href="PurchaseConfirmation.jsp?listinginfo=<%=id + ',' + gpu.getModelName() + ',' + partType + ',' + gpu.getPrice()%>"><button>purchase</button></a></div>
				</div>
			<%
			} else if (partType.equals("Hard Drive")) {
				Hard_Drive hardDrive = UtilDBPCMarket.getHardDrive(id);%>
				<div class="leftside">
					<div class="harddrive-model"><%=hardDrive.getManufacturer() + " " + hardDrive.getModelName()%></div>
					<div class="harddrive-storage">Storage Space: <%=hardDrive.getStorageSpace() %></div>
					<div class="harddrive-rpm">Rotations per Minute: <%=hardDrive.getRotationsPerMinute()%> gHz</div>
				</div>
				<div class="rightside">
					<div class="image"><img class="part" src="photos/genericharddrive.jpg"></div>
					<div class="purchase"><%=hardDrive.getPrice() %><a href="PurchaseConfirmation.jsp?listinginfo=<%=id + ',' + hardDrive.getModelName() + ',' + partType + ',' + hardDrive.getPrice()%>"><button>purchase</button></a></div>
				</div>
			<%
			} else {
				Motherboard motherboard = UtilDBPCMarket.getMotherboard(id);%>
				<div class="leftside">
					<div class="motherboard-model"><%=motherboard.getManufacturer() + " " + motherboard.getModelName()%></div>
					<div class="motherboard-socket">Socket Type: <%=motherboard.getSocket() %></div>
					<div class="motherboard-expansion">Expansion Slots: <%=motherboard.getExpansionSlots()%> gHz</div>
				</div>
				<div class="rightside">
					<div class="image"><img class="part" src="photos/genericmotherboard.jpg"></div>
					<div class="purchase"><%=motherboard.getPrice() %><a href="PurchaseConfirmation.jsp?listinginfo=<%=id + ',' + motherboard.getModelName() + ',' + partType + ',' + motherboard.getPrice()%>"><button>purchase</button></a></div>
				</div>
			<%}%>
		</div>
	</div>
</html>