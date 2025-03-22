public class TestMySinglyLinkedList
{
   public static void main(String[] args)
   {
      MySinglyLinkedList list = new MySinglyLinkedList();
      System.out.println("Get (int location)\n");
      list.add("Bem");
      list.add("Bang");
      list.add("Theory");
      list.add("Theory");
      System.out.println("List before Get method:");
      System.out.println("Contents: " + list);
      System.out.println("Using get method: " + list.get(5));
      
      
      
      System.out.println("Edit Method (Object old, Object newObj)\n");
      MySinglyLinkedList list2 = new MySinglyLinkedList();
      list2.add("Bem");
      list2.add("Bang");
      list2.add("Theory");
      System.out.println("List before edit method:");
      System.out.println("Contents: " + list2);

      System.out.println("Edit:" + list2.edit("Lance", "fsfsf"));
      
      System.out.println("List after edit method:");
      System.out.println("Contents: " + list2);
      
      System.out.println("Edit By Location : " + list2.editByLocation(0, "Bem"));
      System.out.println("List after edit method:");
      System.out.println("Contents: " + list2);
            

      
      
      list2.deleteAll();
      System.out.println("List after deleteAll method:");
      System.out.println("Contents: " + list2);
      
      System.out.println("Edit By Location : " + list2.editByLocation(0, "Yawa"));
      
      System.out.println("List after populating the list:");
      list2.add("Bem");
      list2.add("Bang");
      list2.add("theory");
      list2.add("Jan");
      list2.add("Laroco");
      
      System.out.println("Contents: " + list2);
      
      System.out.println("Insert By Location : " + list2.insert("Laroco", 3 ));
      
      System.out.println("Contents: " + list2);
      
   }
}