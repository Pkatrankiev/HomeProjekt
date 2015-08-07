package DoublyLinkedList;

public class MyLinkedList {
	private Node head;
	private Node tail;
	private int count = 0;

	public void addInTheEnd(Object element) {
		Node newNode = new Node(element, null, null);

		if (!isEmpty()) {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;

		} else {
			this.head = newNode;
			this.tail = head;
		}
		this.count++;
	}

	public void addInTheBegining(Object element) {
		Node newNode = new Node(element, null, null);

		if (!isEmpty()) {
			head.setPrev(newNode);
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
		} else {
			this.head = newNode;
			this.tail = head;

		}
		this.count++;
	}

	public void addInPosition(Object element, int position) {
		Node newNode = new Node(element, null, null);

		if (!isEmpty()) {

			if (position <= 1) {
				addInTheBegining(element);
			} else {
				if (position > size()) {
					addInTheEnd(element);
					count--;
				} else {

					int centrPosition = size() / 2;

					if (position <= centrPosition) {

						Node tempN = head;

						for (int i = 2; i <= size(); i++) {

							if (i == position) {

								Node temp = tempN.getNext();

								tempN.setNext(newNode);
								newNode.setPrev(tempN);

								newNode.setNext(temp);
								temp.setPrev(newNode);

							} else {
								tempN = tempN.getNext();
							}
						}
					} else {
						Node tempP = tail;

						for (int i = 1; i <= size(); i++) {

							if (i == (size() - position)) {

								Node temp = tempP.getPrev();

								tempP.setPrev(newNode);
								newNode.setNext(tempP);

								newNode.setPrev(temp);
								temp.setNext(newNode);

							} else {
								tempP = tempP.getPrev();
							}
						}
					}
				}
			}
		} else {
			this.head = newNode;
			this.tail = head;

		}

		this.count++;
	}

	public Object get(int position) {
		if (!isEmpty()) {
			Node temp = head;
			int tempCount = 0;
			while (temp.getNext() != null && tempCount < position) {
				temp = temp.getNext();
				tempCount++;
			}
			if (tempCount == position) {
				return temp.getData();
			}
		}

		return null;
	}

	public boolean isEmpty() {
		if (head != null) {
			return false;
		} else
			return true;
	}

	public int size() {
		return this.count;
	}

	boolean remove(Object element) {
		boolean fl = false;
		if (contains(element)) {
			Node temp = head.getNext();

			for (int i = 0; i <= size(); i++) {

				if (get(i).equals(element)) {

					if (i == 0) {
						if (size() == 1) {
							head = null;
							tail = null;
							fl = true;
							count = 0;
							return fl;
						}
						head = head.getNext();
						head.setPrev(null);
						fl = true;
						count--;
						return fl;
					}

					if (size() == (i + 1)) {

						tail = tail.getPrev();
						tail.setNext(null);
						fl = true;
						count--;
						return fl;
					}
					temp = head.getNext();
					for (int j = 1; j <= size(); j++) {

						if (get(j).equals(element)) {

							Node tempN = temp.getNext();
							Node tempP = temp.getPrev();
							tempN.setPrev(tempP);
							tempP.setNext(tempN);
							fl = true;
							count--;
							return fl;
						} else {
							temp = temp.getNext();
						}
					}
				} else {
					temp = temp.getNext();
				}

			}

			return fl;
		}
		return fl;
	}

	boolean contains(Object element) {
		boolean fl = false;
		for (int i = 0; i < size(); i++) {
			if (get(i).equals(element)) {
				fl = true;
			}
		}
		if (!fl) {
			System.out.println("Този елемент не съществува");
		}
		return fl;
	}

}
