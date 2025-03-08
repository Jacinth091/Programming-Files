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

      System.out.println("Edit:" + list2.edit("Lance", "Laroco"));
      
      System.out.println("List after edit method:");
      System.out.println("Contents: " + list2);
      
      
   
   }
}