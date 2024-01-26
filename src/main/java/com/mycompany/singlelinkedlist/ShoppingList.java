package com.mycompany.singlelinkedlist;

public class ShoppingList {
    
    private ShoppingListItem head;
    
    //Function to insert an Item at the beginning of ShoppingList
    public void insertAtBeginning(String itemName, String itemDescription, double price) {
        
        //Creates an instance of ShoppingListItem that will be added in the Shopping List
        ShoppingListItem newShoppingListItem = new ShoppingListItem(itemName, itemDescription, price);
        
        if (head == null) { //Checks if Shopping List is empty
            head = newShoppingListItem; // Added item will be first item in the Shopping List
        }
        else { //Shopping List is not empty
            newShoppingListItem.next = head; //Previous first item in the Shopping List will be moved after the newly added Item
            head = newShoppingListItem; //Added item will be at the start of the shopping list
        }
    }
    
    //Function to insert an Item at the end of ShoppingList
    public void insertAtEnd(String itemName, String itemDescription, double price) {
        
        //Creates an instance of ShoppingListItem that will be added in the Shopping List
        ShoppingListItem newShoppingListItem = new ShoppingListItem(itemName, itemDescription, price);
        
        //Temporary node for ShoppingListItem to be used in iteration
        ShoppingListItem current = head;
        
        if (head == null) { 
            head = newShoppingListItem;
        }
        else { //Shopping List is not empty
            while (current.next != null) { // Will iterate Shopping list until the last item
                current = current.next; //Assigns the next item
            }
        }
        
        //After the end of the list it will add the new item for the Shopping List
        current.next = newShoppingListItem; 
    }
    
    //Function to insert an Item after a specified node
    public void insertAfterNode(String itemName, String itemDescription, double price, String itemBefore) {
        
        //Creates an instance of ShoppingListItem that will be added in the Shopping List
        ShoppingListItem newShoppingListItem = new ShoppingListItem(itemName, itemDescription, price);
        
        //Temporary node for ShoppingListItem to be used in iteration
        ShoppingListItem current = head;

        if (head == null) {
            head = newShoppingListItem;
        }

        while (current != null) { // Will iterate Shopping list until the last item
            if (current.getItemName().equalsIgnoreCase(itemBefore)) { 
                newShoppingListItem.next = current.next;
                current.next = newShoppingListItem;
                
                System.out.println("\n" + itemName + " SUCCESSFULLY ADDED AFTER " + itemBefore + "\n");
                return;
            }
                
            current = current.next;
        }
        
        System.out.println("\n" + itemBefore + " IS NOT FOUND IN THE SHOPPING LIST\n");
    }
    
    //Function to delete an Shopping List Item by item name
    public void deleteShoppingListItem(String itemToDelete) {
        
        if (head == null) {
            System.out.println("\nSHOPPING LIST IS EMPTY. CANNOT DELETE\n");
        }
        
        if (head.getItemName().equalsIgnoreCase(itemToDelete)) {
            head = head.next;
            
            System.out.println("\n" + itemToDelete + " SUCCESSFULLY DELETED!\n");
            return;
        }
        
        ShoppingListItem current = head;
        
        while (current.next != null) {
            if (current.next.getItemName().equalsIgnoreCase(itemToDelete)) {
                current.next = current.next.next;
                
                System.out.println("\n" + itemToDelete + " SUCCESSFULLY DELETED!\n");
                return;
            }
            
            current = current.next;
        }

        
        System.out.println("\n" + itemToDelete + " IS NOT FOUND IN THE SHOPPING LIST\n");
    }
    
    //Function to check out an Item from Shopping List
    public void setItemToPurchased(String itemName) {
        
        if (head == null) {
            System.out.println("\nSHOPPING LIST IS EMPTY.\n");
        }
        
        ShoppingListItem current = head;
        
        while (current != null) {
            if (current.getItemName().equalsIgnoreCase(itemName)) {
                current.setIsPurchased(true);
                
                System.out.println("\nITEM STATUS: " + itemName + " IS SET TO CHECKED OUT\n");
                return;
            }
            
            current = current.next;
        }
        
        System.out.println("\n" + itemName + " IS NOT FOUND IN THE SHOPPING LIST\n");
    }
    
    //Function to display Shopping List
    public void displayList() {
        
        System.out.println("\n========================= MY SHOPPING LIST ========================");
        
        if (head == null) {
            System.out.println("SHOPPING LIST IS EMPTY.");
            System.out.println("===================================================================");
        }
        
        ShoppingListItem current = head;
        
        while (current != null) {
            
            if (current.isPurchased()) {
                System.out.println("ALREADY PURCHASED " + current.getItemName());
                System.out.println("===================================================================");
            }
            else {
                System.out.println("Item Name: " + current.getItemName());
                System.out.println("Item Description: " + current.getItemDescription());
                System.out.println("Item Price: " + current.getItemPrice());
                System.out.println("Item Status: On Cart");
                System.out.println("===================================================================");
            }
            
            current = current.next;
        }
        
    }
    
    public void searchItem(String itemName) {
        
        if (head == null) {
            System.out.println("\nSHOPPING LIST IS EMPTY.\n");
        }
        else {
            ShoppingListItem current = head;
            
            while (current != null) {
                if (current.getItemName().equalsIgnoreCase(itemName)) {
                    System.out.println("\n" + itemName + " FOUND IN THE SHOPPING LIST!\n");
                    return;
                }
                
                current = current.next;
            }
        }
        
        System.out.println("\n" + itemName + " NOT FOUND IN THE SHOPPING LIST!\n");
    }
}
