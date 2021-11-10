package GameLogic;

/**
 * Clase Comparador.
 * 
 * Compara dos datos de tipo E.
 * @author Agustin Cuello y Guillermo Rodriguez.
 *
 * @param <E> Tipo de datos a comparar.
 */
public class scoreComparator<E> implements java.util.Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return ((Comparable<E>) o2).compareTo(o1);
    }
    
}
