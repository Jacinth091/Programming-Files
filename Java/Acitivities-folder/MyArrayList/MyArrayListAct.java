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
            "Add (Object o)",
            "Search (Object o)",
            "Search 2 (Object o)",
            "Remove (Object o)",
            "Remove (int location)",
            "Edit (Object old, Object new)",
            "Edit (int location, Object new)",
            "Get (int location)",
            "Insert (Object o,  int location)",
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
            
            if(!getValidInput(choice, opts.length, 1)){
                System.out.println("Error: Input is out of range, try again...");
                continue;
            }
            
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
    
    public static boolean getValidInput(int input, int max, int min){
        return (input >=min && input <= max);
    }
    
    public static void mainMenu(MyArrayList list ,String[] array, Scanner in){
        boolean exitFlag = false;
        int choice =0;
        int location =0;
        Object objOld, objNew;
        
        while(!exitFlag){
            System.out.println("\nMain Menu\n");
            System.out.printf("Current List: %s\n", list.toString() + "\n");
            System.out.println("Array Size: " + list.getSize() + "\n");
            System.out.println("Number of Items Inside the List: " + list.getCount() + "\n");
            
            for(int i =0; i < array.length; i++){
                if(i == array.length -1)
                    System.out.println("0. " + array[i]);
                else
                    System.out.printf("%d. %s\n", (i+1), array[i]);
            }
            System.out.print("\nEnter choice: ");
            
            choice = in.nextInt();
            
            if(!getValidInput(choice, array.length, 1) && choice != 0){
                System.out.println("Error: Input is out of range, try again...");
                continue;
            }
            
            in.nextLine();
            System.out.println();
            
            switch(choice){
                case 1: // Add Items 
                    System.out.println("\nAdd items until the array is full:");
                    
                    for(int i =0; i< list.getSize(); i++){
                        System.out.print("\nAdd item: ");
                        objOld = in.nextLine();
                        
                        if(!list.add(objOld)){
                            System.out.println("\nUnsuccessful operation, try again...\n");
                            i = i -1;
                            continue;
                        }
                        else{
                            System.out.printf("\nAdded === %s === in the array successfully...\n", objOld.toString());
                        }

                    }
                    
                    System.out.println("\n" + list.toString());
                    
                break;
                case 2: // Search Returning true or False
                    System.out.printf("List: %s\n", list.toString());
                    System.out.print("Enter what to search: ");
                    objOld = in.nextLine();
                    if(list.search(objOld)){
                        System.out.printf("\nItem === %s === found...\n", list.get(list.searchPart2(objOld)));
                    }
                    else{
                        System.out.printf("\nItem === %s === not found...\n", list.get(list.searchPart2(objOld)));
                    }
                    
                    
                break;
                case 3: // searchPart2 returning the index location of the item in the array
                    System.out.printf("List: %s\n", list.toString());
                    System.out.print("Enter what location of the item to search: ");
                    objOld = in.nextLine();
                    location = list.searchPart2(objOld);
                    
                    if(location != -1){
                        System.out.printf("\nItem === %s === found at location %d...\n", list.get(list.searchPart2(objOld)), location);
                    }
                    else{
                        System.out.printf("\nItem === %s === not found at location %d...\n", list.get(list.searchPart2(objOld)), location);
                    }
                    
                break;
                
                case 4: // Remove function that takes in an Object
                    System.out.printf("List: %s\n", list.toString());
                    System.out.println("\n======== Enter what item to remove from the list========\n");
                    System.out.print("Item to remove: ");
                    objOld = in.nextLine();
                    
                    if(list.remove(objOld)){
                        System.out.println("\nItem " + objOld + "has been successfully removed.\n");
                    }
                    else{
                        System.out.println("\nRemove Unsuccessful...\n");
                    }
                break;
                
                case 5: // Remove function that takes in the location of the object
                    System.out.printf("List: %s\n", list.toString());
                    System.out.println("\n======== Enter the location of the item to remove from the list========\n");
                    System.out.print("Location of the item to remove: ");
                    location = list.searchPart2(list.get(in.nextInt()));
                    
                    in.nextLine();
                    
                    if(list.remove(location)){
                        System.out.println("\nItem at" + location + "has been successfully removed.\n");
                    }
                    else{
                        System.out.println("\nRemove Unsuccessful...\n");
                    }
                    
                break;
                case 6: // Edit function that takes two object as arguments
                    System.out.printf("List: %s\n", list.toString());
                    
                    System.out.println("\n============ Enter what item to edit from the list ============\n ");
                    System.out.print("Item you want to edit from the list: ");
                    objOld = in.nextLine();
                    
                    System.out.println();
                    
                    System.out.print("New item to edit the item you want to edit: ");
                    objNew = in.nextLine();
                    
                    if(list.edit(objOld, objNew)){
                        System.out.println("\nItem " + objOld.toString() + "has been successfully edited to" + objNew.toString() + "...\n");
                    }
                    else{
                        System.out.println("\nEdit Unsuccessful...\n");
                    }
                break;
                case 7: // Edit function that takes in the location of the old object and the new object
                    System.out.printf("List: %s\n", list.toString());
                    System.out.println("\n======== Enter the locations of the item to edit from the list========\n");
                    System.out.print("Location of Item to remove : ");
                    location = in.nextInt();
                    in.nextLine();
                    System.out.println();
                    System.out.print("The item you want to put at location of the item you want to edit: ");
                    objNew = in.nextLine();
                    
                    if(list.edit(location, objNew)){
                        System.out.println("\nItem at location" + location + "has been successfully edited to" + objNew.toString() + "...\n");
                    }
                    else{
                        System.out.println("\nEdit Unsuccessful...\n");
                    }
                break;
                
                case 8: // Get function that returns the index location of the object 
                    System.out.printf("List: %s\n", list.toString());
                    System.out.println("\n============ Enter what item to get from the list ============\n ");
                    System.out.print("Item to get: ");
                    location = list.searchPart2(in.nextInt());
                    System.out.println();
                    
                    if(location != -1){
                        System.out.println("\nGetting the item at location " + location + " is " + list.get(location));
                    }
                    else{
                        System.out.println("Unsuccessful operation, try again...");
                    }
                    
                break;
                
                case 9: // Get function that returns the index location of the object 
                    System.out.printf("List: %s\n", list.toString());
                    System.out.println("\n============ Enter what item to insert and the location from the list ============\n ");
                    System.out.print("\nItem to insert: ");
            
                    objOld = in.nextLine();
                    System.out.println("\nEnter in what location to insert:");
                    System.out.print("\nThe location you want to insert the item: ");
                    
                    location = in.nextInt();
                    in.nextLine();
                    
                    if(list.insert(objOld, location)){
                        System.out.println("\nSuccessfully inserted object: " + objOld + " at location " + location + "...\n");
                    }
                    else{
                        System.out.println("\nUnsuccessful insertion of object: " + objOld + " at location " + location + "...\n");
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
    
    public int getCount(){
        return count;
    }

    public boolean insert(Object o, int index){
        
        if(increase_size(1) && !isEmpty() && isLocationValid(index) && !search(o)){
            Object temp = items[index];
            items[index] = o;
            items[count] = temp;
            count = count + 1;
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
