 package MyStackNodeAct;
public class StackNode
{
   private MyNode top;
   
   public StackNode()
   {
      top = null;
   
   }
   
   public boolean isEmpty()
   {
      return top == null;
   }
   
   public int getCount()
   {
      int count = 0;
      if(!isEmpty())
      {
         MyNode tempTop = top;
         while(tempTop != null)
         {
            tempTop = tempTop.next;
            count = count + 1;
         }        
      }
      return count;
   }
   
   // Push 
   public boolean push(Object value)
   {
      MyNode newNode = new MyNode(value);
      if(isEmpty())
      {
        top = newNode;
      }
      else
      {
         MyNode tempTop = top;
         while(tempTop.next != null)
         {
            tempTop = tempTop.next;
         }
         tempTop.next = newNode;
      
      }
      return true;
   }
   // Pop
   public boolean pop()
   {
      if(!isEmpty())
      {
         if(top.next == null)
         {
            top = null;
         }
         else
         {
            MyNode tempTop = top;
            MyNode tempPrevious = null;
            while(tempTop.next != null)
            {
               tempPrevious = tempTop;
               tempTop = tempTop.next;
            }
            tempPrevious.next = null;
         
         }
         return true;
      }
      return false;

   }
   
   
   
   // Peek
   public Object peek()
   {
      Object itemToReturn = null;
      if(!isEmpty())
      {
   
         if(top.next == null)
         {
            itemToReturn = top.item;
         }
         else
         {
            MyNode tempTop = top;
            while(tempTop.next != null)
            {
               tempTop = tempTop.next;
            }
            itemToReturn = tempTop.item;
         
         }
      }
      return itemToReturn;
   }
   
   
   // toString
   
   
   public String toString() {
    if (isEmpty()) {
        return "";  // Return empty if stack is empty
    }

    StringBuilder result = new StringBuilder();
    MyNode current = top;

    // First, find the bottom node (last node)
    MyNode bottom = null;
    while (current != null) {
        bottom = current;  // Update bottom until we reach the end
        current = current.next;
    }

    // Now traverse from bottom back to top
    current = bottom;
    while (current != null) {
        // To move upwards, we need to find the previous node (since it's singly linked)
        // This requires re-traversing from the top each time (not efficient, but works)
        MyNode prev = top;
        while (prev != null && prev.next != current) {
            prev = prev.next;
        }
        
        result.append("[").append(current.item).append("]\n");
        current = prev;  // Move to the previous node
    }

    return result.toString();
}
   

}