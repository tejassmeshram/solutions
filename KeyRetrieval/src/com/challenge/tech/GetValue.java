package com.challenge.tech;

import java.util.Map;

public class GetValue {
	/**
	 * This method assumes the input as a Map & key with 'delimiter' separated
	 * objects e.g. input - {a={b={c=d}}} & key - a/b/c Output - d
	 *
	 * @param input
	 * @param key
	 * @return Value in object, for the mentioned key
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object getValue(Object input, String key, String delimiter) {
		Map<String, Object> map = (Map) input;
		
		if (!key.contains(delimiter)) {
			// If Input doesn't contain a valid key, return null
			if (!map.containsKey(key)) {
				return null;
			}
			return map.get(key);
		}
		
		String[] keys = key.split(delimiter);
		String currentKey = keys[0];
		
		if (!map.containsKey(currentKey)) {
			return null;
		}
		
		// Example: key="address/area", then indexOfNextKey = len("address") + 1 = 8
		int indexOfNextKey = currentKey.length() + 1;
		
		return getValue(map.get(currentKey), key.substring(indexOfNextKey), delimiter);
	}
}