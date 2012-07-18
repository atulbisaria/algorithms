package com.ericsson.algorithms.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BurgerShop {

	public Burger takeOrder(Map<String, Boolean> order) {
		Burger.Builder builder = new Burger.Builder();
		
		Set<String> keySet = order.keySet();
		for (String key : keySet) 
			builder.add(key, order.get(key));
		
		return builder.build();
	}

}

class Burger {

	private final Map<String, Boolean> properties;

	private Burger(Builder builder) {
		this.properties = new HashMap<String, Boolean>(builder.properties);
	}

	public static class Builder {

		private final Map<String, Boolean> properties;
		
		public Builder() {
			this.properties = new HashMap<String, Boolean>();
		}
		
		public Builder add(String property, boolean value) {
			properties.put(property, value);
			return this;
		}

		public Burger build() {
			return new Burger(this);
		}
	}
}

class Constants {
	
	private Constants() {
		
	}
}
