package bean;


import java.sql.Time;

public class trip {
		private int destinationID;
		private int busID;
		private String time;
		
		public trip(int destinationID, int busID, String time) {
			super();
			this.destinationID = destinationID;
			this.busID = busID;
			this.time = time;
		}

		public int getDestinationID() {
			return destinationID;
		}

		public void setDestinationID(int destinationID) {
			this.destinationID = destinationID;
		}

		public int getBusID() {
			return busID;
		}

		public void setBusID(int busID) {
			this.busID = busID;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}
		
		

}
