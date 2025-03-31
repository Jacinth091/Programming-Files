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
   
   
   public String toString()
   {
      String result = "";
      MyNode tempCurrent = top;
      MyNode tempPrevious = top;

      if(!isEmpty())
      {
          while(tempCurrent.next != null || tempPrevious.next != null)
         {
            tempCurrent = tempCurrent.next;
            tempPrevious = tempPrevious.next;
         
         }
         result += "[" + tempCurrent.item.toString() + "]\n";
         tempCurrent = top;
      
         while(tempCurrent != top || tempPrevious != top)
         {
            while(tempCurrent.next != tempPrevious)
            { 
               tempCurrent = tempCurrent.next; 
            }
            result += "[" + tempCurrent.item.toString() + "]\n";
            tempPrevious = tempCurrent;
            tempCurrent = top;
         }

      }

         
      return result;
   }
   

}