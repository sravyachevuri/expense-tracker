package expense_tracker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewExpenses extends HttpServlet
{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
		{
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			double total=0;
			
			HashMap<String, Double> categoryTotal = new HashMap<>();
			
			out.println("<div class='container'>");
			
			out.println("<html><center><body><h2>Expense List</h2></body></center></html>");
			for(Expense e : ExpenseData.expenses)
			{
				out.println("<div style='border : 1px solid black; padding : 10px; margin : 10px;'>");
				
				out.println("Expense : " + e.getExpense() +
						"<br>Category : " + e.getCategory() +
						"<br>Amount : " + e.getAmount() +
						"<br>Date : " + e.getDate() + "<br>");
				
				out.println("</div>");
				
				total = total + e.getAmount();
				
				String category = e.getCategory();
				
				if(categoryTotal.containsKey(category))
				{
					double oldAmount = categoryTotal.get(category); 
					categoryTotal.put(category, oldAmount + e.getAmount());
				}
				else
				{
					categoryTotal.put(category, e.getAmount());

				}
			}
			out.println("<html><center><body><h4>Total Expense = " + total + "</h4></body></center></html>");
			
			out.println("</div>");
			
			out.println("<html><center><body><h2>Category Wise Total</h2></body></center></html>");
			
			for(String category : categoryTotal.keySet())
			{
				out.println("<html><center><body>"+category + " : " + categoryTotal.get(category) + "<br>"+"</body></center></html>");
			}
			out.println("<br><br>");
			out.println("<html><center><body>"+"<a href='addExpense.html'>"
		    +"<button style = 'padding : 10px;"+"background :green;"+"color : white;"+"border : none;"+"border-radius :5px;'>"+"Add Expense"+"</button>"+"</a>"+"</body></center></html>");
		    		
		}
}

