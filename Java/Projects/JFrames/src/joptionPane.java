import javax.swing.*;
public class joptionPane {
    public static void main(String[] args) {

        // JOptionPane = pop up a standard dialog box that prompts users for avalue
        //              or informs them of something.

        // Show Message Dialog

//        JOptionPane.showMessageDialog(null, "This is a Plain Message", "Plain Message", JOptionPane.PLAIN_MESSAGE);
//        JOptionPane.showMessageDialog(null, "This is an Information Message", "Information Message", JOptionPane.INFORMATION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "This is a Question Message", "Question Message", JOptionPane.QUESTION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "This is a Warning Message", "Warning Message", JOptionPane.WARNING_MESSAGE);
//        JOptionPane.showMessageDialog(null, "This is an Error Message", "Error Message", JOptionPane.ERROR_MESSAGE);

        // Confirm Dialog

        System.out.println(JOptionPane.showConfirmDialog(null, "Are you a Human?", "Yes and No Option", JOptionPane.YES_NO_OPTION));
        System.out.println(JOptionPane.showConfirmDialog(null, "Delete System 32?", "Yes, No, and Cancel Option", JOptionPane.YES_NO_CANCEL_OPTION));
        System.out.println(JOptionPane.showConfirmDialog(null, "Shutdown Nasa?", "Ok and Cancel Option", JOptionPane.OK_CANCEL_OPTION));
//        JOptionPane.showMessageDialog(null, "This is a Warning Message", "Warning Message", JOptionPane.WARNING_MESSAGE);
//        JOptionPane.showMessageDialog(null, "This is an Error Message", "Error Message", JOptionPane.ERROR_MESSAGE);






    }
}
