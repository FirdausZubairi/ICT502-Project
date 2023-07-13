package bean;

import java.sql.Date;

public class TBD {
		private int ticketID;
		private Date ticketDate;
		private int destinationID;
		private int busID;
		private String name;
		private String noPlate;
		private String destinationName;
		
		public TBD(int ticketID, Date ticketDate, int destinationID, int busID, String name, String noPlate,
				String destinationName) {
			super();
			this.ticketID = ticketID;
			this.ticketDate = ticketDate;
			this.destinationID = destinationID;
			this.busID = busID;
			this.name = name;
			this.noPlate = noPlate;
			this.destinationName = destinationName;
		}
		
		public TBD(int ticketID, Date ticketDate, int destinationID, int busID) {
			super();
			this.ticketID = ticketID;
			this.ticketDate = ticketDate;
			this.destinationID = destinationID;
			this.busID = busID;
			
		}
		
		public TBD(int ticketID, Date ticketDate, int destinationID, int busID, String name,
				String destinationName) {
			super();
			this.ticketID = ticketID;
			this.ticketDate = ticketDate;
			this.destinationID = destinationID;
			this.busID = busID;
			this.name = name;
			this.destinationName = destinationName;
		}
		
		


		public int getTicketID() {
			return ticketID;
		}

		public void setTicketID(int ticketID) {
			this.ticketID = ticketID;
		}

		public Date getTicketDate() {
			return ticketDate;
		}

		public void setTicketDate(Date ticketDate) {
			this.ticketDate = ticketDate;
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

		public String getDestinationName() {
			return destinationName;
		}

		public void setDestinationName(String destinationName) {
			this.destinationName = destinationName;
		}
		
		
		
}
