class CharacterData{
   
   private static CharacterData charData;
   
   
            
   String[][] charAttrib = {
      {"Elf", "Dwarf", "Human", "Vampire", "Demon", "Angel"}, // race
      {"Male", "Female"}, // Gender
      {"Magician", "Fighter", "Rangers", "Rogue", "Clerics", "Rare"}, // class
   };
   
      
   String[][] charJobAttrib = {{"Light Mage", "Dark Mage", "Summoner"}, // job = Magician
            {"Holy Knight", "Warrior"}, // job = Fighter
            {"Archer"}, // job = Ranger
            {"Assassin", "Ninja"}, // job = Rogue
            {"Healer", "Priest"}, // job = Clerics
            {"Spell-Weaver", "Beast-Tamer", "Bard"} // job = Rare
   };  
   
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
   


}