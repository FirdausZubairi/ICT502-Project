package bean;

import java.sql.Date;

public class trip {
		private int destinationID;
		private int busID;
		private Date time;
		
		public trip(int destinationID, int busID, Date time) {
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

		public Date getTime() {
			return time;
		}

		public void setTime(Date time) {
			this.time = time;
		}
		
		

}
