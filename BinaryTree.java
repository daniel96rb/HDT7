/**
 * la clase del libro de Algoritmos y Estructuras de Datos
* Clase: BinaryTree.java
* Clase del Arbol y Bosques binarios que permite organizar la informacion en nodos formando un arbol de busqueda.
*/
public class BinaryTree<E>{

	private Node root;
    private String arbol;
    private String palabra;
    protected E val;
    protected BinaryTree<E> parent,left,right;


	public BinaryTree() {
		// Se genera un nodo vacio.
		val = null;
		parent = null;
		left = right = this;
	}

	public BinaryTree(E valor) {
		// TODO Auto-generated constructor stub
		val = valor;
		right=left= new BinaryTree<E>();
		setLeft(left);
		setRight(right);
	}

	public BinaryTree(E valor, BinaryTree<E> left, BinaryTree<E> right) {
		// TODO Auto-generated constructor stub
		val=valor;
		if(left==null){
			left = new BinaryTree<E>();
		}
		setLeft(left);

		if(right == null){
			right = new BinaryTree<E>();
		}
		setRight(right);
	}

	public BinaryTree<E> left(){
		return left;
	}

	public BinaryTree<E> parent(){
		return parent;
	}

	public BinaryTree<E> right(){
		return right;
	}

	public void setLeft(BinaryTree<E> newLeft){

		if(isEmpty()){
			return;
		}
		if (left != null && left.parent() == this){
			left.setParent(null);
			left = newLeft;
			left.setParent(this);
		}
	}

	public void setRight(BinaryTree<E> newRight){

		if(isEmpty()){
			return;
		}
		if (right != null && right.parent() == this){
			right.setParent(null);
			right = newRight;
			right.setParent(this);
		}
	}

	public void setParent(BinaryTree<E> newParent){
		if (!isEmpty()){
			parent=newParent;
		}
	}


	public E value(){
		return val;

	}
	public void setValue(E valor){
		val=valor;
	}

	public boolean isEmpty(){
		boolean empty=false;
		if(parent==null)
			empty=true;
		else
			return empty;
		return empty;
	}

  //Metodos donde se realizan las busquedas en los arboles
	public String Busqueda(String word){
        palabra=word;
        Busqueda2(root);
        return palabra;
       }

   public void Busqueda2(Node nodo){
       if(nodo ==null)return;
       Busqueda2(nodo.left);
       if(nodo.miLista.getKey().equals(palabra)){
           palabra=nodo.miLista.getValue();
       }
       if(nodo.miLista.getValue().equals(palabra)){
       return;
       }
       Busqueda2(nodo.right);
   }

   //Metodo que crea la raiz del arbol e la inserta
	 public  void insertNode(Association<String,String> insert){
	        if(root == null){
	            root = new Node(insert);
	        }
	        else{
	            root.insertar(insert);
	        }
	    }

    //Metodo repetitivo para realizar la busqueda de forma recursiva
    public  String busquedaInOrder()
    {
        enOrden(root);
        return arbol;
    }

    //Recorre el arbol en orden de InOrder Izquier-Nodo-Derecha
    private void enOrden(Node nodo)
    {
        if(nodo == null)return;
        enOrden(nodo.left);
        arbol=arbol+"("+nodo.miLista.getKey()+", "+nodo.miLista.getValue()+")";
        enOrden(nodo.right);
    }
}
