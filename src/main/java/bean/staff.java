package bean;

public class staff {
		private int staffID;
		private String username;
		private String password;
		private String name;
		private String role;
		private int adminID;
		
		public staff () {
			
		}
		
		public staff(int staffID, String username, String password, String name, String role, int adminID) {
			super();
			this.staffID = staffID;
			this.username = username;
			this.password = password;
			this.name = name;
			this.role = role;
			this.adminID = adminID;
		}
		
		public staff(String username, String password, String name, String role, int adminID) {
			super();
			this.username = username;
			this.password = password;
			this.name = name;
			this.role = role;
			this.adminID = adminID;
		}
		
		public staff(String username, String password, String name, String role) {
			super();
			this.username = username;
			this.password = password;
			this.name = name;
			this.role = role;
		}
		
		public staff(String username, String password, String role) {
			super();
			this.username = username;
			this.password = password;
			this.role = role;
		}

		public int getStaffID() {
			return staffID;
		}

		public void setStaffID(int staffID) {
			this.staffID = staffID;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public int getAdminID() {
			return adminID;
		}

		public void setAdminID(int adminID) {
			this.adminID = adminID;
		}
		
		
}
