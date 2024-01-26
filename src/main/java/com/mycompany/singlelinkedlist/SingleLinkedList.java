package com.mycompany.singlelinkedlist;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SingleLinkedList {
    
    public static void main(String[] args) {
        
       Scanner scanner = new Scanner(System.in);
       
       //Creates an instance of ShoppingList
       ShoppingList myShoppingList = new ShoppingList();
       
       do {
            try {
                //Parameters needed for the functions of ShoppingList
                String itemName;
                String itemDescription;
                double itemPrice;

                shoppingListMenu(); //Displays Menu

                System.out.print("Enter Choice: ");
                String choice = scanner.nextLine(); //Action choice of the user

                switch (choice) {
                    case "1": //Insert item at the beginning of the list
                        System.out.println("\nINSERT AN ITEM AT THE BEGINNING OF SHOPPING LIST");

                        //Returns the value inputed by the user
                        itemName = setItemName(scanner); 
                        itemDescription = setItemDescription(scanner); 
                        itemPrice = setItemPrice(scanner); 

                        //Value inputed by the user will be inserted at the beginning of the Shopping List
                        myShoppingList.insertAtBeginning(itemName, itemDescription, itemPrice); 

                        System.out.println("\n" + itemName + " SUCCESSFULLY ADDED!\n");
                        break;

                    case "2": //Insert item after a specified node
                        System.out.println("\nINSERT AN ITEM AT A SPECIFIC NODE OF SHOPPING LIST");

                        System.out.println("Enter the Item Name before the Item that you will add:");
                        String itemBefore = scanner.nextLine(); //Gets the item before inserting the new item

                        //Returns the value inputed by the user
                        itemName = setItemName(scanner); 
                        itemDescription = setItemDescription(scanner); 
                        itemPrice = setItemPrice(scanner); 

                        //Value inputed by the user will be inserted after a specified node of the Shopping List
                        myShoppingList.insertAfterNode(itemName, itemDescription, itemPrice, itemBefore);
                        break;

                    case "3": //Insert item at the end of the list
                        System.out.println("\nINSERT AN ITEM AT THE END OF SHOPPING LIST");

                        //Returns the value inputed by the user
                        itemName = setItemName(scanner);
                        itemDescription= setItemDescription(scanner);
                        itemPrice = setItemPrice(scanner);

                        //Value inputed by the user will be inserted at the end of the Shopping List
                        myShoppingList.insertAtEnd(itemName, itemDescription, itemPrice);

                        System.out.println("\n" + itemName + " SUCCESSFULLY ADDED!\n");
                        break;

                    case "4": //Delete an Item from the Shopping List by item name
                        System.out.println("\nDELETE AN ITEM FROM SHOPPING LIST");

                        itemName = setItemName(scanner);
                        
                        //Item will be deleted from the Shopping List if it exists
                        myShoppingList.deleteShoppingListItem(itemName);
                        break;

                    case "5": //Checks out an Item from the Shopping List by item name
                        System.out.println("\nCHECK OUT AN ITEM");

                        itemName = setItemName(scanner);

                        //Item status will be changed if it exists
                        myShoppingList.setItemToPurchased(itemName);
                        break;

                    case "6": //Diplays the Shopping List
                        myShoppingList.displayList();
                        System.out.println();
                        break;
                        
                    case "7": //Search an Item from the Shopping List by item name
                        System.out.println("\nSEARCH AN ITEM FROM YOUR SHOPPING LIST");
                        
                        itemName = setItemName(scanner);
                        
                        myShoppingList.searchItem(itemName);
                        break;

                    case "8": //Exits the program
                        System.out.println("\nEXITING PROGRAM...");
                        return;

                    default:
                        System.out.println("\nINVALID CHOICE. PLEASE TRY AGAIN\n");
                        break;
                }
           }
           catch (IllegalArgumentException e) { //Catches any illegal argument for the price, e.g. -1
               System.out.println(e.getMessage());
           }
           catch (InputMismatchException e) { //Catches any input mismatch and exits the program
               System.out.println("\nINVALID INPUT! EXITING PROGRAM...");
               return;
           }
        }
        while (true);
    }
    
    //Function to display the Menu
    public static void shoppingListMenu() {
        
        //Choices for inserting an Item in the shopping list
        System.out.println("Enter 1 to insert an Item at the beginning of the Shopping List");
        System.out.println("Enter 2 to insert an Item between beginning and end of the Shopping List");
        System.out.println("Enter 3 to insert an Item at the end of the Shopping List");
        
        //Choices for deleting an Item in the shopping list
        System.out.println("Enter 4 to delete an Item");
        
        //Other choices
        System.out.println("Enter 5 to check out an Item");
        System.out.println("Enter 6 to display Shopping List");
        System.out.println("Enter 7 to seacrh an Item");
        System.out.println("Enter 8 to exit");
    }
    
    //Function to get the Item Name from the user
    public static String setItemName(Scanner scanner) {
        System.out.print("Enter Item Name: ");
        String itemName = scanner.nextLine();
        
        return itemName;
    }
    
    //Function to get the Item Description from the user
    public static String setItemDescription(Scanner scanner) {
        System.out.print("Enter Item Description: ");
        String itemDescription = scanner.nextLine();
        
        return itemDescription;
    }
    
    //Function to get the Item Price from the user
    public static double setItemPrice(Scanner scanner) {
        System.out.print("Enter Item Price: ");
        double itemPrice = scanner.nextDouble();
        scanner.nextLine();
        
        if (itemPrice < 0) {
            throw new IllegalArgumentException("\nINVALID PRICE! PLEASE TRY AGAIN\n");
        }
        
        return itemPrice;
    }
}
