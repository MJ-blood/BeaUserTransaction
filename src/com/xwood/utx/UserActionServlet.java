package com.xwood.utx;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.xwood.utx.service.UtxDaoUtils;

public class UserActionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserTransaction ut =null;
		try {
			ut = UserBeaTransaction.getUserTransaction();
			ut.begin();
			UtxDaoUtils.delTab1();
			throwException();//模拟发送异常
			UtxDaoUtils.delTab2();
			System.out.println("exception...");
			ut.commit();
		} catch (Exception e) {
			try {
				ut.rollback();
				System.out.println("rollback...");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
		}
	}
	private void  throwException() throws RuntimeException{
		throw new RuntimeException();
	}
	

}
