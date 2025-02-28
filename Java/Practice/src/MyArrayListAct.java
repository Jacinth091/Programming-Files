import java.util.Scanner;
public class MyArrayListAct{
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        MyArrayList list = new MyArrayList();
        
        String[] opts ={
            "Create Array",
            "Exit",
        };
        
        String[] mainMenuOpts = {
            "Add",
            "Search",
            "Search 2",
            "Remove 1",
            "Remove 2",
            "Edit 1",
            "Edit 2",
            "Get",
            "Insert",
            "Go Back"
        };
        
        int choice =0;
        boolean exitFlag =false;
        
        
        while(!exitFlag){
            System.out.println("MyArrayList Menu\n");
            
            for(int i =0; i< opts.length; i++){
                System.out.printf("%d. %s\n", (i+1), opts[i]);
            }
            
            System.out.print("\nEnter choice: ");
            choice = in.nextInt();
            in.nextLine();
            switch(choice){
                case 1:
                    System.out.print("\nEnter size: ");
                    list = createArrayList(in);
                    
                    mainMenu(list, mainMenuOpts, in);
                break;
                
                case 2:
                    System.out.println("Now exiting...");
                    exitFlag = true;
                break;
            }
            
        }
        
        
        
        
    }
    
    public static void displayList(MyArrayList list){
        
    }
    
    public static void getValidInput(){
    
    }
    
    public static void mainMenu(MyArrayList list ,String[] array, Scanner in){
        boolean exitFlag = false;
        int choice =0;
        int location =0;
        Object objOld, objNew;
        
        while(!exitFlag){
            System.out.println("\nMain Menu\n");
            System.out.printf("Current List: %s\n", list.toString());
            
            for(int i =0; i < array.length; i++){
                if(i == array.length -1)
                    System.out.println("0. " + array[i]);
                else
                    System.out.printf("%d. %s\n", (i+1), array[i]);
            }
            System.out.print("\nEnter choice: ");
            
            choice = in.nextInt();
            in.nextLine();
            System.out.println();
            
            switch(choice){
                case 1: // Add Items 
                    System.out.println("Add items until the array is full:");
                    
                    for(int i =0; i< list.getSize(); i++){
                        System.out.print("Add item: ");
                        list.add(in.nextLine());
                    }
                    
                    System.out.println("\n" + list.toString());
                    
                break;
                case 2: // Search Returning true or False
                    System.out.printf("List: %s\n", list.toString());
                    System.out.print("Enter what to search: ");
                    if(list.search(in.nextLine())){
                        System.out.println("Item found...");
                    }
                    else{
                        System.out.println("Item not found...");
                    }
                    
                    
                break;
                case 3: // searchPart2 returning the index location of the item in the array
                    System.out.printf("List: %s\n", list.toString());
                    System.out.print("Enter what location of the item to search: ");
                    objOld = in.nextLine();
                    location = list.searchPart2(objOld);
                    
                    if(location != -1){
                        System.out.println("Item found at location " + location);
                    }
                    else{
                        System.out.println("Item not found...");
                    }
                    
                break;
                
                case 4: // Remove function that takes in an Object
                    System.out.printf("List: %s\n", list.toString());
                    System.out.println("Enter what item to remove: ");
                    System.out.print("item to remove: ");
                    objOld = in.nextLine();
                    
                    if(list.remove(objOld)){
                        System.out.println("Item " + objOld + "has been successfully removed.");
                    }
                    else{
                        System.out.println("Remove Unsuccessful...");
                    }
                break;
                
                case 5: // Remove function that takes in the location of the object
                    System.out.printf("List: %s\n", list.toString());
                    System.out.println("Enter what location to remove: ");
                    System.out.print("Location of the item to remove: ");
                    location = list.searchPart2(in.nextInt());
                    in.nextLine();
                    if(list.remove(location)){
                        System.out.println("Item at" + location + "has been successfully removed.");
                    }
                    else{
                        System.out.println("Remove Unsuccessful...");
                    }
                break;
                case 6: // Edit function that takes two object as arguments
                    System.out.printf("List: %s\n", list.toString());
                    
                    System.out.println("Enter what item to edit: ");
                    System.out.print("Object 1: ");
                    objOld = in.nextLine();
                    System.out.print("Object 2: ");
                    objNew = in.nextLine();
                    
                    if(list.edit(objOld, objNew)){
                        System.out.println("\nItem " + objOld + "has been successfully edit.");
                    }
                    else{
                        System.out.println("Edit Unsuccessful...");
                    }
                break;
                case 7: // Edit function that takes in the location of the old object and the new object
                    System.out.printf("List: %s\n", list.toString());
                    System.out.println("Enter what item to remove: ");
                    System.out.print("Location 1: ");
                    location = in.nextInt();
                    in.nextLine();
                    
                    System.out.println();
                    System.out.print("New Object 2: ");
                    objNew = in.nextLine();
                    
                    if(list.edit(location, objNew)){
                        System.out.println("\nItem at " + location+ "has been successfully edited.");
                    }
                    else{
                        System.out.println("Edit Unsuccessful...");
                    }
                break;
                
                case 8: // Get function that returns the index location of the object 
                    System.out.printf("List: %s\n", list.toString());
                    System.out.println("Enter what Item to get:");
                    System.out.print("Item to get: ");
                    location = list.searchPart2(in.nextInt());
                    
                    if(location != -1){
                        System.out.println("\nGetting the item at location " + location + " is " + list.get(location));
                    }
                    else{
                        System.out.println("Unsuccessful getting of item at location " + location);
                    }
                    
                break;
                
                case 9: // Get function that returns the index location of the object 
                    System.out.printf("List: %s\n", list.toString());
                    System.out.println("Enter what item to insert:");
                    System.out.print("Item to insert: ");
            
                    objOld = in.nextLine();
                    System.out.println("\nEnter in what location to insert:");
                    System.out.print("location: ");
                    location = in.nextInt();
                    in.nextLine();
                    
                    if(list.insert(objOld, location)){
                        System.out.println("successfully inserted object: " + objOld + " at location " + location + "...");
                    }
                    else{
                        System.out.println("Unsuccessful insertion of object: " + objOld + " at location " + location + "...");
                    }
                    
                break;
                
                case 0:
                    System.out.println("Going Back to Main Menu");
                    exitFlag =true;
                break;
            }
        }
        
        
        
    }
    
    
    public static MyArrayList createArrayList(Scanner in){
        return new MyArrayList(in.nextInt());
    }
    

    


}
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
        if(!isFull() && !search(o)){
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
    private boolean increase_size(int addSize){
        if(addSize > 0 && (items.length + addSize <= 50)){
            int newSize =items.length + addSize ;
            Object[] temp = new Object[newSize];
            for(int i =0; i< count; i++){
                temp[i] = items[i];
            }
            items= null;
            items = temp;
            return true;
            
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

        if(!isEmpty() && !search(newObj)){
            int loc = searchPart2(o);
            if(loc != -1){
                items[loc] = newObj;
                return true;
            }
        }
        return false;
    }
    public boolean edit(int location, Object newObj){

        if(!isEmpty() && isLocationValid(location) && !search(newObj)){
         items[location] = newObj;
         return true;
        }
        return false;
    }

    public int getSize(){
        return items.length;
    }

    public boolean insert(Object o, int index){
        
        if(increase_size(1) && !isEmpty() && isLocationValid(index)){
            Object temp = items[index];
            items[index] = o;
            items[count] = temp;
            return true;
        }
        return false;
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
    
    
    @Override
    public String toString(){
        String result ="";
        if(!isEmpty()){
            result += "[ ";
            for(int i=0; i < count; i++){
                result += items[i];
                if(i != count -1){
                    result += ", ";
                }
            }   
            result += " ]";
            
        }
        return result;
    }

}
