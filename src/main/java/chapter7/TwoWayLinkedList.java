package chapter7;

public class TwoWayLinkedList {

	private HistoryItem firstHistoryItem;
	private HistoryItem lastHistoryItem;
	private int historyItemCount = 0;
	
	public void addHistoryItem(HistoryItem histItem) {
		
		if (historyItemCount > 0) {
			HistoryItem currentLast = lastHistoryItem;
			currentLast.setNextHistoryItem(histItem);
			histItem.setPreviousHistoryItem(currentLast);
		} else {
			firstHistoryItem = histItem;
		}
		
		lastHistoryItem = histItem;
		historyItemCount++;
	}
	
	public HistoryItem getFirstHistoryItem() {
		return firstHistoryItem;
	}
	
	public HistoryItem getLastHistoryItem() {
		return lastHistoryItem;
	}
	
	public int getHistoryItemCount() {
		return this.historyItemCount;
	}	
}
