package expense_tracker;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddExpense extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		String expense = req.getParameter("expense");
		
		String category = req.getParameter("category");
		
		double amount = Double.parseDouble(req.getParameter("amount"));
		if(amount <=0)
		{
			PrintWriter pw=resp.getWriter();
			pw.println("<html><center><body>"+"<h2 style='color :blue;'>Amount should be greater than 0</h2></body></center></html>");
			
			RequestDispatcher rd= req.getRequestDispatcher("addExpense.html");
			rd.include(req, resp);
			
		    return;
		}
		
		LocalDate date = LocalDate.parse(req.getParameter("date")); 
		
		Expense e = new Expense( expense, category, amount, date);
		
		ExpenseData.expenses.add(e);
		
		resp.setContentType("text/html");
		resp.getWriter().println("<html><center><body>"+"<h2>Expense Added!</h2>" + "<a href='view'>" + "<button style = 'padding : 10px;"+"background :green;"+"color : white;"+"border : none;"+"border-radius :5px;'>"+"View Expenses"+"</button>"+"</a>"+"</body></center></html>");
		System.out.println(ExpenseData.expenses);
	}

}
