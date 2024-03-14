package com.selim.test;

import com.selim.dao.VeloDao;
import com.selim.entities.Velo;
public class VeloTest {
public static void main(String[] args) {
	System.out.println("selim");
//créer un objet Velo
	
Velo c = new Velo();
c.setNom("RockRider 540");
c.setMarque("BTWEEN");
c.setPrix(1800.00F);

Velo v = new Velo();
v.setNom("Fuel EX 9.8");
v.setMarque("TREK");
v.setPrix(3000.00F);

//ajouter l'objet Velo à la BD
VeloDao cltDao = new VeloDao();
cltDao.ajouter(c);
cltDao.ajouter(v);
System.out.println("Appel de la méthode listerTous");
for (Velo cl : cltDao.listerTous())
System.out.println(cl);
System.out.println("Appel de la méthode listerParNom");
for (Velo cl : cltDao.listerParNom("F"))

System.out.println(cl);

//tester les autres méthodes de la classe VeloDao
}
}