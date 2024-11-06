package com.cb.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.cb.constants.FrameworkConstants;
import com.cb.enums.ConfigProperties;
import com.cb.exceptions.PropertyFileUsageException;

public final class ReadPropertyFile {

	private ReadPropertyFile() {

	}

	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();
	static {
		try (FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigfilepath())) {

			property.load(fis);
			/*
			 * for (Object key : property.keySet()) { CONFIGMAP.put(String.valueOf(key),
			 * String.valueOf(property.get(key))); }
			 */
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			}

		} catch (IOException e) {

			e.printStackTrace();
			System.exit(0);
		}

	}

	public static String get(ConfigProperties key) {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new PropertyFileUsageException("Property name " + key + " is not found.Please check config.properties");
			
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

	public static String getValue(String key) {

		if (Objects.isNull(property.get(key.toLowerCase())) || Objects.isNull(key)) {
			throw new PropertyFileUsageException("Property name " + key + " is not found.Please check config.properties");
		}
		return property.getProperty(key.toLowerCase().trim());

	}

}
