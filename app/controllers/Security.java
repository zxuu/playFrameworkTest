package controllers;

public class Security extends Secure.Security {
	static boolean authenticate(String username, String password) {
		boolean ret = username != null && password != null
				&& (username.equals("zxu") && password.equals("2018"));
		session.put("currentUser", username);
		return ret;
	}

	public static boolean check(String profile) {
		if (Security.isConnected()) {
			String user = Security.connected();
			boolean rst = false;
			if (profile.equals("studentNameModify") && user.equals("stu"))
				rst = true;
			return rst;
		} else {
			return false;
		}
	}

}
