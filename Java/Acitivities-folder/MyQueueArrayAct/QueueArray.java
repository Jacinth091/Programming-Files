public class QueueArray
{
   private Object[] items;
   private int count;
   
   public QueueArray(int size)
   {
      if(size < 5 || size >50)
      {
         items = new Object[10];
      }
      else{
         items = new Object[size];
      }
      count = 0;
   }
   public QueueArray()
   {
      this(10);
   }
   
   public boolean isEmpty()
   {
      return count ==0;
   }
   public boolean isFull()
   {
      return count == items.length;
   }
   
   public boolean enqueue(Object value)
   {
      if(!isFull())
      {
         items[count] = value;
         count = count +1;
         return true;
      }
      return false;
   }
   
   public boolean dequeue()
   {
      if(!isEmpty())
      {
         if(count ==1)
         {
            items[0] = null;
         }
         else
         {
            for(int i=0; i< count-1; i++)
            {
               items[i] = items[i+1];
            }
            items[count-1] =null;
         }
         count = count +1;
         return true;
      }
      return false;
   
   }
   public String toString()
   {
      String result = "[";
      for(int i =0; i< count-1; i++)
      {
         result = result + items[i];
         if(i < count -1)
         {
            result = result + ", ";
         }
      }
      result = result + "]";
      return result;
   }
   
   
   

}