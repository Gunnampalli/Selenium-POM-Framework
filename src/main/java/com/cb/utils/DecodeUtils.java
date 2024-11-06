package com.cb.utils;

import java.util.Base64;

public final class DecodeUtils {

	private DecodeUtils() {

	}

	public static String getDecode(String decoder) {
		return new String(Base64.getDecoder().decode(decoder.getBytes()));
	}

}
