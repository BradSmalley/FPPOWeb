package org.fictitiousprofession.web.form;

import java.io.Serializable;

public class EditRoleInfoForm implements Serializable {

	private final static long serialVersionUID = 1L;

	private boolean admin = false;
	
	private int userId;

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}
