package com.mercadolibre.json_jackson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mercadolibre.json.type.TypeReference;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mlabarinas
 */
public class JsonTest {

	private static JsonJackson jsonJackson = new JsonJackson();

	@SuppressWarnings("unchecked")
	@Test
	public void stringToJsonTest() throws Exception {
		String jsonString = "{\"id\":1,\"user_id\":2}";

		Map<String, Object> json = (Map<String, Object>) jsonJackson.toJson(jsonString);

		assertNotNull(json);
		assertEquals(2, json.size());
		assertEquals(1, json.get("id"));
		assertEquals(2, json.get("user_id"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void stringToJsonBytesTest() throws Exception {
		String jsonString = "{\"id\":1,\"user_id\":2}";

		Map<String, Object> json = (Map<String, Object>) jsonJackson.toJson(jsonString.getBytes());

		assertNotNull(json);
		assertEquals(2, json.size());
		assertEquals(1, json.get("id"));
		assertEquals(2, json.get("user_id"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void stringToJsonMapTest() throws Exception {
		String jsonString = "{\"id\":1,\"user_id\":2}";

		Map<String, Object> json = jsonJackson.toJsonMap(jsonString);

		assertNotNull(json);
		assertEquals(2, json.size());
		assertEquals(1, json.get("id"));
		assertEquals(2, json.get("user_id"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void stringToJsonMapBytesTest() throws Exception {
		String jsonString = "{\"id\":1,\"user_id\":2}";

		Map<String, Object> json = jsonJackson.toJsonMap(jsonString.getBytes());

		assertNotNull(json);
		assertEquals(2, json.size());
		assertEquals(1, json.get("id"));
		assertEquals(2, json.get("user_id"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void stringToJsonListTest() throws Exception {
		String jsonString = "[{\"id\":1,\"user_id\":2}]";

		List<Map<String, Object>> json = jsonJackson.toJsonList(jsonString);

		assertNotNull(json);
		assertEquals(1, json.size());
		assertEquals(2, json.get(0).size());
		assertEquals(1, json.get(0).get("id"));
		assertEquals(2, json.get(0).get("user_id"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void stringToJsonListBytesTest() throws Exception {
		String jsonString = "[{\"id\":1,\"user_id\":2}]";
		
		List<Map<String, Object>> json = jsonJackson.toJsonList(jsonString.getBytes());
		
		assertNotNull(json);
		assertEquals(1, json.size());
		assertEquals(2, json.get(0).size());
		assertEquals(1, json.get(0).get("id"));
		assertEquals(2, json.get(0).get("user_id"));
	}

	@Test
	public void stringToObjectTest() throws Exception {
		String jsonString = "{\"id\":1,\"user_id\":2}";

		Mock mock = jsonJackson.toObject(jsonString, Mock.class);

		assertNotNull(mock);
		assertEquals(mock.getClass(), Mock.class);
		assertEquals(1, mock.getId());
		assertEquals(2, mock.getUserId());
	}

	@Test
	public void stringToObjectBytesTest() throws Exception {
		String jsonString = "{\"id\":1,\"user_id\":2}";

		Mock mock = jsonJackson.toObject(jsonString.getBytes(), Mock.class);

		assertNotNull(mock);
		assertEquals(mock.getClass(), Mock.class);
		assertEquals(1, mock.getId());
		assertEquals(2, mock.getUserId());
	}

	@Test
	public void stringToObjectTypeReferenceTest() throws Exception {
		String jsonString = "[{\"id\":1,\"user_id\":2}]";

		List<Mock> mock = jsonJackson.toObject(jsonString, new TypeReference<List<Mock>>() {});

		assertNotNull(mock);
		assertEquals(mock.getClass(), ArrayList.class);
		assertEquals(mock.size(), 1);
		assertEquals(mock.get(0).getClass(), Mock.class);
		assertEquals(1, mock.get(0).getId());
		assertEquals(2, mock.get(0).getUserId());
	}

	@Test
	public void stringToObjectTypeReferenceBytesTest() throws Exception {
		String jsonString = "[{\"id\":1,\"user_id\":2}]";

		List<Mock> mock = jsonJackson.toObject(jsonString.getBytes(), new TypeReference<List<Mock>>() {});

		assertNotNull(mock);
		assertEquals(mock.getClass(), ArrayList.class);
		assertEquals(mock.size(), 1);
		assertEquals(mock.get(0).getClass(), Mock.class);
		assertEquals(1, mock.get(0).getId());
		assertEquals(2, mock.get(0).getUserId());
	}

	@Test
	public void stringToObjectJavaTypeTest() throws Exception {
		String jsonString = "[{\"id\":1,\"user_id\":2}]";

		List<Mock> mock = jsonJackson.toObject(jsonString, jsonJackson.getMapper().getTypeFactory().constructCollectionLikeType(List.class, Mock.class));

		assertNotNull(mock);
		assertEquals(mock.getClass(), ArrayList.class);
		assertEquals(mock.size(), 1);
		assertEquals(mock.get(0).getClass(), Mock.class);
		assertEquals(1, mock.get(0).getId());
		assertEquals(2, mock.get(0).getUserId());
	}

	@Test
	public void stringToObjectJavaTypeBytesTest() throws Exception {
		String jsonString = "[{\"id\":1,\"user_id\":2}]";

		List<Mock> mock = jsonJackson.toObject(jsonString.getBytes(), jsonJackson.getMapper().getTypeFactory().constructCollectionLikeType(List.class, Mock.class));

		assertNotNull(mock);
		assertEquals(mock.getClass(), ArrayList.class);
		assertEquals(mock.size(), 1);
		assertEquals(mock.get(0).getClass(), Mock.class);
		assertEquals(1, mock.get(0).getId());
		assertEquals(2, mock.get(0).getUserId());
	}

	@Test
	public void stringToObjectListTest() throws Exception {
		String jsonString = "[{\"id\":1,\"user_id\":2}]";

		List<Mock> mock = jsonJackson.toObjectList(jsonString, Mock.class);

		assertNotNull(mock);
		assertEquals(mock.getClass(), ArrayList.class);
		assertEquals(mock.size(), 1);
		assertEquals(mock.get(0).getClass(), Mock.class);
		assertEquals(1, mock.get(0).getId());
		assertEquals(2, mock.get(0).getUserId());
	}

	@Test
	public void stringToObjectListBytesTest() throws Exception {
		String jsonString = "[{\"id\":1,\"user_id\":2}]";

		List<Mock> mock = jsonJackson.toObjectList(jsonString.getBytes(), Mock.class);

		assertNotNull(mock);
		assertEquals(mock.getClass(), ArrayList.class);
		assertEquals(mock.size(), 1);
		assertEquals(mock.get(0).getClass(), Mock.class);
		assertEquals(1, mock.get(0).getId());
		assertEquals(2, mock.get(0).getUserId());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void objectToObjectTest() throws Exception {
		String jsonString = "{\"id\":1,\"user_id\":2}";

		Map<String, Object> json = (Map<String, Object>) jsonJackson.toJson(jsonString);
		Mock mock = jsonJackson.toObject(json, Mock.class);

		assertNotNull(mock);
		assertEquals(mock.getClass(), Mock.class);
		assertEquals(1, mock.getId());
		assertEquals(2, mock.getUserId());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void objectToObjectTypeReferenceTest() throws Exception {
		String jsonString = "[{\"id\":1,\"user_id\":2}]";

		List<Map<String, Object>> json = (List<Map<String, Object>>) jsonJackson.toJson(jsonString);
		List<Mock> mock = jsonJackson.toObject(json, new TypeReference<List<Mock>>() {});

		assertNotNull(mock);
		assertEquals(mock.getClass(), ArrayList.class);
		assertEquals(mock.size(), 1);
		assertEquals(mock.get(0).getClass(), Mock.class);
		assertEquals(1, mock.get(0).getId());
		assertEquals(2, mock.get(0).getUserId());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void objectToObjectJavaTest() throws Exception {
		String jsonString = "[{\"id\":1,\"user_id\":2}]";
		
		List<Map<String, Object>> json = (List<Map<String, Object>>) jsonJackson.toJson(jsonString);
		List<Mock> mock = jsonJackson.toObject(json, jsonJackson.getMapper().getTypeFactory().constructCollectionLikeType(List.class, Mock.class));

		assertNotNull(mock);
		assertEquals(mock.getClass(), ArrayList.class);
		assertEquals(mock.size(), 1);
		assertEquals(mock.get(0).getClass(), Mock.class);
		assertEquals(1, mock.get(0).getId());
		assertEquals(2, mock.get(0).getUserId());
	}
	
	@Test
	public void objectToStringTest() throws Exception {
		Map<String, Object> object = new HashMap<String, Object>();
		
		object.put("id", 1);
		object.put("user_id", 2);
		
		String jsonString = jsonJackson.toJsonString(object);
		
		assertEquals("{\"user_id\":2,\"id\":1}", jsonString);
	}
	
	@Test
	public void validateTest() throws Exception {
		assertTrue(jsonJackson.validate("{\"id\":1,\"user_id\":2}"));
		assertFalse(jsonJackson.validate("{\"id\":1,\"user_id:2}"));
	}
	
	public static class Mock {
		
		private int id;
		private int userId;
		
		public Mock() {
			super();
		}

		@JsonProperty("id")
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JsonProperty("user_id")
		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}
		
	}
	
}