package utilities;

public class Pair<T1, T2> {

	private T1 first;
	private T2 second;
	
	public Pair(T1 first, T2 second) {
		this.first = first;
		this.second = second;
	}
	
	public T1 getFirst() {
		return first;
	}

	public T2 getSecond() {
		return second;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    
	    final Pair<T1, T2> other = (Pair<T1, T2>) obj;
	    if ((this.first == null) ? (other.first != null) : !this.first.equals(other.first)) {
	        return false;
	    }
	    if ((this.second == null) ? (other.second != null) : !this.second.equals(other.second)) {
	        return false;
	    }
	    
	    return true;
	}
}
