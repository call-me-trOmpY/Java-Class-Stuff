/*
Date: 10/16/2020
Juan Carlos Alfonso Vina
Class:  CITC 1314    -  Java Programming
Assignment: Lab6 - Using classes and methods
*/

public class Item {

    private int itemNum;
    private String itemDesc;
    private float cost;

    public Item() {
        itemNum = 0;
        itemDesc = "";
        cost = 0f;
    }

    public Item(int itemNum, String itemDesc, float cost) {
        this.itemNum = itemNum;
        this.itemDesc = itemDesc;
        this.cost = cost;

    }

    // Return an int representing getItemNum
    public int getItemNum() {
        return itemNum;
    }

    // Sets the setItemNum from supplied int parameter
    public void setItemNum(int i) {
        this.itemNum = i;
    }

    // Return a String representing getItemDesc
    public String getItemDesc() {
        return itemDesc;
    }

    // Sets the setItemDesc from supplied String parameter
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;

    }

    // Return a float representing getCost
    public float getCost() {
        return cost;
    }

    // Sets the setCost from supplied float parameter
    public void setCost(float cost) {
        this.cost = cost;
    }

}
