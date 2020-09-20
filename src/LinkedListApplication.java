
public class LinkedListApplication {

	public static void main(String arg[]) {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.add("koustubh");
		list.add("raj");
		list.add("vijay");
		list.add("ravi");
		System.out.println(list);
		list.pop();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.addFirst("koustubh");
		System.out.println(list);
		System.out.println(list.get(1));
		list.set(1, "kiran");
		System.out.println(list);
		list.insert(0, "java");
		System.out.println(list);
		list.insert(0, "jdk");
		System.out.println(list);
		list.remove(0);
		list.remove(0);
		System.out.println(list);
		list.remove(2);
		list.remove(1);
		System.out.println(list);
		list.add("raj");
		list.add("vijay");
		list.add("ravi");
		System.out.println(list);
		list.reverseList();
		System.out.println(list);
	}

}
