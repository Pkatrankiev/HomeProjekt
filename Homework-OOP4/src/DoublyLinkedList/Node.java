package DoublyLinkedList;

public class Node {
	private Object data;
	private Node next;
	private Node prev;
			
	public Node(Object data, Node next, Node prev) {
		super();
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
