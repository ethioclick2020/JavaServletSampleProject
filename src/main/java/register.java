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


@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn = null;
    PreparedStatement ps = null;     
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
        userinfo user = new userinfo();
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        String fname = request.getParameter("fname");
        user.setFirstName(fname);
        String lname = request.getParameter("lname");
        user.setLasteName(lname);
        String email = request.getParameter("email");
        user.setEmail(email);
        String pw = request.getParameter("password");
        user.setPassword(pw);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ethioclick?user=root&password=484848");
            //conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement("insert into userinfo (FirstName ,LastName ,Email ,Password ,RegDate)"
                    + "values(?,?,?,?,?)");
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLasteName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setTimestamp(5, timeStamp);

            ps.executeUpdate();
            response.sendRedirect("welcome.html");

        } catch (Exception e) {
         out.print(e.getMessage());
        }
	}

}
