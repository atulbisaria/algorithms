package com.ericsson.algorithms.amazon;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache<K, V> {

	private CacheMap<K, V> cache;
	private ReadWriteLock readWriteLock;

	public LRUCache(int maxEntries) {
		this.cache = new CacheMap<K, V>(maxEntries);
		this.readWriteLock = new ReentrantReadWriteLock();
	}

	public V get(K key) {
		Lock readLock = readWriteLock.readLock();
		
		readLock.lock();
		V value = null;
		try {
			value = cache.get(key);
		} finally {
			readLock.unlock();
		}
		
		return value;
	}
	
	public void put(K key, V value) {
		Lock writeLock = readWriteLock.writeLock();
		
		writeLock.lock();
		try {
			cache.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}
	
	private class CacheMap<M, N> extends LinkedHashMap<K, V> {

		private static final long serialVersionUID = 1L;
		private int maxSize;

		public CacheMap(int maxSize) {
			this.maxSize = maxSize;
		}

		@Override
		protected boolean removeEldestEntry(Entry<K, V> eldest) {
			return cache.size() > maxSize;
		}
	}
}
