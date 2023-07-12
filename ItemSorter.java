import java.util.ArrayList;
import java.util.Collections;
// class room assignment:
// 1. Update Item.java so that ItemSorter can sort the items in number order
// 2. refactor Item.java so they print in alphabetical order
// 3. you may need to add a 4 argument constructor that accepts number,cost,item,manufacturer

public class ItemSorter
{

    public static void main(String [] args)
    {

        ArrayList<Item> al = new ArrayList<>();
        Item itm = new Item(111, 29.99, "Baseketball", "Rawlings" );

        al.add(itm);
        al.add(new Item(200,  399.99, "iPhone",                        "Apple" ));
        al.add(new Item(2000, 199.99, "TV",                            "Sony" ));
        al.add(new Item(3,     14.95, "T-Shirt",                       "Hanes" ));
        al.add(new Item(85 ,    7.99, "2019 Calendar",                 "Random House" ));
        al.add(new Item(45,   399.99, "Avengers Infinity War Blu-Ray", "Marvel Studios" ));

        // uncomment this when you are ready to sort
        //Collections.sort(al);

        for (Item item : al)
        {
           System.out.println(item.getItemNum()+ " : "+item.getItemDesc() + " : " + item.getCost());
        }


    }


}