public class MyStackNode
{
   public static void main(String[] args)
   {
      StackNode stackNode = new StackNode();
      
      
      stackNode.push("23232awdadad3");
      stackNode.push("2ad3dwadaw2323");
      stackNode.push("23");
      stackNode.push("232325413136465423");
      stackNode.push("23adw");
      stackNode.push("dwadawdad");
      stackNode.push("Gwapo Ko");
      
      System.out.println(stackNode.peek());
      System.out.println("result\n" + stackNode.disp());
      
   }
}