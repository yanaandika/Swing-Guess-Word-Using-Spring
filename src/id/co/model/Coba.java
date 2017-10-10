/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author retere
 */
public class Coba {
     public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SwingGuessWordSpringPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Category hewan = new Category();
        hewan.setCategoryName("Buah");
        em.persist(hewan);
        
        WordModel wm = new WordModel();
        wm.setBasicWord("Apel");
        wm.setHint("Manis");
        
        WordModel wm2 = new WordModel();
        wm2.setBasicWord("Durian");
        wm2.setHint("Baunya Banget");
        
        em.persist(wm);
        em.persist(wm2);
        wm.setCategory(hewan);
        wm2.setCategory(hewan);
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();
     }    
}
