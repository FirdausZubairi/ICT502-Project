package bean;

public class passenger {
		private int passID;
		private String name;
		private String phone;
		private String username;
		private String password;
		
		public passenger(int passID, String name, String phone, String username, String password) {
			super();
			this.passID = passID;
			this.name = name;
			this.phone = phone;
			this.username = username;
			this.password = password;
		}
		
		public passenger(int passID, String name, String phone) {
			super();
			this.passID = passID;
			this.name = name;
			this.phone = phone;
			
		}
		
		public passenger( String name, String phone) {
			super();
			
			this.name = name;
			this.phone = phone;
			
		}
		
		public passenger() {
			
		}

		public int getPassID() {
			return passID;
		}

		public void setPassID(int passID) {
			this.passID = passID;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
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
		
		
		
}
