package secure_user_registration_system;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/reg_form")
public class register_back_code extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		// 🔹 Get form data
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phoneStr = req.getParameter("phone");
		String dob = req.getParameter("dob");
		String ageStr = req.getParameter("age");
		String aadharStr = req.getParameter("aadhar");
		String password = req.getParameter("pass");

		// 🔹 Convert data types
		long phone = Long.parseLong(phoneStr);
		int age = Integer.parseInt(ageStr);
		long aadhar = Long.parseLong(aadharStr);

		// 🔹 Response to browser
		PrintWriter output = res.getWriter();


		try {
			// 🔹 Load MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 🔹 Create Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register_db", "Private", "PRpr@9715");

			// 🔹 Prepare SQL Query
			String query = "INSERT INTO regi(name, email, phone, dob, age, aadhar, password) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(query);

			// 🔹 Set values
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setLong(3, phone);
			ps.setString(4, dob);
			ps.setInt(5, age);
			ps.setLong(6, aadhar);
			ps.setString(7, password);

			// 🔹 Execute query
			ps.executeUpdate();

			// 🔹 Success message

			output.print("Your Data Successfully Registered");

			// 🔹 Close resources
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

			// 🔹 Error message
			output.print("<h2 style='color:red;text-align:center;'>");
			output.print("Error: " + e.getMessage());
			output.print("</h2>");
		}
	}
}
