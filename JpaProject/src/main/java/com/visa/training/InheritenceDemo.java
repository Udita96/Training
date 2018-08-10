package com.visa.training;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.visa.training.domain.Account;
import com.visa.training.domain.CurrentAccount;
import com.visa.training.domain.SavingsAccount;
import com.visa.training.util.JpaUtil;

public class InheritenceDemo {

	public static void main(String[] args) {
		List<Integer> l = createAccounts();
		l.forEach(System.out::println);
		printAccounts(l);

	}
	
	private static void printAccounts(List<Integer> idList){
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		Account a1 = em.find(Account.class, idList.get(0));
		Account a2 = em.find(Account.class, idList.get(1));
		System.out.println(a1);
		System.out.println(a2);
		em.close();
	}


	private static List<Integer> createAccounts() {
		List<Integer> ids =  new ArrayList<>();
		EntityManager em  = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		SavingsAccount sa = new SavingsAccount(10000);
		CurrentAccount ca = new CurrentAccount(10000,500000);
		em.persist(sa);
		em.persist(ca);
		tx.commit();
		em.close();
		ids.add(sa.getId());
		ids.add(ca.getId());
		return ids;
	}

}
