package ActFiveOOP.src.main;
class Character{
   
    private String name, race, charClass, job, gender;

    public Character(){}
    public Character(String name, String race, String charClass, String job, String gender){

        setName(name);
        setRace(race);
        setClass(charClass);
        setJob(job);
        setGender(gender);
    }
    
    public void dispAttrib(){
     
     
     
     
     
     
    }
    public void setName(String name){
        this.name = name;
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