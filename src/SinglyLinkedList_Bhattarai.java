public class SinglyLinkedList_Bhattarai {
	
	private Node h;
	
	public SinglyLinkedList_Bhattarai()
	{
		h=new Node();
		h.l= null;
		h.next=null;
	}
	public class Node
	{
		private Account_Bhattarai l;
		private Node next;
		public Node()
		{
			
		}
	}


public boolean insert (Account_Bhattarai newAcc)
{
	Node n=new Node();
	if(n==null)
		return false;
	else
	{
		n.next=h.next;
		h.next=n;
		n.l=newAcc.deepCopy();
		return true;
	}
}

public Account_Bhattarai fetch(String targetKey)
{
	Node p=h.next;
	while(p !=null && !(p.l.compareTo(targetKey)==0))
	{
		p=p.next;
	}
	if(p !=null)
		return p.l.deepCopy();
	else
		return null;
}

public boolean delete(String targetKey)
{
	Node q=h;
	Node p=h.next;
	while(p !=null && !(p.l.compareTo(targetKey)==0))
	{
		q=h;
		p=p.next;
	}
	if(p !=null)
	{
		q.next=p.next;
		return true;
	}
	else 
		
		return false;
}

public boolean update(String targetKey, Account_Bhattarai newAcc)
{
	if(delete(targetKey)==false)
		return false;
	else if(insert(newAcc)==false)
		return false;
	return true;
}

public void showAll()
{
	Node p=h.next;
	while(p != null)
	{
		System.out.println(p.l.toString());
		p=p.next;
	}
}

}
