public abstract class Animal {
    // Animal's attributes
    // Breed, Species, and its Movement
    private String breed, species, movement;
    private Movable movable;

    public Animal(String species,String breed, String movement, Movable movable){
        this.breed = breed;
        this.species = species;
        this.movement = movement;
        this.movable = movable;

    }
    
    
    // Move Method to display the breed and the species and calling the Movable implementation "doMove(String movement)"
    public void move(){
        System.out.print(species + ": => (" + breed + ") is ");
        movable.doMove(movement);
    }



}
