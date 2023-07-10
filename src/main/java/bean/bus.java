package bean;

public class bus {
		private int busID;
		private String name;
		private String noPlate;
		
		public bus(int busID, String name, String noPlate) {
			super();
			this.busID = busID;
			this.name = name;
			this.noPlate = noPlate;
		}
		
		public bus() {
			
		}

		public int getBusID() {
			return busID;
		}

		public void setBusID(int busID) {
			this.busID = busID;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getNoPlate() {
			return noPlate;
		}

		public void setNoPlate(String noPlate) {
			this.noPlate = noPlate;
		}
		
		
		
}
