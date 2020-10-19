import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Motherboard;
import datamodel.CPU;
import datamodel.GPU;
import datamodel.Hard_Drive;
import util.UtilDBPCMarket;

@WebServlet("/PCMarketServlet")
public class PCMarketServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public PCMarketServlet() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      
      List<Motherboard> listMobos = UtilDBPCMarket.listMotherboard();
      for (Motherboard mobos : listMobos) {
          System.out.println("<li>" + mobos.getId() + ", " //
        		  + mobos.getManufacturer() + ", " //
        		  + mobos.getModelName() + ", " //
        		  + mobos.getSocket() + ", " //
        		  + mobos.getExpansionSlots() + ", " //
        		  + mobos.getForm() + "</li>");
      }
      List<CPU> listCPUs = UtilDBPCMarket.listCPU();
      for (CPU cpus : listCPUs) {
          System.out.println("<li>" + cpus.getId() + ", " //
        		  + cpus.getManufacturer() + ", " //
        		  + cpus.getModelName() + ", " //
        		  + cpus.getNumOfCores() + ", " //
        		  + cpus.getFreq() + ", " //
        		  + cpus.getSocketCompatibility() + "</li>");
      }
      List<GPU> listGPUs = UtilDBPCMarket.listGPU();
      for (GPU gpus : listGPUs) {
          System.out.println("<li>" + gpus.getId() + ", " //
        		  + gpus.getManufacturer() + ", " //
        		  + gpus.getModelName() + ", " //
        		  + gpus.getPortType() + ", " //
        		  + gpus.getInterfaceType() + ", " //
        		  + gpus.getMemorySize() + "</li>");
      }
      List<Hard_Drive> listDrives = UtilDBPCMarket.listHardDrive();
      for (Hard_Drive drives : listDrives) {
          System.out.println("<li>" + drives.getId() + ", " //
        		  + drives.getManufacturer() + ", " //
        		  + drives.getModelName() + ", " //
        		  + drives.getStorageSpace() + ", " //
        		  + drives.getRotationsPerMinute() + "</li>");
      }
      out.println("</ul>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
