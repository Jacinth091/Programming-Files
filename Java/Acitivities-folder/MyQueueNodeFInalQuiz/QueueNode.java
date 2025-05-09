

public class QueueNode
{
   private MyNode top;
   // private int count;
   
   
   public QueueNode()
   {
      top = null;
   } 
   
   public boolean isEmpty()
   {
      return top == null;
   }
   
   public boolean isFull()
   {
      return false;
   }
   
   public boolean enqueue(Object value)
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
   public boolean searchQueue(Object valueToCheck)
   {
      if(!isEmpty())
      {
         MyNode tempCurrentTop = top;

         while(tempCurrentTop != null){
            if(tempCurrentTop.getItem().toString().equalsIgnoreCase(valueToCheck.toString()))
            {
               return true;
            }
            tempCurrentTop = tempCurrentTop.getNext();
         }
      }
      return false;

   }

   public boolean destroyQueue()
   {
      if(!isEmpty())
      {
         top = null;
         return true;
      }
      return false;
   }
   
   public boolean dequeue()
   {
      if(!isEmpty())
      {
         if(top != null && top.getNext() == null)
         {
            top = null;
         }
         else
         {
            top = top.getNext();
         }
         return true;
      }
      return false;
   }

   public String toString() {
      if(isEmpty()) {
         return "[]";
      }

      String result = "[";
      MyNode tempTop = top;

      result += tempTop.getItem().toString();
      tempTop = tempTop.getNext();

      while(tempTop != null) {
         result += ", " + tempTop.getItem().toString();
         tempTop = tempTop.getNext();
      }

      result += "]";
      return result;
   }

}