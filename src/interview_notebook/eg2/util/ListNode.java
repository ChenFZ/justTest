package interview_notebook.eg2.util;

public class ListNode {
	private Node first,last = null;
	
	//链表的结点
	private class Node {
		String item;
		Node nextNode;
	}
	
	public void add(String str){
		Node oldNode = last;
		last = new Node();
		last.item = str;
		last.nextNode = null;
		if (isEmpty()) 
			first = last;
		else
			oldNode.nextNode = last;
	}
	
//	public String remove(){
//		if (isEmpty()) return "链表已经为空，请勿进行取值操作";
//		
//	}
	
	public boolean isEmpty(){ return first == null; }
}
