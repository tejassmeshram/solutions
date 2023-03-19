package com.challenge.tech;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class GetValueFromMapTest {

	@Test
	void testKeyRetrievalLastLevel() {
		GetValue getValueObject = new GetValue();

		Map<String, Object> level3 = new HashMap<String, Object>();
		level3.put("c", "d");

		Map<String, Object> level2 = new HashMap<String, Object>();
		level2.put("b", level3);

		Map<String, Object> input = new HashMap<String, Object>();
		input.put("a", level2); // Input: {a={b={c=d}}}

		String key = "a/b/c";
		String delimiter = "/";

		// Below call returns d
		assertTrue(getValueObject.getValue(input, key, delimiter).equals("d"));
	}
	
	@Test
	void testKeyRetrievalMidLevel() {
		GetValue getValueObject = new GetValue();

		Map<String, Object> level3 = new HashMap<String, Object>();
		level3.put("pincode", "400001");

		Map<String, Object> level2 = new HashMap<String, Object>();
		level2.put("area", level3);

		Map<String, Object> input = new HashMap<String, Object>();
		input.put("address", level2); // Input: {address={area={pincode=400001}}}

		String key = "address;area";
		String delimiter = ";";

		// Below call returns {pincode=400001}, which is same as value in variable level3
		assertTrue(getValueObject.getValue(input, key, delimiter).equals(level3));
	}
	
	@Test
	void testKeyRetrieval() {
		GetValue getValueObject = new GetValue();

		Map<String, Object> level2 = new HashMap<String, Object>();
		level2.put("firstName", "Tejas");
		level2.put("lastName", "Meshram");

		Map<String, Object> input = new HashMap<String, Object>();
		input.put("name", level2); // Input: {name={firstName=Tejas,lastName=Meshram}}

		String key = "name";
		String delimiter = "/";

		// Below call returns {firstName=Tejas,lastName=Meshram}, which is same as value in variable level2
		assertTrue(getValueObject.getValue(input, key, delimiter).equals(level2));
	}

}
