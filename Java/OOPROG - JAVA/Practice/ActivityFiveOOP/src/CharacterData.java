package ActivityFiveOOP.src;

class CharacterData{
   
   private static CharacterData charData;

   private String[][] charAttrib = {
           {
                   "Eldermoor Vale",
                   "Thalindor’s Crest",
                   "Stormreach Hollow",
                   "Shadowfen Expanse",
                   "Crystalfall Caverns",
                   "Raiden Ei",
                   "Raiden Mei",
                   "Bosenmori",
                   "Shorekeeper",
                   "Arlecchino"
           },
      {"Elf", "Dwarf", "Human", "Vampire", "Demon", "Angel"}, // race
      {"Male", "Female"}, // Gender
      {"Magician", "Fighter", "Ranger", "Rogue", "Cleric", "Rare"}, // class
   };
   
      
   private String[][] jobAttrib = {{"Light Mage", "Dark Mage", "Summoner"}, // job = Magician
            {"Holy Knight", "Warrior"}, // job = Fighter
            {"Archer"}, // job = Ranger
            {"Assassin", "Ninja"}, // job = Rogue
            {"Healer", "Priest"}, // job = Clerics
            {"Spell-Weaver", "Beast-Tamer", "Bard"} // job = Rare
   };

   private String[] attribNames = {"Name", "Race", "Gender", "Class", "Job"};
   
   private CharacterData(){
   
   
   
   }
   
   public static CharacterData getInstance(){
   
      if(charData == null){
         charData = new CharacterData();
      
      }
   
      return charData;
   }
    
   
   public void sayHello(){
      System.out.println("Say Hello!");
   
   
   }
   
   public String[][] getCharAttrib(){

      return charAttrib;
   }
   public String[][] getJobAttrib(){

      return jobAttrib;
   }
   public String[] getAttribNames(){

      return attribNames;
   }

}