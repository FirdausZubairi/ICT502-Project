package bean;

public class bus {
		private int busID;
		private String name;
		private String noPlate;
		private int counter;
		
		public bus(int busID, String name, String noPlate) {
			super();
			this.busID = busID;
			this.name = name;
			this.noPlate = noPlate;
		}
		
		public bus( String name, String noPlate) {
			super();
			this.name = name;
			this.noPlate = noPlate;
		}
		
		public bus() {
			
		}
		
		public bus(int counter) {
			super();
			this.counter = counter;
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

		public int getCounter() {
			return counter;
		}

		public void setCounter(int counter) {
			this.counter = counter;
		}
		
		
		
}
