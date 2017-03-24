/**
* Clase: Node.java
* Clase que permite crear los diferentes nodos del arbol/bosque binario.
* @author Daniel Rodriguez, Ana Lucia Leppe
*/

public class Node{

    Node left;
    Association<String,String> miLista =new Association<>();
    Node right;
    int value;
    //Inicializacion
    public Node (Association datos)
    {
        miLista = datos;
        left = right = null;
    }

    public void setleft(Node node){
    this.left = node;
  }
  /**
   * Set right node pointer for this Node
   *
   * @param node Right node for this Node
   */
  public void setright(Node node){
    this.right = node;
  }
  /**
   * Set value for this Node
   *
   * @param value Value for this Node
   */
  public void setValue(int value){
    this.value = value;
  }

  /**
   * @return Left node for this Node
   */
  public Node getleft() {
    return left;
  }
  /**
   * @return Right node for this Node
   */
  public Node getright() {
    return right;
  }
  /**
   * @return Current value for this Node
   */
  public int getValue() {
    return value;
  }

  /**
   * @return String representation of this Node
   */
  @Override
    public String toString() {
      String result = value + "";
      if (left  != null) result = left.toString() + "-" + result;
      if (right != null) result = result + "-" + right.toString();
      return result;
    }

    //Metodo que permite insertar un nuevo Nodo
    public  void insertar(Association<String,String> nuevoValor)
    {

    String palabra=nuevoValor.getKey();
    //Agrega un arbol izquierdo
    if(palabra.compareTo(miLista.getKey())<0){
        if(left == null){
            left = new Node(nuevoValor);}
        else
          left.insertar(nuevoValor);
    }
    //Agraga un arbol derecho
    if(palabra.compareTo(miLista.getKey())>0){
        if(right == null){
            right = new Node(nuevoValor);
        }
        else
          right.insertar(nuevoValor);
    }
    }
}
