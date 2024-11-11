package IT_Support_Staff;

public class TicketDetails {
	
	int HistoryId;
	int TicketID;
	int ItSupportID;
	String ActionTaken;
	public int getHistoryId() {
		return HistoryId;
	}
	public int getTicketID() {
		return TicketID;
	}
	public int getItSupportID() {
		return ItSupportID;
	}
	public String getActionTaken() {
		return ActionTaken;
	}

	
	public TicketDetails(int historyId, int ticketID, int itSupportID, String actionTaken) {
		super();
		HistoryId = historyId;
		TicketID = ticketID;
		ItSupportID = itSupportID;
		ActionTaken = actionTaken;
	}

}
