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
			historyItemCount = countHistoryItemsToCurrent(histItem);
		} else {
			firstHistoryItem = histItem;
			historyItemCount = 1;
		}
		
		lastHistoryItem = histItem;
	}
	
	private int countHistoryItemsToCurrent(HistoryItem current) {
		int itemCount = 1;
		HistoryItem pointer = firstHistoryItem;
		
		while (pointer != null) {
			itemCount++;
			pointer = pointer.getNextHistoryItem();
			
			if (pointer == current) {
				break;
			}
		}
		
		return itemCount;
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
