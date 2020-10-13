import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.CPU;
import datamodel.Hard_Drive;
import datamodel.Motherboard;

/**
 * Servlet implementation class DispalyServlet
 */
@WebServlet("/DispalyServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	try (PrintWriter out = response.getWriter()) {
    		out.println("<!DOCTYPE html>"); 
    	    out.println("<html>"); 
    	    out.println("<head>"); 
    	    out.println("<title>Servlet DisplayServlet</title>"); 
    	    out.println("</head>"); 
    	    out.println("<body>");
    	    
    		ArrayList<CPU> cpus = new ArrayList<CPU>();
    		ArrayList<Hard_Drive> hds = new ArrayList<Hard_Drive>();
    		ArrayList<Motherboard> mobos = new ArrayList<Motherboard>();
    		
    		cpus.add(new CPU(1, "4", "4mb", "LGA"));
    		cpus.add(new CPU(2, "8", "4mb", "PGA"));
    		cpus.add(new CPU(3, "8", "8mb", "LGA"));
    		
    		hds.add(new Hard_Drive(1, "500gb", "5400"));
    		hds.add(new Hard_Drive(2, "1tb", "7200"));
    		hds.add(new Hard_Drive(3, "750gb", "6400"));
    		
    		mobos.add(new Motherboard(1, "PGA", "Standard-ATX"));
    		mobos.add(new Motherboard(2, "LGA", "Micro-ATX"));
    		mobos.add(new Motherboard(3, "PGA", "Mini-ITX"));
    		
    		request.setAttribute("cpus", cpus);
    		request.setAttribute("hds", hds);
    		request.setAttribute("mobos", mobos);
		
    		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ProductDisplay.jsp");
    		rd.forward(request, response);
    		
    		out.println("</body>");
    		out.println("</html");
    	}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
