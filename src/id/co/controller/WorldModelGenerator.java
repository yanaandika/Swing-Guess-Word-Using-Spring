/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.controller;

import id.co.model.Category;
import id.co.model.WordModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author user
 */
public class WorldModelGenerator {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SwingGuessWordSpringPU");
    List<WordModel> bankSoal;

    public WorldModelGenerator() {
    }
    
    public List<WordModel> kategori(String kata) {
        // DARI CATEGORY NAME KITA BISA MENGAMBIL LAGI OBJECT WORDCATEGORY
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select wc from Category wc where wc.categoryName = :categoryName");
        query.setParameter("categoryName", kata);
        Category wordCategory = (Category) query.getSingleResult();
        bankSoal = wordCategory.getWordModels();
        return bankSoal;
    }
    //Cara Pertama, untuk pemanggilanya dengan cara properties dan pilih model
    public List<Category> getWordCategories() {
        EntityManager em = emf.createEntityManager();
        List<Category> wordcategories = em.createQuery("Select c from Category c").getResultList();
        return wordcategories;
    }

    public String[] getWordCategoryNames() {
        List<Category> wordCats = getWordCategories();
        int size = wordCats.size();
        String[] categoryNames = new String[size];
        for (int i = 0; i < size; i++) {
            categoryNames[i] = wordCats.get(i).getCategoryName();
        }
        System.out.println("Jumlah kategori: " + size);
        return categoryNames;
    }
    
    //Lalu pilih custom code dan copy kata getWord()
    public DefaultComboBoxModel getWord() {
        return new DefaultComboBoxModel(getWordCategoryNames());
    }
}
