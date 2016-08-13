package com.xwood.utx;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class UserBeaTransaction {
	public static UserTransaction getUserTransaction() throws NamingException,SystemException {
        UserTransaction trans = null;
        Context ctx = new InitialContext();
        trans = (UserTransaction) ctx.lookup("java:comp/UserTransaction");//Bea默认注册名
        if (trans != null){
            trans.setTransactionTimeout(30*20); // 设置事务超时间
            return trans;
        }else{
            return null;
        }
	}
}
