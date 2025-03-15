public class TestMySinglyLinkedList {
   public static void main(String[] args) {
       // Test Add method
       System.out.println("Testing Add Method:");
       MySinglyLinkedList list = new MySinglyLinkedList();
       System.out.println("Initial List: " + list); // Should print empty list
       list.Add("Bem");
       list.Add("Bang");
       list.Add("Theory");
       list.Add("Theory"); // Adding a duplicate (if duplicates are allowed)
       System.out.println("List after adding items: " + list); // Should print [Bem] -> [Bang] -> [Theory] -> [Theory] ->

       // Test Search method
       System.out.println("\nTesting Search Method:");
       System.out.println("Search for 'Bem': " + list.Search("Bem")); // Should return true
       System.out.println("Search for 'Laroco': " + list.Search("Laroco")); // Should return false

       // Test SearchTwo method
       System.out.println("\nTesting SearchTwo Method:");
       System.out.println("Index of 'Bem': " + list.SearchTwo("Bem")); // Should return 0
       System.out.println("Index of 'Theory': " + list.SearchTwo("Theory")); // Should return 2
       System.out.println("Index of 'Laroco': " + list.SearchTwo("Laroco")); // Should return -1

       // Test Delete method
       System.out.println("\nTesting Delete Method:");
       System.out.println("Delete 'Bem': " + list.Delete("Bem")); // Should return true
       System.out.println("List after deleting 'Bem': " + list); // Should print [Bang] -> [Theory] -> [Theory] ->
       System.out.println("Delete 'Laroco': " + list.Delete("Laroco")); // Should return false (item not found)
       System.out.println("List after attempting to delete 'Laroco': " + list); // Should remain unchanged

       // Test DeleteByLocation method
       System.out.println("\nTesting DeleteByLocation Method:");
       System.out.println("Delete item at location 1: " + list.DeleteByLocation(1)); // Should return true
       System.out.println("List after deleting item at location 1: " + list); // Should print [Bang] -> [Theory] ->
       System.out.println("Delete item at location 5: " + list.DeleteByLocation(5)); // Should return false (invalid location)
       System.out.println("List after attempting to delete at invalid location: " + list); // Should remain unchanged

       // Test Get method
       System.out.println("\nTesting Get Method:");
       System.out.println("Get item at location 0: " + list.Get(0)); // Should return "Bang"
       System.out.println("Get item at location 1: " + list.Get(1)); // Should return "Theory"
       System.out.println("Get item at location 5: " + list.Get(5)); // Should return null (invalid location)

       // Test Edit method
       System.out.println("\nTesting Edit Method:");
       System.out.println("Edit 'Theory' to 'Laroco': " + list.Edit("Theory", "Laroco")); // Should return true
       System.out.println("List after editing 'Theory' to 'Laroco': " + list); // Should print [Bang] -> [Laroco] ->
       System.out.println("Edit 'Bem' to 'NewItem': " + list.Edit("Bem", "NewItem")); // Should return false (old item not found)
       System.out.println("List after attempting to edit non-existent item: " + list); // Should remain unchanged

       // Test isEmpty method
       System.out.println("\nTesting isEmpty Method:");
       System.out.println("Is the list empty? " + list.isEmpty()); // Should return false
       list.DeleteByLocation(0);
       list.DeleteByLocation(0);
       System.out.println("Is the list empty after deleting all items? " + list.isEmpty()); // Should return true

       // Test getCount method
       System.out.println("\nTesting getCount Method:");
       System.out.println("Number of items in the list: " + list.getCount()); // Should return 0
       list.Add("NewItem1");
       list.Add("NewItem2");
       System.out.println("Number of items after adding two items: " + list.getCount()); // Should return 2

       // Test toString method
       System.out.println("\nTesting toString Method:");
       System.out.println("Current list contents: " + list); // Should print [NewItem1] -> [NewItem2] ->
   }
}