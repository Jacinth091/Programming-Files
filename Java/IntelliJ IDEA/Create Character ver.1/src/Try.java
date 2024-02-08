public class Try {
    public static void main(String[] args) {
        // Creating a 2D String array
        String[][] stringArray = {
                {"Apple", "Banana", "Cherry"},
                {"Dog",   "Elephant", "Fox"},
                {"Java", "Python", "C++"}
        };

        int row = 0;
        int col = 0;
        String object;

        for( col = 0; col < stringArray[row].length; col++)
        {
            System.out.print(stringArray[row][col] + "    ");
        }
    }
}
