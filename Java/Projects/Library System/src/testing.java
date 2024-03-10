public class testing{
    public static void main(String[] args) {
        // Sample data for the table
        int idNum = 0;


        // Column names
        String[] columnNames = {"Book Title", "Book Author", "Book Genre"};

        System.out.printf("%-10s", "Book-ID");
        for (String columnName : columnNames) {

            System.out.printf("%-45s", columnName);
        }
        System.out.println("\n");

        String[][] data = new String[][]{
                {"Don Quixote", "Miguel de Cervantes", "Fiction"},
                {"Alice's Adventures in Wonderland", "Lewis Carroll", "Fantasy"},
                {"The Adventures of Huckleberry Finn", "Mark Twain", "Adventure"},
                {"The Adventures of Tom Sawyer", "Mark Twain", "Adventure"},
                {"Treasure Island", "Robert Louis Stevenson", "Adventure"},
                {"Pride and Prejudice", "Jane Austen", "Romance"},
                {"Wuthering Heights", "Emily Brontë", "Gothic Fiction"},
                {"Jane Eyre", "Charlotte Brontë", "Gothic Fiction"},
                {"Moby Dick", "Herman Melville", "Adventure"},
                {"The Scarlet Letter", "Nathaniel Hawthorne", "Historical Fiction"},
                {"Gulliver's Travels", "Jonathan Swift", "Satire"},
                {"The Pilgrim's Progress", "John Bunyan", "Allegory"},
                {"A Christmas Carol", "Charles Dickens", "Fiction"},
                {"David Copperfield", "Charles Dickens", "Fiction"},
                {"A Tale of Two Cities", "Charles Dickens", "Historical Fiction"},
                {"Little Women", "Louisa May Alcott", "Coming-of-Age"},
                {"Great Expectations", "Charles Dickens", "Fiction"},
                {"The Hobbit, or, There and Back Again", "J.R.R. Tolkien", "Fantasy"},
                {"Frankenstein, or, the Modern Prometheus", "Mary Shelley", "Gothic Fiction"},
                {"Oliver Twist", "Charles Dickens", "Fiction"},
                {"Uncle Tom's Cabin", "Harriet Beecher Stowe", "Anti-Slavery Novel"},
                {"Crime and Punishment", "Fyodor Dostoyevsky", "Psychological Fiction"},
                {"Madame Bovary: Patterns of Provincial life", "Gustave Flaubert", "Realism"},
                {"The Return of the King", "J.R.R. Tolkien", "Fantasy"},
                {"Dracula", "Bram Stoker", "Gothic Fiction"},
                {"The Three Musketeers", "Alexandre Dumas", "Historical Adventure"},
                {"Brave New World", "Aldous Huxley", "Dystopian Fiction"},
                {"War and Peace", "Leo Tolstoy", "Historical Fiction"},
                {"To Kill a Mockingbird", "Harper Lee", "Southern Gothic"},
                {"The Wizard of Oz", "L. Frank Baum", "Fantasy"},
                {"Les Misérables", "Victor Hugo", "Historical Fiction"},
                {"The Secret Garden", "Frances Hodgson Burnett", "Children's Literature"},
                {"Animal Farm", "George Orwell", "Political Satire"},
                {"The Great Gatsby", "F. Scott Fitzgerald", "Fiction"},
                {"The Little Prince", "Antoine de Saint-Exupéry", "Children's Literature"},
                {"The Call of the Wild", "Jack London", "Adventure"},
                {"20,000 Leagues Under the Sea", "Jules Verne", "Adventure"},
                {"Anna Karenina", "Leo Tolstoy", "Realist Fiction"},
                {"The Wind in the Willows", "Kenneth Grahame", "Children's Literature"},
                {"The Picture of Dorian Gray", "Oscar Wilde", "Gothic Fiction"}
        };

        // Print table data
        for (byte i = 0; i < data.length; i++) {

            System.out.printf("%-10d", (i+1));
            for(byte j = 0; j < data[i].length; j++){
                System.out.printf("%-45s", data[i][j]);
            }


/*            String[] row = data[i];
            for (String cell : row) {
                System.out.printf("%-15s", cell);
            }*/
            System.out.println();
        }
    }

}
