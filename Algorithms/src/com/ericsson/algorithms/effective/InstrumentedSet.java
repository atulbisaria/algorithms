package com.ericsson.algorithms.effective;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class InstrumentedSet<E> implements Set<E> {

	private final Set<E> set;
	
	public InstrumentedSet(Set<E> set) {
		this.set = set;
	}

	@Override
	public int size() {
		return set.size();
	}

	@Override
	public boolean isEmpty() {
		return set.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		
		return null;
	}

	@Override
	public Object[] toArray() {
		
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		
		return null;
	}

	@Override
	public boolean add(E e) {
		
		return false;
	}

	@Override
	public boolean remove(Object o) {
		
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		
		return false;
	}

	@Override
	public void clear() {
		
		
	}

}
