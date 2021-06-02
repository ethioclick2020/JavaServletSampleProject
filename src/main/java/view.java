

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class view
 */
@WebServlet("/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>View Page</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n"
            		+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
            		+ "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n"
            		+ "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>"
            		+ "<link href=\"css/Style.css\" rel=\"stylesheet\">");
            
            out.println("<style>\r\n"
            		+ "table {\r\n"
            		+ "  font-family: arial, sans-serif;\r\n"
            		+ "  border-collapse: collapse;\r\n"
            		+ "  width: 100%;\r\n"
            		+ "}\r\n"
            		+ "\r\n"
            		+ "td, th {\r\n"
            		+ "  border: 1px solid #dddddd;\r\n"
            		+ "  text-align: left;\r\n"
            		+ "  padding: 8px;\r\n"
            		+ "}\r\n"
            		+ "\r\n"
            		+ "tr:nth-child(even) {\r\n"
            		+ "  background-color: #dddddd;\r\n"
            		+ "}\r\n"
            		+ "</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<nav class=\"navbar navbar-expand-md bg-dark navbar-dark\">\r\n"
            		+ "  <a class=\"navbar-brand\" href=\"#\">Mini Super Market Management System</a>\r\n"
            		+ "  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\">\r\n"
            		+ "    <span class=\"navbar-toggler-icon\"></span>\r\n"
            		+ "  </button>\r\n"
            		+ "  <div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">\r\n"
            		+ "    <ul class=\"navbar-nav ml-auto\">\r\n"
            		+ "      <li class=\"nav-item active\">\r\n"
            		+ "        <a class=\"nav-link\" href=\"index.html\">Home</a>\r\n"
            		+ "      </li>\r\n"
            		+ "      <li class=\"nav-item\">\r\n"
            		+ "        <a class=\"nav-link\" href=\"Add.html\">Add Item</a>\r\n"
            		+ "      </li>\r\n"
            		+ "      <li class=\"nav-item\">\r\n"
            		+ "        <a class=\"nav-link current\" href=\"/MiniSuperMarketManagement/view\">View Item</a>\r\n"
            		+ "      </li>    \r\n"
            		+ "    </ul>\r\n"
            		+ "  </div>  \r\n"
            		+ "</nav>");
            out.println("<h1>List of Items</h1><hr>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Item Name</th>");
            out.println("<th>Price</th>");
            out.println("<th>Description</th>");
            out.println("<th>Reg. Date</th>");
            out.println("</tr>");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ethioclick", "root", "484848");
                String Query = "select * from iteminfo";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(Query);
                while (rs.next()) {
                    out.println("</tr>");
                    out.println("<td>\t\t" + rs.getString("Id") + "</td>");
                    out.println("<td>\t\t" + rs.getString("ItemName") + "</td>");
                    out.println("<td>\t\t" + rs.getString("Price") + "</td>");
                    out.println("<td>\t\t" + rs.getString("Description") + "</td>");
                    out.println("<td>\t\t" + rs.getString("RegDate") + "</td>");
                    out.println("</tr>");
                }
                
            } catch (Exception e) {
                out.print(e.getMessage());
            }
            out.println("</table>");
            out.println("<footer>\r\n"
            		+ "	  All Right Reserved.\r\n"
            		+ "	</footer>");
	        out.println("</body>");
	        out.println("</html>");
        }
	}

}
