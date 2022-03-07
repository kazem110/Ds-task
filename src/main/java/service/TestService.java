package service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.logging.Log;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Department;
import repository.TestRepo;

import flexjson.JSONSerializer;

@Service
public class TestService {

	@Autowired
	private TestRepo testRepo;
//	
//	public Employee getEmployeeById(Long id) throws IOException  {
//		return testRepo.FindById(id);

	public List<Department> getEmployeeByDepartment_Name(String name) throws IOException {

		return testRepo.findByName(name);

	}

	public Iterable<Department> addDepartment(Department dept) {

		testRepo.save(dept);
		return testRepo.findAll();
	}

	public List<Department> getAllDepartment() throws IOException {
		return (List<Department>) testRepo.findAll();
	}

	public List<String> insertDepartment(Object object) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		JSONObject jsonObject = new JSONObject(jsonInString);

		JSONArray keys = jsonObject.names();

		for (int i = 0; i < keys.length(); ++i) {

			String key = keys.getString(i);
			String value = jsonObject.getString(key);

			System.out.println("key: " + key + " value: " + value);

		}

		//
//		Iterator<String> keys = jsonObject.keys();
//		jsonObject.keys();
//		while (keys.hasNext()) {
////
//			String key = keys.next();
////
//			String value = (String) jsonObject.getString("Name");
//
//			// System.out.println(value);
//
//			
//			System.out.println("key: " + key + " value: " + value);

//		}

		return null;

	}

}
