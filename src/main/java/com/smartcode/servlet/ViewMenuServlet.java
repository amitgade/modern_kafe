package com.smartcode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartcode.data.MenuDataService;
import com.smartcode.domain.MenuItem;

public class ViewMenuServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		MenuDataService menuDataService = new MenuDataService();
		List<MenuItem> menuitems = menuDataService.getFullMenu();

		out.println("<html><bosy><h1>Modern Kafe</h1>");
		out.println("<h2>Menu</h2>");

		for (MenuItem menuItem : menuitems) {
			out.println("<li>" + menuItem + "</li>");
		}

		out.println("</body></html>");
		out.close();
	}
}
