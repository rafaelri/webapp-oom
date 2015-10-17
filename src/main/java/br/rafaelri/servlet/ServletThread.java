package br.rafaelri.servlet;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebServlet(value="/oot", name="ootServlet")
public class ServletThread extends GenericServlet {
	Runnable r = new Runnable() {
		public void run(){
			try {
			Thread.currentThread().sleep(Integer.MAX_VALUE);
			} catch(Exception e) {}
		}
	};
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	res.getWriter().println("spawning threads");
	
	for (int i=0;i<65000;i++) {
		new Thread(r).start();
        	res.getWriter().println("threads " + i);
		res.getWriter().flush();
	}	
        res.getWriter().println("Hello world!!");
    }
}
