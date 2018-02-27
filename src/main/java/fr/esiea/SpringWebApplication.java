package fr.esiea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * /list_items
 *
 * /buy_item?name=coquelicot&quantity=2
 *
 * /add_item?name=coquelicot&sellin=10&quality=40&quantity=5&price=5.77
 */


/**
 * Sample web application.<br/>
 * Run {@link #main(String[])} to launch.
 */
@SpringBootApplication
@RestController
public class SpringWebApplication {
    static HashMap<String, Item> db = new HashMap<>();


    public static void main(String[] args){
        SpringApplication.run(SpringWebApplication.class);
        Runnable updateQualityTask = new GildedRose(db);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(updateQualityTask, 0, 15, TimeUnit.MINUTES);
    }

    @RequestMapping("/list_items")
    List<Item> listItems(){
        List<Item> l = new ArrayList<>(db.values());
        return l;
    }

    @RequestMapping("/buy_item")
    String buyItem(@RequestParam("name") String name, @RequestParam("quantity") int quantity){
        HashMap<Item, Integer> cool = new HashMap<>();

        if(!db.containsKey(name)){
            return "Impossible, l'item demandé n'existe pas ou n'est plus disponible.";
        }
        else{
            if(db.get(name).getQuantity() < quantity){
                return "Impossible l'article n'est pas disponible en quantité suffisante.";
            }
            else{
                db.get(name).lowerQuantityBy(quantity);
                if(db.get(name).getQuantity() == 0){
                    db.remove(name);
                }
                return "Achat effectué ! ["+quantity+" "+name+"]";
            }
        }
    }

    @RequestMapping("/add_item")
    String addItem(@RequestParam("name") String name, @RequestParam("sellin") int sellIn, @RequestParam("quality") int quality,
                   @RequestParam("quantity") int qte, @RequestParam("price") double price){

        Item i;
        if(name.equals("Backstage passes to a TAFKAL80ETC concert")){
            i = new ItemBackstagePasses(name, sellIn, quality, qte, price);
        }else if(name.equals("Aged Brie")){
            i = new ItemBrie(name, sellIn, quality, qte, price);
        }else if(name.equals("Sulfuras, Hand of Ragnaros")){
            i = new ItemSulfuras(name, sellIn, quality, qte, price);
        }else{
            i = new Item(name, sellIn, quality,qte, price);
        }

        if (db.containsKey(name)){
            db.get(name).lowerQuantityBy(qte);
            return "Nous venons d'ajouter "+qte+" à votre produit.";
        } else {
            db.put(name, i);
            return "Nous avons ajouté "+name+" à notre liste de produits.";
        }

    }
}
