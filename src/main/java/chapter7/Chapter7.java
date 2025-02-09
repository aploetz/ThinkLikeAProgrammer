package chapter7;

public class Chapter7 {

	public static void main(String[] args) {


		TwoWayLinkedList browserHistory = new TwoWayLinkedList();
		
		HistoryItem historyItem1 = new HistoryItem("https://www.stackoverflow.com/users/1054558/aaron");
		HistoryItem historyItem2 = new HistoryItem("https://www.stackoverflow.com/questions/tagged/cassandra");
		HistoryItem historyItem3 = new HistoryItem("https://www.stackoverflow.com/questions/35708118/where-and-order-by-clauses-in-cassandra-cql");
		HistoryItem historyItem4 = new HistoryItem("https://www.datastax.com/blog/we-shall-have-order");
		HistoryItem historyItem5 = new HistoryItem("https://www.datastax.com");
		HistoryItem historyItem6 = new HistoryItem("https://www.datastax.com/products/datastax-astra");
		
		browserHistory.addHistoryItem(historyItem1);
		browserHistory.addHistoryItem(historyItem2);
		browserHistory.addHistoryItem(historyItem3);
		browserHistory.addHistoryItem(historyItem4);
		browserHistory.addHistoryItem(historyItem5);
		browserHistory.addHistoryItem(historyItem6);
		
		traverseHistoryForward(browserHistory);
		traverseHistoryBackward(browserHistory);

		System.out.println();

	}
	
	public static void traverseHistoryForward(TwoWayLinkedList browserHistory) {
		
		System.out.printf("\nTraversing browser history forward over %d items:\n",
				browserHistory.getHistoryItemCount());
		HistoryItem current = browserHistory.getFirstHistoryItem();

		while (current != null) {
			System.out.printf("%s\n", current.getUrl());
			current = current.getNextHistoryItem();
		}
	}

	private static void traverseHistoryBackward(TwoWayLinkedList browserHistory) {

		System.out.printf("\nTraversing browser history backward over %d items:\n",
				browserHistory.getHistoryItemCount());
		HistoryItem current = browserHistory.getLastHistoryItem();

		while (current != null) {
			System.out.printf("%s\n", current.getUrl());
			current = current.getPreviousHistoryItem();
		}
	}
}
