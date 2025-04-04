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
   
   public Object enqueue(Object value)
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
   
   public String toString()
   {
      String result ="[";
      if(!isEmpty())
      {
         MyNode tempTop = top;
         while(tempTop.getNext() != null)
         {
            tempTop = tempTop.getNext();
            result = result + "<-" +tempTop.getItem().toString();
            
         }
         
         
      }
      result = result + "]";
      return result;
   }
   

}