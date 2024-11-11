package main.hr;

public class HRticket {
	private int ticketId;
	private  int employeeId;
	private  String tickeStatus;
	private String  dateSubmitted;
	private  String resolvedby;
	private  String  response;
	private  String  dateResponded;

	public HRticket(int ticketId, int employeeId, String ticketStatus, String dateSubmitted,String response, String resolvedby,
			String dateResponded) {
		
		this.ticketId = ticketId;
		this.employeeId = employeeId;
		this.tickeStatus = ticketStatus;
		this.dateSubmitted = dateSubmitted;
		this.resolvedby = resolvedby;
		this.response =response;
		this.dateResponded = dateResponded;
	}

	public int getTicketId() {
		return ticketId;
	}


	public int getEmployeeId() {
		return employeeId;
	}

	

	public String getTicketStatus() {
		return tickeStatus;
	}

	

	public String getDateSubmitted() {
		return dateSubmitted;
	}

	

	public String getResolvedby() {
		return resolvedby;
	}
	public String getresponse() {
		return response;
	}
	

	public String getdateResponded() {
		return dateResponded;
	}


	
}
