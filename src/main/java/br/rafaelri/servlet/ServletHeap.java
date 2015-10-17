package br.rafaelri.servlet;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebServlet(value="/oom", name="oomServlet")
public class ServletHeap extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.getWriter().println("triggering OutOfMemmory...");
        List list = new ArrayList();
        try {
            while (true) {
                byte[] bytes = new byte[1024 * 1024 * 1024];
                list.add(bytes);
                res.getWriter().println("list size: " + list.size());
		res.getWriter().flush();
            }
        }
        catch (Throwable t) {
            System.out.println(t.toString());
        }
        res.getWriter().println("final list size: " + list.size());
    }
}
