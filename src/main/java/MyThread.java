import java.util.List;

public class MyThread extends Thread{
    private List<String> strings;

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    @Override
    public void run() {
        for (String string:strings) {
            MyString myString=new MyString(string);
            MyString.increaseCounter(myString);
        }
    }
}
