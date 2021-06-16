package com.tfm.planitnow.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Integer a = null; 
		System.out.println("Hola "+  a);
		
		User u = new User("manolo");
		u.setName("Manolito");
		u.setBiography("Me gusta el voley");
		
		System.out.println(u.toString());

		Plan p = new Plan("Plan de Playa","Jugar al Voley");
		p.setOwner(u);
		p.setLocation("Valencia");
		p.setInit_hour(5);
		p.setEnd_hour(8);
		p.setInit_date(new Date());
		p.setEnd_date(new Date());
		
		Set<PlanType> cjto = new HashSet<PlanType>();
		
		cjto.add(PlanType.EVENTS);
		cjto.add(PlanType.MUSIC);
		
		p.setPlan_types(cjto);
		
		System.out.println(p.toString());
		System.out.println(p.getPlan_types().toString());
		
		
		
	}

}
