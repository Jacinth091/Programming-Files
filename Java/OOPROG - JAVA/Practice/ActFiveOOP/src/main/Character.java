package src.main;
class Character{
   
    private String name, race, charClass, job, gender;

    public Character(){}
    public Character(String name, String race, String gender, String charClass, String job){

        setName(name);
        setRace(race);
        setClass(charClass);
        setJob(job);
        setGender(gender);
    }

    public void dispAttrib() {
        System.out.println("Character Attributes:");
        System.out.println("Name: " + name);
        System.out.println("Race: " + race);
        System.out.println("Gender: " + gender);
        System.out.println("Class: " + charClass);
        System.out.println("Job: " + job);
    }
    public void setName(String name){
        if(name != null){
            this.name = name;
        }
    }

    public void setRace(String race){
        this.race = race;
    }

    public void setClass(String charClass){
        this.charClass = charClass;
    }

    public void setJob(String job){
        this.job = job;
    }

    public void setGender(String gender){
        this.gender = gender;
    }
   
   



}