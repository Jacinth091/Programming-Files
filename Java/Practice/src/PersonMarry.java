/*
    Name: Barral, Jacinth Cedric C.
    Date: Febuary 15, 2025

*/

class Person{
    
    private String lastName, firstName, middleName;
    private char sex;
    private String maidenName, tempMiddleName;
    private boolean isDivorced, isMarried;
    
    
    public Person(String lastName, String firstName, String middleName, char sex){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.sex = sex;
        maidenName = "";
        tempMiddleName = "";
        isDivorced = false;
        isMarried = false;
    }
    
    public void display(){
        System.out.printf("%s, %s %s (%c)\n", getLastName(), getFirstName(), getMiddleName(), getSex());
        
    }
    public void marry(Person p){
        
        if(this.isMarried == true || p.getIsMarried() == true){
            System.out.println("Sorry you cannot marry another person yet..");
        }
        else{
                if
            (
                ((this.sex  == 'M' || this.sex == 'm') && (p.getSex() == 'M' || p.getSex() == 'm'))
                ||
                ((this.sex  == 'F' || this.sex == 'f') && (p.getSex() == 'F' || p.getSex() == 'f'))
            )
            {
                System.out.println("Sorry, this program cannot process this request...");
            }
            else{
                if(this.sex == 'F' || this.sex =='f'){
                    this.maidenName = this.lastName;
                    this.tempMiddleName = middleName;
                    this.middleName = this.lastName;
                    this.lastName = p.getLastName();
                    this.isMarried = true;
                    
                }
                else{
                    p.setMaidenName(p.getLastName());
                    p.setMiddleName(p.getLastName());
                    p.setMiddleName(p.getLastName());
                    p.setLastName(this.lastName);
                    p.isMarried = true;
                    
                }
            }
        
        }
        
        
        
    }
    
    public void divorce(Person p){
        if(isMarried && (this.sex == 'F' || this.sex == 'f')){
            this.lastName = this.maidenName;
            this.middleName = this.tempMiddleName;
            this.isMarried = false;
            this.isDivorced = true;
            
        }
        else{
            p.setLastName(p.getMaidenName());
            p.setMiddleName(p.getTempMiddleName());
            p.setIsDivorced(true);
            p.setIsMarried(false);
        }
        
    }
    
    public void setLastName(String lastName){
        if(lastName.equals(""))
            System.out.println("Invalid Lastname!");
        else
            this.lastName = lastName;
    }
    public void setFirstName(String firstName){
        if(firstName.equals(""))
            System.out.println("Invalid Firstname!");
        else
            this.firstName = firstName;

    }
    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }
    public void setMaidenName(String maidenName){
        if(!isDivorced && (sex == 'F' || sex == 'f')){
            this.maidenName = maidenName;
        }
        else{
            System.out.println("Person is not divorced!");
        }
    }
    
    public void setTempMiddleName(String tempMiddleName){
        if(!isDivorced && (sex == 'F' || sex == 'f')){
            this.tempMiddleName = tempMiddleName;
        }
        else{
            System.out.println("Person is not divorced!");
        }
    }
    public void setSex(char sex){
        if((sex == 'M' || sex == 'm') || (sex == 'F' || sex == 'f'))
            this.sex = sex;
        else
            System.out.println("Invalid Sex identifier (M or F only)!");
    }
    public void setIsDivorced(boolean isDivorced){
        if(isMarried == false){
            System.out.println("You cannot be divorced when you are not married...");
        }
        else{
            this.isDivorced = isDivorced;
        }
    }
    
    public void setIsMarried(boolean isMarried){
        if(isMarried && isDivorced == false){
            System.out.println("Sorry you cannot marry another person yet...");
        }
        else {
            this.isMarried = isMarried;
        }
    }
    
    public String getLastName(){return lastName;}
    public String getFirstName(){return firstName;}
    public String getMiddleName(){return middleName;}
    public String getMaidenName(){return maidenName;}
    public String getTempMiddleName(){return tempMiddleName;}
    public char getSex(){return sex;}
    public boolean getIsDivorced(){return isDivorced;}
    public boolean getIsMarried(){return isMarried;}
    
    
    
}

public class Main{
    
    public static void main(String[] args){
        Person lalaki = new Person("Santos", " Mario", "J", 'M');
        Person babae = new Person("Quinto", " Luisa", "K", 'F');
        Person lalakiTwo = new Person("Perez", "Mark", "", 'M');
        Person babaeTwo = new Person("Racal", "Maris", "", 'F');
        
        lalaki.display();
        babae.display();
        
        babae.marry(lalaki);
        babae.display();
        
        System.out.println();
        
        // babae.divorce(lalaki);
        // babae.display();
        
        // lalaki.divorce(babae);
        // babae.display();
        
        
        babae.marry(lalakiTwo);
        babae.display();
        
        babaeTwo.marry(lalakiTwo);
        babaeTwo.display();
        
        babaeTwo.divorce(lalaki);
        babaeTwo.display();
        
        

        
    }
    
}
