
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 
	    Connection conn = null;
	    PreparedStatement ps = null;   
	    PrintWriter out = response.getWriter();
        iteminfo item = new iteminfo();
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        String iname = request.getParameter("ItemName");
        item.setItemname(iname);
        int quantity= Integer.parseInt(request.getParameter("quantity"));
        item.setQuantity(quantity);
        String price = request.getParameter("price");
        item.setPrice(price);
        String desc = request.getParameter("description");
        item.setDescription(desc);
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ethioclick?user=root&password=484848");
            ps = conn.prepareStatement("insert into iteminfo (ItemName ,Quantity ,Price ,Description ,RegDate)"
                    + "values(?,?,?,?,?)");
            ps.setString(1, item.getItemname());
            ps.setInt(2, item.getQuantity());
            ps.setString(3, item.getPrice());
            ps.setString(4, item.getDescription());
            ps.setTimestamp(5, timeStamp);

            ps.executeUpdate();
            response.sendRedirect("/MiniSuperMarketManagement/view");

        } catch (Exception e) {
         out.print(e.getMessage());
        }
	}

}
