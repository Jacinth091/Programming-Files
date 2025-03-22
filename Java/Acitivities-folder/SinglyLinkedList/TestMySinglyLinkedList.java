public class TestMySinglyLinkedList {
    public static void main(String[] args) {
        MySinglyLinkedList list = new MySinglyLinkedList();

        System.out.println("1. **Add Method (Object o)**: Add some items to the list, including duplicates");
        list.add("Bem");
        list.add("Bang");
        list.add("Theory");
        list.add("Theory"); // Adding a duplicate item
        System.out.println("List after adding elements (with duplicate 'Theory'):");
        System.out.println("Contents: " + list);

        
        System.out.println("\n2. **Search Method (search(Object o))**: Check if an item exists in the list");
        System.out.println("Searching for 'Bang': " + (list.search("Bang") ? "'Bang' Found" : "'Bang' Not Found"));
        System.out.println("Searching for 'Lance': " + (list.search("Lance") ? "'Lance' Found" : "'Lance' Not Found"));

        
        System.out.println("\n3. **Search Part 2 (searchPart2(Object o))**: Search and get the index of an item");
        
        int location = list.searchPart2("Bang");
        if (location != -1) {
            System.out.println("Found 'Bang' at location: " + location);
        } else {
            System.out.println("'Bang' not found in the list");
        }

        location = list.searchPart2("Theory");
        if (location != -1) {
            System.out.println("Found 'Theory' at location: " + location);
        } else {
            System.out.println("'Theory' not found in the list");
        }

        location = list.searchPart2("Lance");
        if (location != -1) {
            System.out.println("Found 'Lance' at location: " + location);
        } else {
            System.out.println("'Lance' not found in the list");
        }

       
        System.out.println("\n4. **Get Method (Object get(int location))**: Retrieve an element at a specific index");
        System.out.println("Using get method to retrieve element at index 2: " + list.get(2));

       
        System.out.println("\n5. **Edit Method (Object old, Object newObj)**: Edit an existing item in the list");
        System.out.println("\nEditing 'Theory' to 'UpdatedTheory':");
        boolean editResult = list.edit("Theory", "UpdatedTheory");
        System.out.println("Edit result: " + (editResult ? "Success" : "Failed"));
        System.out.println("Contents after edit: " + list);

        
        System.out.println("\n6. **Edit By Location (int location, Object newObj)**: Edit item by location");
        System.out.println("\nEditing item at location 1 (second item) to 'ChangedItem':");
        boolean editByLocationResult = list.editByLocation(1, "ChangedItem");
        System.out.println("Edit result: " + (editByLocationResult ? "Success" : "Failed"));
        System.out.println("Contents after edit by location: " + list);

        
        System.out.println("\n7. **Delete Method (delete(Object o))**: Delete an item by value");
        System.out.println("\nDeleting 'Bang' from the list:");
        boolean deleteResult = list.delete("Bang");
        System.out.println("Delete result: " + (deleteResult ? "Success" : "Failed"));
        System.out.println("Contents after deletion: " + list);

        
        System.out.println("\n8. **Delete By Location (deleteByLocation(int location))**: Delete an item by its location");
        System.out.println("\nDeleting item at location 1 (second item):");
        boolean deleteByLocationResult = list.deleteByLocation(1);
        System.out.println("Delete by location result: " + (deleteByLocationResult ? "Success" : "Failed"));
        System.out.println("Contents after deletion by location: " + list);

       
        System.out.println("\n9. **Insert Method (insert(Object o, int location))**: Insert an item at a specific location");
        System.out.println("\nInserting 'NewItem' at location 1:");
        boolean insertResult = list.insert("NewItem", 1);
        System.out.println("Insert result: " + (insertResult ? "Success" : "Failed"));
        System.out.println("Contents after inserting: " + list);

        
        System.out.println("\n10. **Delete All Method (deleteAll())**: Delete all items from the list");
        System.out.println("\nDeleting all items from the list:");
        boolean deleteAllResult = list.deleteAll();
        System.out.println("Delete all result: " + (deleteAllResult ? "Success" : "Failed"));
        System.out.println("Contents after deleteAll: " + list);

        
        System.out.println("\n11. **Add More Items After Deletion**: Re-populate the list");
        list.add("Bem");
        list.add("Bang");
        list.add("Theory");
        list.add("Jan");
        list.add("Laroco");
        System.out.println("Contents after re-populating: " + list);

        
        System.out.println("\n12. **Insert at the Start (index 0) and End**:");
        System.out.println("\nInserting 'Start' at index 0 (beginning of the list):");
        list.insert("Start", 0);
        System.out.println("Contents after inserting 'Start': " + list);

        System.out.println("\nInserting 'End' at the end of the list:");
        list.insert("End", list.getCount() - 1);
        System.out.println("Contents after inserting 'End': " + list);

        
        System.out.println("\n13. **Final List**: Final check of the list contents:");
        System.out.println("Contents: " + list);
    }
}
