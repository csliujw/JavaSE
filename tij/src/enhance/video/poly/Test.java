package video.poly;


public class Test {
    public static void main(String[] args) {
        Test test = new Test();
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        if ("math".equals(s)) {
//            test.teachStudentMath(new MathTeacher());
//        } else if ("english".equals(s)) {
//            test.teachStudentEnglish(new EnglishTeacher());
//        }
//        scanner.close();
        // 不用多态 你要写三个方法
        test.teachStudentEnglish(new EnglishTeacher());
        test.teachStudentMath(new MathTeacher());
        test.teachStudentChinese(new ChineseTeacher());
        System.out.println("===================");
        // 用多态 你只要一个方法。
        test.teachStudent(new EnglishTeacher());
        test.teachStudent(new MathTeacher());
        test.teachStudent(new ChineseTeacher());

    }


    public void teachStudentEnglish(EnglishTeacher teacher) {
        teacher.teach();
    }

    public void teachStudentMath(MathTeacher teacher) {
        teacher.teach();
    }

    public void teachStudentChinese(ChineseTeacher teacher) {
        teacher.teach();
    }

    public void teachStudent(Teacher teacher) {
        teacher.teach();
    }
}
