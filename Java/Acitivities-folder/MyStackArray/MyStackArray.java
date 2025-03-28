class MyStackArray
{
    
    private Object[] items;
    private int count;
    
    public MyStackArray(int size)
    {
        if(size < 5 || size > 50){
            size =10;
        }
        items =new Object[size];
        count =0;
    }
    
    public MyStackArray(){
      this(10);
    }
    
    public boolean isFull()
    {
        return count == items.length;
        
    }
    public boolean isEmpty()
    {
        return count == 0;
    }
    
    public boolean push(Object value)
    {
        if(!isFull())
        {
            items[count] = value;
            count = count + 1;
            return true;
        }
        return false;
    }
    
    public Object peak()
    {
        if(!isEmpty()){
            return items[count -1];
        }
        return null;
    }
    
    public boolean pop()
    {
        if(!isEmpty())
        {
            items[count -1] = null;
            count =count -1;
            return true;
        }
        return false;
        
    }
    
    public String toString()
    {
        String result = "";
        for(int i =count -1; i>=0; i--){
            result += "[ " + items[i] + " ]\n";
        }
        return result;
        
    }
    public int getCount()
    {
      return count;
    }
    
    public int getSize()
    {
      return items.length;
    }
    
}