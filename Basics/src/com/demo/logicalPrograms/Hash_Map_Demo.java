package com.demo.logicalPrograms;
// Java code to illustrate the entrySet() method 
import java.util.*; 
  
public class Hash_Map_Demo { 
    public static void main(String[] args) 
    { 
  
        // Creating an empty HashMap 
        HashMap<Integer, Integer> hash_map = new HashMap<Integer, Integer>(); 
  
        // Mapping string values to int keys 
        hash_map.put(10, 1); 
        hash_map.put(10, 2); 
        hash_map.put(20, 1);
        hash_map.put(20, 2); 
        hash_map.put(20, 3); 
       
  
        // Displaying the HashMap 
        System.out.println("Initial Mappings are: " + hash_map); 
  
        // Using entrySet() to get the set view 
        System.out.println("The set is: " + hash_map.entrySet()); 
    } 
} 
