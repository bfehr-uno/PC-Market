<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datamodel2.*"%>
<%@page import="util2.BuyUtil, util2.UtilDBPCMarket"%>
<%@page import="java.util.ArrayList"%>
<%
Integer userID = (Integer) session.getAttribute("userID");
String partType = null;
Integer partID = null;
String previousPage = request.getHeader("referer");
if (previousPage.endsWith("EasyBuy.jsp")) {
	partType = request.getParameter("partType");
	if (partType.equals("CPU")) {
		String cores = request.getParameter("cores");
		String frequency = request.getParameter("frequency");
		String socket = request.getParameter("socket");
		partID = BuyUtil.easyBuyCPU(cores, frequency, socket);
	} else if (partType.equals("GPU")) {
		String clockSpeed = request.getParameter("clockSpeed");
		String interf = request.getParameter("interf");
		String memory = request.getParameter("memory");
		partID = BuyUtil.easyBuyGPU(clockSpeed, interf, memory);
	} else if (partType.equals("Hard Drive")) {
		String storage = request.getParameter("storage");
		String rpm = request.getParameter("rpm");
		partID = BuyUtil.easyBuyHardDrive(storage, rpm);
	} else if (partType.equals("Motherboard")) {
		String socket = request.getParameter("socket");
		String expansion = request.getParameter("expansion");
		partID = BuyUtil.easyBuyMotherboard(socket, expansion);
	} else {
		String type = request.getParameter("type");
		String capacity = request.getParameter("capacity");
		String speed = request.getParameter("speed");
		partID = BuyUtil.easyBuyRAM(type, capacity, speed);  
	}
} else {
	String listingInfo1 = request.getParameter("listing");
	String[] listingInfo2 = listingInfo1.split(",");
	partType = listingInfo2[0];
	partID = Integer.parseInt(listingInfo2[1]);
}
%>
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
			if (partType.equals("CPU")) {
				CPU cpu = UtilDBPCMarket.getCPU(partID);
			%>
				<div class="leftside">
					<div class="cpu-model">Model Name: <%=cpu.getModelName()%></div>
					<div class="cpu-cores">Number of Cores: <%=cpu.getNumOfCores() %> Cores</div>
					<div class="cpu-freq">Frequency: <%=cpu.getFreq()%> gHz</div>
					<div class="cpu-socket">Socket Compatibility: <%=cpu.getSocketCompatibility() %></div>
				</div>
				<div class="rightside">
					<div class="image"><img class="part" src="photos/genericcpu.jpg"></div>
					<% if (userID != null) {%>
						<div class="purchase">$<%=cpu.getPrice() %><a href="PurchaseConfirmation.jsp?listinginfo=<%=partType + "," + partID + "," + cpu.getPrice()%>"><button>purchase</button></a></div>
					<%} else {%>
						<div class="purchase">$<%=cpu.getPrice() %><button>purchase</button></div>
						<div>You must login to be able to buy parts</div>
					<%} %>
				</div>
			<%
			} else if (partType.equals("GPU")) {
				GPU gpu = UtilDBPCMarket.getGPU(partID);
			%>
				<div class="leftside">
					<div class="gpu-model">Model Name: <%=gpu.getModelName()%></div>
					<div class="gpu-clockspeed">Clock Speed: <%=gpu.getClockSpeed() %> MHz</div>
					<div class="gpu-interface">Interface Type: <%=gpu.getInterfaceType()%></div>
					<div class="gpu-memory">Memory Size: <%=gpu.getMemorySize() %> GB</div>
				</div>
				<div class="rightside">
					<div class="image"><img class="part" src="photos/genericgpu.jpg"></div>
					<% if (userID != null) {%>
						<div class="purchase">$<%=gpu.getPrice() %><a href="PurchaseConfirmation.jsp?listinginfo=<%=partType + "," + partID + "," + gpu.getPrice()%>"><button>purchase</button></a></div>
					<%} else {%>
						<div class="purchase">$<%=gpu.getPrice() %><button>purchase</button></div>
						<div>You must login to be able to buy parts</div>
					<%} %>
				</div>
			<%
			} else if (partType.equals("Hard Drive")) {
				Hard_Drive hardDrive = UtilDBPCMarket.getHardDrive(partID);
			%>
				<div class="leftside">
					<div class="harddrive-model">Model Name: <%=hardDrive.getModelName()%></div>
					<div class="harddrive-storage">Storage Space: <%=hardDrive.getStorageSpace() %> TB</div>
					<div class="harddrive-rpm">Rotations per Minute: <%=hardDrive.getRotationsPerMinute()%></div>
				</div>
				<div class="rightside">
					<div class="image"><img class="part" src="photos/genericharddrive.jpg"></div>
					<% if (userID != null) {%>
						<div class="purchase">$<%=hardDrive.getPrice() %><a href="PurchaseConfirmation.jsp?listinginfo=<%=partType + "," + partID + "," + hardDrive.getPrice()%>"><button>purchase</button></a></div>
					<%} else {%>
						<div class="purchase">$<%=hardDrive.getPrice() %><button>purchase</button></div>
						<div>You must login to be able to buy parts</div>
					<%} %>
				</div>
			<%
			} else if (partType.equals("Motherboard")){
				Motherboard motherboard = UtilDBPCMarket.getMotherboard(partID);
				String[] expansionSlotsList = motherboard.getExpansionSlots().split(",");
				String expansionSlots = ""; 
				for (String s : expansionSlotsList) {
					expansionSlots += "PCI Express " + s + ", ";
				}
				System.out.println(expansionSlots);
				expansionSlots = expansionSlots.substring(0, expansionSlots.length() - 2);
			%>
				<div class="leftside">
					<div class="motherboard-model">Model Name: <%=motherboard.getModelName()%></div>
					<div class="motherboard-socket">Socket Type: <%=motherboard.getSocket() %></div>
					<div class="motherboard-expansion">Expansion Slots: <%=expansionSlots%></div>
				</div>
				<div class="rightside">
					<div class="image"><img class="part" src="photos/genericmotherboard.jpg"></div>
					<% if (userID != null) {%>
						<div class="purchase">$<%=motherboard.getPrice() %><a href="PurchaseConfirmation.jsp?listinginfo=<%=partType + "," + partID + "," + motherboard.getPrice()%>"><button>purchase</button></a></div>
					<%} else {%>
						<div class="purchase">$<%=motherboard.getPrice() %><button>purchase</button></div>
						<div>You must login to be able to buy parts</div>
					<%} %>
				</div>
			<%} else {
				RAM ram = UtilDBPCMarket.getRAM(partID);
			%>
				<div class="leftside">
					<div class="motherboard-model">Model Name: <%=ram.getModelName()%></div>
					<div class="motherboard-socket">Type: <%=ram.getType()%></div>
					<div class="motherboard-expansion">Capacity: <%=ram.getCapacity()%></div>
				</div>
				<div class="rightside">
					<div class="image"><img class="part" src="photos/genericmotherboard.jpg"></div>
					<% if (userID != null) {%>
						<div class="purchase">$<%=ram.getPrice() %><a href="PurchaseConfirmation.jsp?listinginfo=<%=partType + "," + partID + "," + ram.getPrice()%>"><button>purchase</button></a></div>
					<%} else {%>
						<div class="purchase">$<%=ram.getPrice() %><button>purchase</button></div>
						<div>You must login to be able to buy parts</div>
					<%} %>
				</div>
			<%} %>
		</div>
	</div>
</html>