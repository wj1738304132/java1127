package com.chinasoft.model;

public class User {
	private int id;
	private String username;
	private String userpwd;
	private int userage;
	private String userFileName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public int getUserage() {
		return userage;
	}
	public void setUserage(int userage) {
		this.userage = userage;
	}
	public String getUserFileName() {
		return userFileName;
	}
	public void setUserFileName(String userFileName) {
		this.userFileName = userFileName;
	}
	public User(int id, String username, String userpwd, int userage,String userFileName) {
		super();
		this.id = id;
		this.username = username;
		this.userpwd = userpwd;
		this.userage = userage;
		this.userFileName = userFileName;
	}
	public User(String username, String userpwd, int userage,String userFileName) {
		super();
		this.username = username;
		this.userpwd = userpwd;
		this.userage = userage;
		this.userFileName = userFileName;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", userpwd="
				+ userpwd + ", userage=" + userage + ", userFileName=" + userFileName
				+ "]";
	}

	
}
