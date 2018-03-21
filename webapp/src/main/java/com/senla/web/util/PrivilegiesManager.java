package com.senla.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.entity.util.RoleEnum;
import com.senla.handler.GlobalExceptionHandler;

public class PrivilegiesManager {
	static {
		privilegieMap = new HashMap<String, Set<RoleEnum>>();
		loadMapForPath("privilegies.properties");
	}
	private static Map<String, Set<RoleEnum>> privilegieMap;
	private static Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

	public static void loadMapForPath(String path) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try (InputStream fis = loader.getResourceAsStream(path)) {
			Properties props = new Properties();
			props.load(fis);
			for (String key : props.stringPropertyNames()) {
				Set<RoleEnum> rolesSet = new HashSet<RoleEnum>();
				String roles = props.getProperty(key);
				for (String role : roles.split(",")) {
					if (role.equals("student")) {
						rolesSet.add(RoleEnum.STUDENT);
					} else if (role.equals("lecturer")) {
						rolesSet.add(RoleEnum.LECTURER);
					} else if (role.equals("admin")) {
						rolesSet.add(RoleEnum.ADMIN);
					}
				}
				privilegieMap.put(key, rolesSet);
			}
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public static boolean checkPrivilegie(String path, RoleEnum role) {
		Set<RoleEnum> roles = privilegieMap.get(path);
		if (roles != null) {
			return roles.contains(role);

		} else {
			return true;
		}
	}
}
