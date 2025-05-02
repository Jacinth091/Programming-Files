



public class CicularQueue
{
   private MyNode top;
   private MyNode tail;
   // private int count;
   
   
   public CicularQueue()
   {
      top = null;
      tail = null;
   } 
   
   public boolean isEmpty()
   {
      return top == null && tail == null;
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
         tail = newNode;
      }
      else
      {

         while(tail.getNext() != null)
         {
            tail = tail.getNext();
         }
         tail.setNext(newNode);
         tail = tail.getNext();
         // tail = top;
         // tail = tail.getNext();
         tail = top;
         // tail.setNext(top);
      }


      return true;
      
   }
   
   public boolean dequeue()
   {
      if(!isEmpty())
      {
         if(top != null && top.getNext() == null)
         {
            top = null;
            tail = null;
         }
         else
         {
            top = top.getNext();
            tail.setNext(top);
         }
         return true;
      }
      return false;
   }

   public String toString() {
      if(isEmpty()) {
         return "[]";
      }

      String result = "";
      tail = top;
      while(tail.getNext() != null)
      {
         result += "[" + tail.getItem().toString();
         if(tail.getNext() != null)
         {
            result += "]=>";
         }
         tail = tail.getNext();

      }
      
      result += "[" + tail.getItem().toString();
      result += "] => " + "[" + top.getItem().toString();
      result += "]";
      return result;
   }

}