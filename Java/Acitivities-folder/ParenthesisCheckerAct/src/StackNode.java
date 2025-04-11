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
            tempTop = tempTop.getNext();
            count = count + 1;
         }        
      }
      return count;
   }

   // Push
   public boolean push(Object value)
   {
      MyNode newNode = new MyNode();
      newNode.setItem(value);
      if(isEmpty())
      {
        top = newNode;
      }
      else
      {
         MyNode tempTop = top;
         while(tempTop.getNext() != null)
         {
            tempTop = tempTop.getNext();
         }
         tempTop.setNext(newNode);
      
      }
      return true;
   }
   // Pop
   public boolean pop()
   {
      if(!isEmpty())
      {
         if(top.getNext() == null)
         {
            top = null;
         }
         else
         {
            MyNode tempTop = top;
            MyNode tempPrevious = null;
            while(tempTop.getNext() != null)
            {
               tempPrevious = tempTop;
               tempTop = tempTop.getNext();
            }
            tempPrevious.setNext(null);
         
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
   
         if(top.getNext() == null)
         {
            itemToReturn = top.getItem();
         }
         else
         {
            MyNode tempTop = top;
            while(tempTop.getNext() != null)
            {
               tempTop = tempTop.getNext();
            }
            itemToReturn = tempTop.getItem();
         
         }
      }
      return itemToReturn;
   }
   
   
   // toString

   public String toString() {
      String result = "";
      MyNode tempCurrent = top;

      while (tempCurrent != null && tempCurrent.getNext() != null) {
         tempCurrent = tempCurrent.getNext();
      }

      while (tempCurrent != null) {
         result += "[" +  tempCurrent.getItem() + "]\n";
         MyNode tempPrevious = top;
         while (tempPrevious != null && tempPrevious.getNext() != tempCurrent) {
            tempPrevious = tempPrevious.getNext();
         }
         tempCurrent = tempPrevious;
      }

      return result;
   }
   

}