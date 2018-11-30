package com.jp.hr.entities;

public class UserMaster {

		private String userId;
		private String password;
		private String userFullName;
		private String userRole;
		
		
		
		
		public UserMaster(String userId, String password, String userFullName, String userRole) {
			super();
			this.userId = userId;
			this.password = password;
			this.userFullName = userFullName;
			this.userRole = userRole;
		}
		
		
		public UserMaster() {
			super();
			// TODO Auto-generated constructor stub
		}


		@Override
		public String toString() {
			return "UserMaster [userId=" + userId + ", password=" + password + ", userFullName=" + userFullName
					+ ", userRole=" + userRole + "]";
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUserFullName() {
			return userFullName;
		}
		public void setUserFullName(String userFullName) {
			this.userFullName = userFullName;
		}
		public String getUserRole() {
			return userRole;
		}
		public void setUserRole(String userRole) {
			this.userRole = userRole;
		}
		
		
}
