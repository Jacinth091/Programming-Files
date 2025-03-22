public class MySinglyLinkedList 
{
   MyNode top;
   int count;
   
   public MySinglyLinkedList()
   {
      top = null;
      count = 0;
   }
   
   public boolean isEmpty()
   {
      return top == null;
   }
   
   public boolean isFull()
   {
      return false;
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
   
   public boolean isLocationValid(int location)
   {
      return location >= 0 && location <= getCount() - 1;
   }
   
   
   public boolean add(Object o)
   {
      MyNode newNode = new MyNode();
      newNode.item = o;
      
      if(isEmpty())
      {
         top = newNode;
      }
      else 
      {
         if(!search(o))
         {
            MyNode tempTop = top;
            while(tempTop.next != null)
            {
               tempTop = tempTop.next;
            }
            tempTop.next = newNode;    
         }
         
      }
      return true;
      
   }
   
   public boolean search(Object o)
   {
      if(!isEmpty())
      {
         MyNode tempTop = top;
         while(tempTop != null)
         {
            if(tempTop.item.toString().equalsIgnoreCase(o.toString()))
            {
               return true;
            }
            tempTop = tempTop.next;
         }
      }
      return false;
   }
   
   public int searchPart2(Object o)
   {
      if(!isEmpty())
      {
         MyNode tempTop = top;
         int location = 0;
         while(tempTop != null)
         {
            if(tempTop.item.toString().equalsIgnoreCase(o.toString()))
            {
               return location;
            }
            location = location + 1;
            tempTop = tempTop.next;            
         }
      }
      return -1;
   }
   
   
   public boolean delete(Object o)
   {
      if(!isEmpty() && search(o))
      {
         //scenario 1: the list contains only 1 node, that is the top
         //and that top is the node to be deleted
         if(top.item.toString().equalsIgnoreCase(o.toString()) && top.next == null)
         {
            top = null;
            return true;
         }
         //scenario 2: the list contains more than 1 nodes, and the node to be
         //deleted is the top
         else if(top.item.toString().equalsIgnoreCase(o.toString()) && top.next != null)
         {
            top = top.next;
            return true;
         }
         else 
         {
            System.out.println("*");
            //scenario 3: the list contains more that 1 nodes, and the node to be
            //deleted is somewhere in the middle or the last node
            MyNode tempCurrentTop = top;
            MyNode tempPreviousTop = null;
            
            while(tempCurrentTop != null)
            {
               if(tempCurrentTop.item.toString().equalsIgnoreCase(o.toString()))
               {
                  break;
               }
               tempPreviousTop = tempCurrentTop;
               tempCurrentTop = tempCurrentTop.next;
            }
            
            if(tempCurrentTop != null)
            {
               tempPreviousTop.next = tempCurrentTop.next;               
               return true;
            }                        
         }
      }
      return false;
   }
   
   public boolean deleteByLocation(int location)
   {
      if(!isEmpty() && isLocationValid(location))
      {
         //scenario 1: if the location is 0, it means that it is the top
         //node, therefore, set the top to its top next
         if(location == 0)
         {
            top = top.next;
            return true;
         }
         //scenario 2: if the node to be deleted is in the middle of the list
         else 
         {
            int index = 0;
            MyNode tempCurrentTop = top;
            MyNode tempPreviousTop = null;
            while(index < location)
            {
               tempPreviousTop = tempCurrentTop;
               tempCurrentTop = tempCurrentTop.next;
               index = index + 1;
            }
            
            tempPreviousTop.next = tempCurrentTop.next;
            return true;
         }
      }
      return false;
   }
   
   public String toString()
   {
      String result = "";
      if(!isEmpty())
      {
         MyNode tempTop = top;
         while(tempTop != null)
         {
            result += "[" + tempTop.item + "]->";
            tempTop = tempTop.next;
         }
      }
      return result;
   }
   
   //version:
   //get by location
   //public boolean edit(Object old, Object newo)
   
   public Object get(int location)
   {
      if(!isEmpty() && isLocationValid(location))
      {
         int index =0;
         MyNode tempTop = top;

         while(index < location){
            tempTop = tempTop.next;
            index = index + 1;
         }
         if(tempTop != null)
         {
            return tempTop.item;
         }
         
      }
      return false;
   }
   
   public boolean edit(Object old, Object newObj){
      if(!isEmpty() && !search(newObj) && search(old)){
         MyNode tempTop = top;
         while(tempTop != null && !tempTop.item.toString().equalsIgnoreCase(old.toString())){
            tempTop = tempTop.next;
         }
         if(tempTop != null)
         {
            tempTop.item = newObj;
            return true;
         }
         
      }
      return false;
   }
   
  // INSERT METHOD
  
  public boolean insert(Object o, int location)
  {
      if(!isEmpty() && isLocationValid(location) && !search(o))
      {
         MyNode newNode = new MyNode();
         newNode.item =o;
         if(location == 0)
         {
            MyNode tempTop = top;
            top = newNode;
            newNode.next = tempTop;
                        
         }
         else
         {
            MyNode tempCurrentTop = top;
            MyNode tempPreviousTop = null;
            int index =0;
            
            while(index < location)
            {
               tempPreviousTop = tempCurrentTop;
               tempCurrentTop = tempCurrentTop.next;
               index = index + 1;
            
            }
            tempPreviousTop.next = newNode;
            newNode.next= tempCurrentTop; 
         
         }
         return true;      
         
      }

      return false;
  }
  // Delete All
  public boolean deleteAll()
  {
      if(!isEmpty())
      {
         top = null;
         return true;
      }
      return false;
  }
  
  // Edit By Location
  public boolean editByLocation( int location, Object newObj)
  {
      if(!isEmpty() && isLocationValid(location) && !search(newObj)){
         MyNode tempTop = top;
         int index =0;
         while(index < location)
         {
            tempTop = tempTop.next;
            index = index +1;
         } 
         tempTop.item = newObj;
         return true;
      }
      return false;
  }
  

   
}