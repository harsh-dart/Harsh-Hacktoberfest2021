class Student {
    String name;
    int regno;
    float cgpa;
    
    Student(String n) {
        name = n;
    }
    Student(int r) {
        regno = r;
    }
    Student(float gpa) {
        cgpa = gpa;
    }
}

class ConstructorOverload {
    public static void main(String args[]) {
        Student s1 = new Student("Gagan Khatri");
        Student s2 = new Student(124157019);
        Student s3 = new Student(8.17f);
        
        System.out.println("Object s1 NAME  :   "+s1.name);
        System.out.println("Object s2 Registration Number   :    "+s2.regno);
        System.out.println("Object s3 CGPA   :   "+s3.cgpa);
    }
}

