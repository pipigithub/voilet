package home;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ��дdoGet����
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// �������˴�ӡ��Ϣ
		System.out.println("username=" + username);
		System.out.println("password=" + password);
		// ���ñ����ʽ
		response.setContentType("text/html;charset=GB18030");

		// ����htmlҳ��
		response.getWriter().println("<html>");
		response.getWriter().println("<head>");
		response.getWriter().println("<title>��¼��Ϣ</title>");
		response.getWriter().println("</head>");
		response.getWriter().println("<body>");
		response.getWriter().println("��ӭ��" + username + "���û���¼�ɹ�������");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}

	// ��дdoPost����
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
