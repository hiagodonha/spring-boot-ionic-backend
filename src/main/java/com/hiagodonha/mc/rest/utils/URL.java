package com.hiagodonha.mc.rest.utils;

import java.util.ArrayList;
import java.util.List;

public class URL {

	public static List<Integer> decodeListInt (String s){
		String[] vet = s.split(",");
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < vet.length; i++) {
			list.add(Integer.parseInt(vet[i]));
		}
		return list;
	}
}
