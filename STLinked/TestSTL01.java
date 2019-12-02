
/**
 * Write a description of class TestSTL01 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestSTL01
{
    public static void main(String[] args){
        STLinked<Integer,String> st = new STLinked();
        st.put(1,"H");
        st.put(2,"o");
        st.put(3,"l");
        st.put(4,"a");
        st.put(1,"C");
        st.put(2,"h");
        st.printfW();
        StdOut.println("Eliminando al key 3");
        st.delete(3);
        StdOut.println("Agregando ( 3 , pepe )");
        st.put(3,"pepe");
        st.printfI(); 
    }
}
