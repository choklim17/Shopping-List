package com.mycompany.singlelinkedlist;

public class ShoppingListItem {
    
    private String itemName;
    private String itemDescription;
    
    private double itemPrice;
    
    private boolean isPurchased;
    
    ShoppingListItem next;
    
    public ShoppingListItem(String itemName, String itemDescription, double itemPrice) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.isPurchased = false;
        this.next = null;
    }


    //Getters
    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public ShoppingListItem getNext() {
        return next;
    }
    
    public boolean isPurchased() {
        return isPurchased;
    }

    //Setters
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setIsPurchased(boolean isPurchased) {
        this.isPurchased = isPurchased;
    }
    
    public void setNext(ShoppingListItem next) {
        this.next = next;
    }
}
