class Character
{
    String job, race, skills, name;
    int age;

    void dispCharacter(){
        System.out.println("Name: " + this.name + "\nRace: " + this.race+ "\nJob: " + this.job+ "\nSkills : " + this.skills + "\nAge: "+ this.age);
    }


}



public class CreateCharacter {
    public static void main(String[] args)
    {
        Character charOne = new Character();
        charOne.name = "Frieren";
        charOne.race = "Elf";
        charOne.job = "Mage";
        charOne.skills = "Plot-Armor";
        charOne.age = 10000;

        charOne.dispCharacter();



    }

}
