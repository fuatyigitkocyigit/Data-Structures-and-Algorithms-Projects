//-----------------------------------------------------
// Title: BST
// Author: Fuat Yiðit Koçyiðit & Günsu Günaydýn
// ID: 16429085948 & 18098680134
// Section: 3
// Assignment: 3
// Description: This class defines a binary search tree to use for movie database.
//-----------------------------------------------------

public class BST <Key extends Comparable<Key>, Value>{
	
	private Node root;
	
	private class Node{
		//--------------------------------------------------------
		// Summary: Node class
		//--------------------------------------------------------
		
		private Key key;
		private Value val;
		private Node left, right;
		private int N;
		public Node(Key key, Value val, int N){ 
			this.key = key; 
			this.val = val; 
			this.N = N; 
		}
	}
	
	public int size(){ 
		//--------------------------------------------------------
		// Summary: Returns the size
		//--------------------------------------------------------
		
		return size(root);
	}
	
	private int size(Node x){
		//--------------------------------------------------------
		// Summary: Returns the size
		//--------------------------------------------------------
		
		if (x == null) 
			return 0;
		else 
			return x.N;
	}
	
	public Value get(Key key){ 
		//--------------------------------------------------------
		// Summary: Gets the key.
		//--------------------------------------------------------
		
		return get(root, key); 
	}
	
	private Value get(Node x, Key key){ 
		//--------------------------------------------------------
		// Summary: Returns value associated with key in the subtree rooted at x. Return null if key 
		//			not presented in subtree rooted at x.
		//--------------------------------------------------------

		if (x == null) 
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) 
			return get(x.left, key);
		else if (cmp > 0) 
			return get(x.right, key);
		else 
			return x.val;
	}
	
	public void put(Key key, Value val){ 
		//--------------------------------------------------------
		// Summary: Search for key. Update value if found; grow table if new.
		//--------------------------------------------------------

		root = put(root, key, val);
	}
	
	private Node put(Node x, Key key, Value val){
		//--------------------------------------------------------
		// Summary: Change key’s value to val if key in subtree rooted at x. Otherwise, add new node to 
		//			subtree associating key with val.
		//--------------------------------------------------------
		
		if (x == null) 
			return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0) 
			x.left = put(x.left, key, val);
		else if (cmp > 0) 
			x.right = put(x.right, key, val);
		else 
			x.val = val;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	
	public Key min(){
		//--------------------------------------------------------
		// Summary: Search min key.
		//--------------------------------------------------------
		
		return min(root).key;
	}
	
	private Node min(Node x){
		//--------------------------------------------------------
		// Summary: Search min key.
		//--------------------------------------------------------
		
		if (x.left == null) 
			return x;
		return min(x.left);
	}
	
	public Key floor(Key key){
		//--------------------------------------------------------
		// Summary: Search floor key.
		//--------------------------------------------------------
		
		Node x = floor(root, key);
		if (x == null) 
			return null;
		return x.key;
	}
	
	private Node floor(Node x, Key key){
		//--------------------------------------------------------
		// Summary: Search floor key.
		//--------------------------------------------------------
		
		if (x == null) 
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) 
			return x;
		if (cmp < 0) 
			return floor(x.left, key);
		Node t = floor(x.right, key);
		if (t != null) 
			return t;
		else 
			return x;
	}
	
	
	public Key select(int k){
		//--------------------------------------------------------
		// Summary: Select the key.
		//--------------------------------------------------------
		
		return select(root, k).key;
	}
	
	private Node select(Node x, int k){ 
		//--------------------------------------------------------
		// Summary: Select the key.
		//--------------------------------------------------------

		if (x == null) 
			return null;
		int t = size(x.left);
		if (t > k) 
			return select(x.left, k);
		else if (t < k) 
			return select(x.right, k-t-1);
		else 
			return x;
	}
	
	public int rank(Key key){ 
		//--------------------------------------------------------
		// Summary: Return Node containing key of rank k.
		//--------------------------------------------------------
		
		return rank(key, root); 
	}
	
	private int rank(Key key, Node x){ 
		//--------------------------------------------------------
		// Summary: Returns number of keys less than x.key in the subtree rooted at x.
		//--------------------------------------------------------

		if (x == null) 
			return 0;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) 
			return rank(key, x.left);
		else if (cmp > 0) 
			return 1 + size(x.left) + rank(key, x.right);
		else 
			return size(x.left);
	}
	
	
	public void deleteMin(){
		//--------------------------------------------------------
		// Summary: Delete min key.
		//--------------------------------------------------------
		
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x){
		//--------------------------------------------------------
		// Summary: Delete min key.
		//--------------------------------------------------------
		
		if (x.left == null) 
			return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void delete(Key key){ 
		//--------------------------------------------------------
		// Summary: Delete a key.
		//--------------------------------------------------------
		
		root = delete(root, key); 
	}
	
	private Node delete(Node x, Key key){
		//--------------------------------------------------------
		// Summary: Delete a key.
		//--------------------------------------------------------
		
		if (x == null) 
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) 
			x.left = delete(x.left, key);
		else if (cmp > 0) 
			x.right = delete(x.right, key);
		else{		
			if (x.right == null) 
				return x.left;
			if (x.left == null) 
				return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	
	public Iterable<Key> keys(){ 
		//--------------------------------------------------------
		// Summary:
		//--------------------------------------------------------
		
		return keys(min(), max()); 
	}
	
	public Iterable<Key> keys(Key lo, Key hi){
		//--------------------------------------------------------
		// Summary:
		//--------------------------------------------------------
		
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}
	
	private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
		//--------------------------------------------------------
		// Summary:
		//--------------------------------------------------------
		
		if (x == null) 
			return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0) 
			keys(x.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0) 
			queue.enqueue(x.key);
		if (cmphi > 0) 
			keys(x.right, queue, lo, hi);
	}	
	
	private void print(Node x){
		//--------------------------------------------------------
		// Summary: Prints the keys.
		//--------------------------------------------------------
		
		if (x == null) 
			return;
		print(x.left);
		System.out.println(x.key);
		print(x.right);
	}
	
}