package library;


import java.util.Iterator;

public class MyLibraryList<T> implements Iterable<T> {
	private static final int INITIAL_CAPACITY = 3; 
	private T[] elements =(T[]) new Object[INITIAL_CAPACITY];
	private int count = 0;
	
	
	public void add(T element) {
		if (count >= elements.length) {
			extendElements();			
		}
		elements[count] = element;
		count++;
	}
	
	public void add(T element, int position) {
		if (count >= elements.length) {
			extendElements();
		}
		
		T previousElement = elements[position];
		elements[position] = element;
		count++;
		
		for (int i = position + 1; i < count; i++) {
			T temp = elements[i];
			elements[i] = previousElement;
			previousElement = temp;
		}
	}
	
	public boolean remove(T element) {
		int pos = getPosition(element);
		
		if (pos >= 0) {
			for (int i = pos; i < count-1; i++) {
				
				elements[i] = elements[i+1];
			}
			count--;
			return true;
		}
		
		return false;
	}
	
	public int getPosition(T element) {
		for (int i = 0; i < count; i++) {
			if ((elements[i] != null && elements[i].equals(element))
					|| (element == null && elements[i] == null)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public T get(int position) {
		if (position >= 0 && position < count) {
			return elements[position];
		}
		
		// Normally, an exception should be thrown here.
		System.out.println("Given position is not valid for the list.");		
		return null;
	}
	
	public int count() {
		return this.count;
	}
	
	private void extendElements() {
		T[] extendedArray = (T[])new Object[elements.length * 2];
		for (int i = 0; i < elements.length; i++) {
			extendedArray[i] = elements[i];
		}
		elements = extendedArray;
	}

	@Override
	public Iterator iterator() {		
		return new Iterator() {
			private int currentPosition;

			@Override
			public boolean hasNext() {
				return currentPosition < count;
			}

			@Override
			public Object next() {
				return elements[currentPosition++];
			}
		};
	}

}
