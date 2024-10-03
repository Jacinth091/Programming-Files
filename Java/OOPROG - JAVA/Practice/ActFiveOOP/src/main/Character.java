package ActFiveOOP.src.main;
import java.util.Random;


class Character {
    private String name, race, charClass, job, gender;
    private static Random rand = new Random();
    public Character() {}

    public Character(String name, String race, String gender, String charClass, String job) {
        setName(name);
        setRace(race);
        setGender(gender);
        setClass(charClass);
        setJob(job);
    }

    // New method for randomizing character attributes
    public void randomizeCharacterAttributes(String[][] attribOptions, CharacterData charData) {
        setName(attribOptions[0][genRandNum(attribOptions[0].length)]);
        setRace(attribOptions[1][genRandNum(attribOptions[1].length)]);
        setGender(attribOptions[2][genRandNum(attribOptions[2].length)]);
        setClass(attribOptions[3][genRandNum(attribOptions[3].length)]);
        setJob(getRandJobByClass(charData.getJobAttrib(), this.charClass));

//        this.name = attribOptions[0][genRandNum(attribOptions[0].length)];
//        this.race = attribOptions[1][genRandNum(attribOptions[1].length)];
//        this.gender = attribOptions[2][genRandNum(attribOptions[2].length)];
//        this.charClass = attribOptions[3][genRandNum(attribOptions[3].length)];
//        this.job = getRandJobByClass(charData.getJobAttrib(), this.charClass);
    }

    // The method to display character attributes
    public void dispAttrib() {
        System.out.println("Character Attributes:");
        System.out.println("Name: " + name);
        System.out.println("Race: " + race);
        System.out.println("Gender: " + gender);
        System.out.println("Class: " + charClass);
        System.out.println("Job: " + job);
    }

    // Other setters
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setClass(String charClass) {
        this.charClass = charClass;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Utility method to generate a random number
    public static int genRandNum(int max) {

        return rand.nextInt(max);
    }

    public String getRandJobByClass(String[][] jobArray, String pickedClass) {
        CharacterData charData = CharacterData.getInstance();
        String[] classList = charData.getCharAttrib()[charData.getCharAttrib().length - 1];
        String job = "";

        for (int i = 0; i < classList.length; i++) {
            if (classList[i].equals(pickedClass)) {
                String[] jobsForClass = jobArray[i];
                job = jobsForClass[genRandNum(jobsForClass.length)];
                break;
            }
        }
        return job;
    }
}
