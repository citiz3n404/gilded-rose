package fr.esiea;


import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class SpringWebApplicationTest {
    SpringWebApplication swa;

    @Before
    public void setUp() throws Exception {
        swa = new SpringWebApplication();
    }

    @After
    public void cleanHashmap()throws Exception{
        swa.db.clear();
    }

    @Test
    public void list_items(){
        String str = swa.listItems().toString();
        assertEquals("[]", str);
    }

    @Test
    public void buy_wrong_item(){
        String str = swa.buyItem("Test", 10);
        assertEquals("Impossible, l'item demandé n'existe pas ou n'est plus disponible.", str);
    }

    @Test
    public void buy_too_much(){
        swa.addItem("Test", 1, 10,1, 20.2);
        String str = swa.buyItem("Test", 2);
        assertEquals("Impossible l'article n'est pas disponible en quantité suffisante.", str);
    }

    @Test
    public void buy_correct_item(){
        swa.addItem("Test", 1, 10,2, 20.2);
        String str = swa.buyItem("Test", 2);
        assertEquals("Achat effectué ! [2 Test]", str);
    }

    @Test
    public void add_existing_item(){
        swa.addItem("Test", 1, 10,2, 20.2);
        String str = swa.addItem("Test", 1, 10,2, 20.2);
        assertEquals("Nous venons d'ajouter 2 à votre produit.", str);
    }

    @Test
    public void add_new_item(){
        String str = swa.addItem("Test", 1, 10,2, 20.2);
        assertEquals("Nous avons ajouté Test à notre liste de produits.", str);
    }

    @Test
    public void main_test(){
        swa.main(null);
        assertTrue(true);
    }

    @Test
    public void add_brie(){
        String str = swa.addItem("Aged Brie", 1, 10,2, 20.2);
        assertEquals("Nous avons ajouté Aged Brie à notre liste de produits.", str);
    }

    @Test
    public void add_sulfuras(){
        String str = swa.addItem("Sulfuras, Hand of Ragnaros", 1, 10,2, 20.2);
        assertEquals("Nous avons ajouté Sulfuras, Hand of Ragnaros à notre liste de produits.", str);
    }

    @Test
    public void add_backstage_passes(){
        String str = swa.addItem("Backstage passes to a TAFKAL80ETC concert", 1, 10,2, 20.2);
        assertEquals("Nous avons ajouté Backstage passes to a TAFKAL80ETC concert à notre liste de produits.", str);
    }
}