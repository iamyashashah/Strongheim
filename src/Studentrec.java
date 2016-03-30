

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.*;

import model.DBUtil;
import model.QS3;
import model.StudentGradebook;

/**
 * Servlet implementation class Studentrec
 */
@WebServlet("/Studentrec")
public class Studentrec extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Studentrec() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		QS3 qs3=new QS3();

		String output="";
	
		String result = qs3.Studentrec();
		List<StudentGradebook> list=qs3.FindWithtype("Homework").getResultList();
		System.out.println("Result is: " + result);
		
		for (StudentGradebook gb:list)
		{
			output +=gb.getStudId()+"\t"+gb.getAssignmentName()+"\t"+gb.getDateSubmit()+"\t"+gb.getGrade()+"\n";
		}
		
		request.setAttribute("result", output);
		request.getRequestDispatcher("/output.jsp").forward(request, response);
	}

}
