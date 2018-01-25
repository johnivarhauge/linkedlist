public class SingleLinkedList{

	private Node head;
	private int elementCount;

	SingleLinkedList(){
		elementCount = 0;
		head = null;

	}
	public Node getHead(){
		return head;
	}

	public int getElementCount(){
			return elementCount;
	}

	public void insertFirst(int e){
		head = new Node(e, head);

		elementCount ++;

		//Oppretter den første noden/lager den første i
		//rekken og setter denne nye noden til å peke på den head pekte på før.

	}

	public void insertLast(int e){
		Node ptr = head;
		if (ptr == null)
			insertFirst(e);
		else {
			while (ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = new Node(e, ptr.next);
			elementCount ++;
		}
	}

	public void deleteFirst() {
		if (head != null) {
			head = head.next;
			elementCount --;
		}
	}
	public void deleteLast () {
		Node ptr = head;
		if (ptr != null)
			if (ptr.next == null)
				deleteFirst();
			else {
				while (ptr.next != null) {
					ptr = ptr.next;
				}
				ptr.next = null;
				elementCount --;
			}
	}
	public void insertAfterValue(int e, int value){
		Node ptr = head;
		while (ptr.next!=null && ptr.element!=value){
			ptr=ptr.next;
		}
		if(ptr.element==value&&ptr!=null){
			ptr.next = new Node(e,ptr.next);
			elementCount++;
		}

	}
	public void insertBeforeValue(int e, int value){

		Node ptr = head;

		if (head.element==value){
			head=new Node(e,head);
			elementCount++;
		}
		else {
			while (ptr.next!=null && ptr.next.element!=value){
				ptr=ptr.next;
			}
			if (ptr.next!=null&&ptr.next.element==value){
			ptr.next=new Node(e,ptr.next);
			elementCount++;
			}
		}
	}
	public void deleteFirstValueOf(int value) {
			Node ptr = head;
			if(head.element==value)
				deleteFirst();
			else {
				while (ptr.next != null&&ptr.next.element != value)
				ptr=ptr.next;
				if (ptr.next!=null&&ptr.next.element == value){
					ptr.next=ptr.next.next;
					elementCount--;
				}
			}
	}
	public int valueCount(int value){
		int valueCount = 0;
		Node ptr = head;

		for (int i = 0;i<elementCount;i++) {
			if (ptr.element == value)
				valueCount++;
			ptr=ptr.next;
		}
		return valueCount;
	}
	public String printValueCountOf(int value) {
		int valueCount = 0;
		Node ptr = head;

		for (int i = 0;i<elementCount;i++) {
			if (ptr.element == value)
				valueCount++;
			ptr=ptr.next;
		}
		return "Number of elements = " + Integer.toString(value) + " is\n\n                          " + Integer.toString(valueCount);
	}
	public void deleteAllValuesOf(int value){
		int valueCount = valueCount(value);
		for (int i=0;i<=valueCount;i++)
			deleteFirstValueOf(value);
	}
	public void deleteList(){
		head = null;
		//System.out.print("Elements deleted: " + elementCount);
		elementCount = 0;
	}
	public void printList(SingleLinkedList a){
		System.out.println("\n  Number of elements: " + a.getElementCount()+"\n");

		Node ptr = a.getHead();

		for (int i = 0; i < a.getElementCount(); i++){
			System.out.println("  element nr: " + (i+1) + " = " + ptr.element);
			if (ptr.next!=null)
				ptr=ptr.next;
		}
	}
	public String printListTextArea(SingleLinkedList a){
		String textString =("  Number of elements: " + Integer.toString(a.getElementCount())+"\n\n");

				Node ptr = a.getHead();

				for (int i = 0; i < a.getElementCount(); i++){
					textString = textString +("  element nr: " + Integer.toString(i+1) + " = " + Integer.toString(ptr.element)+"\n");
					if (ptr.next!=null)
						ptr=ptr.next;
				}
				return textString;

	}
}