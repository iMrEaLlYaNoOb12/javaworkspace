package com.vastpro.annotations.main;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class AnnoDemo {
	public static void main(String[] args) throws Exception {
		// I am creating Bank object for Corporation Bank
		// CB pays me Rs. 1000 for developing software
		Banking cbbanking = BankingContainer.createBankingObject();
		cbbanking.credit();
		cbbanking.debit();
		// HDFC pays me Rs. 10,000/- for developing software
		// american bank - 100000/-

	}
}

class BankingContainer {
	public static Banking createBankingObject() throws Exception {
		Banking obj = new Banking();
		Class c = obj.getClass();
		Method m = c.getDeclaredMethod("credit");
		m.setAccessible(true);
		Transactions tr = (Transactions) m.getAnnotation(Transactions.class);
		// System.out.println(tr);

		String transactionname = tr.transactionname();
		if (tr != null) {
			if (transactionname.equals("oops.MyBumperTransaction")) {
				obj.setTr(new MyBumperTransaction());
			} else if (transactionname.equals("oops.MySuperTransaction")) {
				obj.setTr(new MySuperTransaction());
			} else {
				obj.setTr(new MyTransaction());
			}

		}
		Securities sc = (Securities) m.getAnnotation(Securities.class);
		if (sc != null) {
			obj.setSc(new MySecurity());
		}
		return obj;
	}
}

class Banking {
	MyTransaction tr;
	MySecurity sc;

	public void setTr(MyTransaction tr) {
		this.tr = tr;
	}

	public void setSc(MySecurity sc) {
		this.sc = sc;
	}

	@Transactions(transactionname = "oops.MyBumperTransaction")
	@Securities
	public void credit() {
		System.out.println("credit happened....");
		if (tr != null) {
			tr.handleTransaction();
		}
		if (sc != null) {
			sc.handleSecurity();
		}
	}

	public void debit() {
		System.out.println("debit happened....");
	}
}

class MyTransaction {
	public void handleTransaction() {
		System.out.println("Transactions handled....");
	}
}

class MySuperTransaction extends MyTransaction {
	@Override
	public void handleTransaction() {
		System.out.println("extra rich feature transaction......");
	}
}

class MyBumperTransaction extends MyTransaction {
	@Override
	public void handleTransaction() {
		System.out.println("bumper offer transaction...........");
	}
}

class MySecurity {
	public void handleSecurity() {
		System.out.println("security handled.....");
	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface Transactions {
	String transactionname();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Securities {

}