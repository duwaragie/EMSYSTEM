package IT_Support_Staff;

public class TicketRead {
	
	private int HistoryId;
	private int TicketId;
	private int iTSupportId;
	private String ActionTaken;
	
	
	public TicketRead(int historyId, int ticketId, int iTSupportId, String actionTaken) {
		
		this.HistoryId = historyId;
		this.TicketId = ticketId;
		this.iTSupportId = iTSupportId;
		this.ActionTaken = actionTaken;
	}


	public int getHistoryId() {
		return HistoryId;
	}


	public int getTicketId() {
		return TicketId;
	}


	public int getiTSupportId() {
		return iTSupportId;
	}


	public String getActionTaken() {
		return ActionTaken;
	}


	public void setHistoryId(int historyId) {
		HistoryId = historyId;
	}


	public void setTicketId(int ticketId) {
		TicketId = ticketId;
	}


	public void setiTSupportId(int iTSupportId) {
		iTSupportId = iTSupportId;
	}


	public void setActionTaken(String actionTaken) {
		ActionTaken = actionTaken;
	}


}
