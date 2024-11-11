public abstract class Animal {

    private String breed, species, movement;
    private Movable movable;

    public Animal(String species,String breed, String movement, Movable movable){
        this.breed = breed;
        this.species = species;
        this.movement = movement;
        this.movable = movable;

    }

    public void move(){
        System.out.print(species + " (" + breed + ") is ");
        movable.doMove(movement);
    }



}
