package chapter7;

import java.util.UUID;


public class HistoryItem {
	private UUID id;
	private String url;
	private HistoryItem nextHistoryItem;
	private HistoryItem previousHistoryItem;
	
	public HistoryItem(String url) {
		this.id = UUID.randomUUID();
		this.url = url;
	}

	public UUID getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HistoryItem getNextHistoryItem() {
		return nextHistoryItem;
	}

	public void setNextHistoryItem(HistoryItem nextHistoryItem) {
		this.nextHistoryItem = nextHistoryItem;
	}

	public HistoryItem getPreviousHistoryItem() {
		return previousHistoryItem;
	}

	public void setPreviousHistoryItem(HistoryItem previousHistoryItem) {
		this.previousHistoryItem = previousHistoryItem;
	}
}
