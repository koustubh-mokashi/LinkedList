
/**
 * Linked list implementation
 * 
 * @author koustubhmokashi
 *
 * @param <T>
 */
public class SinglyLinkedList<T> {

	private Node<T> head;

	private Node<T> tail;

	private static class Node<T> {

		private T value;
		private Node<T> next;

		public Node(T value, Node<T> next) {
			super();
			this.value = value;
			this.next = next;
		}

		public T value() {
			return this.value;
		}

		public Node<T> next() {
			return this.next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

	}

	public T add(T t) {
		Node<T> newNode = new Node<T>(t, null);
		if (tail != null) {
			tail.setNext(newNode);
			tail = newNode;
		} else {
			head = newNode;
			tail = newNode;
		}
		return newNode.value;
	}

	public T pop() {
		checkIfListEmpty();
		Node<T> start = head;
		if (head == tail) {
			head = null;
			tail = null;
			return start.value;
		}
		for (; start.next() != tail; start = start.next())
			;
		Node<T> removedNode = start.next();
		start.setNext(null);
		tail = start;
		return removedNode.value;
	}

	public T removeFirst() {
		checkIfListEmpty();
		Node<T> nodeRemoved = head;
		head = head.next();
		return nodeRemoved.value;
	}

	public T addFirst(T value) {
		Node<T> newNode = new Node<T>(value, head);
		head = newNode;
		return newNode.value;
	}

	/**
	 * Getting node by index.
	 * 
	 * @param index
	 *            index starts with 0, index of first element is 0.
	 * @return {@value T}
	 */
	public T get(int postion) {
		checkIfListEmpty();
		return getNodeByPostion(postion).value();
	}

	public T set(int position, T value) {
		checkIfListEmpty();
		Node<T> node = getNodeByPostion(position);
		node.value = value;
		return value;
	}

	public T insert(int position, T value) {
		if (position == 0) {
			return addFirst(value);
		}
		checkIfListEmpty();
		Node<T> prevPosNode = getNodeByPostion(position - 1);
		Node<T> newNode = new Node<T>(value, prevPosNode.next);
		prevPosNode.setNext(newNode);
		return value;
	}

	public T remove(int position) {
		checkIfListEmpty();
		if (position == 0) {
			return removeFirst();
		}
		Node<T> prevNode = getNodeByPostion(position - 1);
		T value = prevNode.next.value;
		prevNode.setNext(prevNode.next.next);
		if(prevNode.next == null) {
			tail = prevNode;
		}
		return value;
	}

	public void reverseList() {
		checkIfListEmpty();
		SinglyLinkedList<T> reverseList = new SinglyLinkedList<>();
		while(this.head != null) {
			reverseList.addFirst(this.head.value);
			this.head = this.head.next;
		}
		this.head = reverseList.head;
		this.tail = reverseList.tail;
	}

	private Node<T> getNodeByPostion(int postion) {
		int indexCount = 0;
		Node<T> startNode = head;
		while (indexCount++ < postion) {
			if (startNode == null) {
				throw new RuntimeException("Invalid index specified.!!!");
			}
			startNode = startNode.next();
		}
		return startNode;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> node = head;
		while (node != null) {
			sb.append(node.value()).append(":");
			node = node.next();
		}
		return sb.toString();
	}

	private void checkIfListEmpty() {
		if (tail == null) {
			throw new RuntimeException("List is empty.!!!");
		}
	}

}
