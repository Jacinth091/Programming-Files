class MyArrayList{
    
    private Object[] items;
    private int count;
    
    public MyArrayList(){
        this(10);
    }
    
    
    public MyArrayList(int size){   
        if(size >= 5 && size <=50){
            items = new Object[size];
        }
        else{
            items = new Object[10];
        }
        
        count=0;
        
    }
    
    public boolean search(Object o){
        if(!isEmpty()){
            for(int i =0;i < count; i++){
                if(items[i].toString().equals(o.toString())){
                    return true;
                }
            }
        }
        
        return false;
    }
    public int searchPart2(Object o){
        if(!isEmpty()){
            for(int i =0;i < count; i++){
                if(items[i].toString().equals(o.toString())){
                    return i;
                }
            }
        }
        
        return -1;
    }
    
    public Object get(int location){
        if(!isEmpty() && isLocationValid(location)){
            return items[location];
        }
        return null;
    }
    
    public boolean add(Object o){
        if(!isFull()){
            items[count] = o;
            count = count +1;
            return true;
        }
        
        return false;
    }
    
    public boolean remove(Object o ){
        if(!isEmpty()){
            int loc = searchPart2(o);
            if(loc != -1){
                items[loc] = items[count-1];
                items[count -1] = null;
                count = count -1;
                return true;
            }
        }
        
        return false;
    }
    
        
    public boolean remove(int location){
        if(!isEmpty() && isLocationValid(location)){
            items[location] = items[count-1];
            items[count -1] = null;
            count = count -1;
            return true;
        }
        
        return false;
    }
    
    public void display(){
        System.out.print("[ ");
        for(int i =0; i < count ;i++){
            String format =  (i == count) ? items[i].toString() : items[i].toString() + ", ";
            System.out.print(format);
        }
        System.out.println("]");
    }
    
    public boolean edit(Object o, Object newObj){
        
        
        if(!isEmpty()){
            int loc = searchPart2(o);
            
            if(loc != -1){
                items[loc] = newObj;
                return true;
                
            }

        }
        
        return false;
    }
    
    public int getSize(){
        return count;
    }
    
    
    
    
    private boolean isFull()
    {
        return count == items.length;
    }
    
    private boolean isEmpty(){
        return count==0;
    }
    
    private boolean isLocationValid(int location){
        return location >=0 && location <= count-1;
    }
    
}


public class Main{
    public static void main(String[] args){
        MyArrayList maL = new MyArrayList(10);
        
        
        maL.add("Barral");
        maL.add("Laroco");
        maL.add("Satorre");
        maL.add("Abais");
        maL.add("Gesim");
        maL.add("Laporre");
        
        
        maL.display();
        
        maL.edit("Gesim", "AWDawd");
        
        maL.display();
        
        // for(int i =0; i< maL.getSize(); i++){
        //     System.ou
        // }
        
        
        
    }
    
    
}
