package com.crm.javautility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass {
	Properties prop = new Properties();
	FileInputStream stream;

	public String propdata(String key) throws IOException {

		stream = new FileInputStream("src/test/resources/BaseClass.properties");
		prop.load(stream);
		String data = prop.getProperty(key);
		return (data);

	}
}
