package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.beans.Account;
import com.cg.beans.Loan;
import com.cg.beans.Transaction;

public class BankDao implements IBankDao{
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("JpaBank");
    EntityManager em=emf.createEntityManager();
    
    
    
    
	public BankDao()  {
		super();

		
	}
		
	

	
	public int deposit(String id3, int cash3) {
		
			
		
		em.getTransaction().begin();
		TypedQuery<Account> tq = em.createQuery("select acc from Account acc where acc.accountId= ?1", Account.class);
        tq.setParameter(1,id3);
     
        int accBal= tq.getSingleResult().getDepositAmount();
        
        TypedQuery<Account> tl = (TypedQuery<Account>) em.createQuery("update Account acc set acc.depositAmount = ?1 where acc.accountId= ?2");
        tl.setParameter(1, accBal+cash3);
        tl.setParameter(2, id3);
    
        int i=tl.executeUpdate();
       
       em.getTransaction().commit();
       if(i>0)
		return accBal+cash3;
	   return -1;
	}

	public int withdraw(String id4, int cash4)  {
		
		
		em.getTransaction().begin();
		TypedQuery<Account>  tq = em.createQuery("select acc from Account acc where acc.accountId= ?1",Account.class);
        tq.setParameter(1,id4);
     
        int accBal= tq.getSingleResult().getDepositAmount();
        
        TypedQuery<Account> tl = (TypedQuery<Account>) em.createQuery("update Account acc set acc.depositAmount = ?1 where acc.accountId= ?2");
        tl.setParameter(1, accBal-cash4);
        tl.setParameter(2, id4);
    
        int i=tl.executeUpdate();
       
       em.getTransaction().commit();
       if(i>0)
		return accBal-cash4;
	   return -1;
	}

	

	public Account AccountDetails(String id5)  {
			
		
		
		return em.find(Account.class, id5) ;
	}

	public void create(Transaction account)  {
		
		em.getTransaction().begin();
		Transaction t = new Transaction();
		t.setAccountId(account.getAccountId());
		t.setAccountName(account.getAccountName());
		t.setAddress(account.getAddress());
		t.setDepositAmount(account.getDepositAmount());
		t.setLoanAmount(account.getLoanAmount());
		t.setLoanId(account.getLoanId());
		t.setLoanType(account.getLoanType());
		
	
		em.persist(t);
		em.getTransaction().commit();
		
		
	}

	public int gLoan(String id7, int cash7) {
		
		em.getTransaction().begin();
		
		TypedQuery<Account> tq = (TypedQuery<Account>) em.createQuery("select acc from Account acc where acc.loanId= ?1");
		
        tq.setParameter(1,id7);
        
        int accBal= ((Loan) tq.getSingleResult()).getLoanAmount();
        
        TypedQuery<Loan> tl = (TypedQuery<Loan>) em.createQuery("update Account acc set acc.loanAmount = ?1 where acc.loanId= ?2");
        
        tl.setParameter(1, accBal+cash7);
        tl.setParameter(2, id7);
    
        int i=tl.executeUpdate();
       
       em.getTransaction().commit();
       if(i>0)
		return accBal+cash7;
	   return -1;

		
	}


	public Loan LoanDetails(String id9)  {
		return (Loan) em.find(Account.class, id9) ;
		
	}

	public int pLoan(String id8, int cash8)  {
		
em.getTransaction().begin();
		
		TypedQuery<Account> tq = (TypedQuery<Account>) em.createQuery("select acc from Account acc where acc.loanId= ?1");
		
        tq.setParameter(1,id8);
        
        int accBal= ((Loan) tq.getSingleResult()).getLoanAmount();
        
        TypedQuery<Loan> tl = (TypedQuery<Loan>) em.createQuery("update Account acc set acc.loanAmount = ?1 where acc.loanId= ?2");
        
        tl.setParameter(1, accBal-cash8);
        tl.setParameter(2, id8);
    
        int i=tl.executeUpdate();
       
       em.getTransaction().commit();
       if(i>0)
		return accBal-cash8;
	   return -1;

		
		
		
}


}
