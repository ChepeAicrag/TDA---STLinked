/**
 * TDA de una Simbol Table (ST) con LinkedList
 * 
 * @author García García José Ángel 
 * @version 1/12/2019
 */
import java.util.Iterator;
public class STLinked <Key,Value> implements Iterable<Key> 
{
    /**
     * Campos de clase
       */
    private Nodo head;
    private int n;
    /** Clase Interna Nodo */
    private class Nodo{
        private Key key;
        private Value val;
        private Nodo next;
        public Nodo(Key key, Value val, Nodo next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    
    /**
     * Contrusctor para una ST vacía
       */
    public STLinked(){
        head = null;
        n  = 0; 
    }
    
    /**
     * Contrusctor para una ST con un elemento inicializado
     * @param key La llave de acceso al val
     * @param val El vallor a la llave key
       */
    public STLinked(Key key, Value val){
        head = new Nodo(key,val,null);
        n  = 1; 
    }
    
    
    /**
     * Indica si la lista esá vacia o no
     * @return true si la lista está vacia y false de lo contrario
       */
    public boolean isEmpty(){
        return head == null;
    }
    
    /**
     * Retorna las keys y values que contiene la tabla 
     * @return Cuantas elementos existe en la Tabla
       */
    public int size(){
        return n;
    }
    
    /**
     * Conocer que contiene una llave
     * @param key Key de la que queremos saber su valor
     * @return el valor contenido en la key, null si no encuentra la key
       */
    public Value get(Key key){
        for(Nodo i = head; i != null; i = i.next)
            if(i.key.equals(key))
                return i.val;
        return null;        
    }
    
    /**
     * Comprueba si la Tabla contiene a la Key
     * @param key La key que se busca 
     * @return true si la key se encuentra y false de lo contrario
       */
    public boolean contains(Key key){
        if(key != null)
        for(Nodo i = head; i != null; i = i.next)
            if(i.key.equals(key))
                return true;
        return false;        
    }
    
    /**
     * Inserta una key con su value a la tabla
     * @param key La key relacionada al val
     * @param val El val relacionado a la key
       */
    public void put(Key key, Value val){
       if(key == null) return;
       if(val == null){
            delete(key);
            return;
       }
       if(isEmpty())
            head = new Nodo(key,val,null);
        else{    
            for(Nodo i = head; i != null; i = i.next)
                if(i.key.equals(key)){
                    i.val = val;
                    return;
                }
            Nodo last;  
            for(last = head; last.next != null; last = last.next){}  
            last.next = new Nodo(key,val,null); 
        }
       n++;
    }
    
    /**
     * Elimina a una key, moviendo a la ultima key en lugar de esa
     * @param key La key que se eliminara de la tabla
       */
    public void delete(Key key){
        if(contains(key)){
            head = delete(head,key);
            n--;
        }
    }
    
    /**
     * Método recursivo que elimina un nodo y retorna el head actualizado
     * @param inicio Nodo donde inicia el recorrido
     * @param key Key a eliminar
     * @return inicio La nueva head de la ST
       */
    private Nodo delete(Nodo inicio,Key key){
        if(inicio == null)
            return null;
        if(inicio.key.equals(key))
            return inicio.next;
        inicio.next = delete(inicio.next, key);
        return inicio;
    }
    
    /**
     * Imprime lo contenido en la tabla con While
       */
    public void printfW(){
        System.out.println("La Tabla Contiene: ");
        for(Nodo i = head; i != null; i = i.next)
            System.out.println( i.key + " ---- " + i.val);
    }
    
    /**
     * Imprime lo contenido en la tabla con for-each
       */
    public void printfI(){
        System.out.println("La Tabla Contiene: ");
        for(Key k : this)
            System.out.println( k + " ---- " + get(k));
    }
    
    /**
     * Obtener un iterador de la tabla
     * @return Un iterador
       */
    public Iterator<Key> iterator(){
        return new STLinkedIterator();
    }
    
    /**
     * Clase para implementar Iterator
       */
    private class STLinkedIterator implements Iterator<Key>{
        private Nodo aux = head;
        public boolean hasNext(){
            return aux != null;
        }
        public Key next(){
            Key temp = aux.key;
            aux = aux.next;
            return temp;
        }
    }
}
