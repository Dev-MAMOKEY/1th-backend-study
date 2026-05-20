import model.Student;
import view.PrintAll;
import controller.StudentController;

public class Runner {
   public static void run(){
       Student[] students = {
               new Student("김멋사", "20260001", "Software"),
               new Student("김동사", "20250001", "Hardware"),
               new Student("김수사", "20240001", "AI"),
       };
       PrintAll printAll = new PrintAll();
       StudentController studentController = new StudentController(students,printAll);
       studentController.run();
   }


}
