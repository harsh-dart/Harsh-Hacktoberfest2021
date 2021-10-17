class Value {
    void DataType() {
        System.out.println("\tI dont know who i am");
    }
    
    void DataType(int a) {
        System.out.println(a+"\tHi! I am an Integer");
    }
    
    void DataType(float a) {
        System.out.println(a+"\tI am a floating number");
    }
    
    void DataType(char a) {
        System.out.println(a+"\tHello! Its me character");
    }
    
    void DataType(String a) {
        System.out.println(a+"\tThis is a String");
    }
}
class MethodOverload {
    public static void main(String args[]) {
        Value val = new Value();
        val.DataType(22);
        val.DataType(3.14f);
        val.DataType('p');
        val.DataType("pi");
        val.DataType();
    }
}


