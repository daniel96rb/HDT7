import java.util.Iterator;
import javax.xml.soap.Node;
public class BinaryTree<E> extends Object {
 Node root;
 protected E val; // value associated with node
 protected BinaryTree<E> parent; // parent of node
 protected BinaryTree<E> left, right; // children of node
 
 public BinaryTree()
 // post: constructor that generates an empty node
 {
  val = null;
  parent = null; left = right = this;
 }
 
 public BinaryTree(E value)
 // post: returns a tree referencing value and two empty subtrees
 {
  val = value;
  right = left = new BinaryTree<E>();
  setLeft(left);
  setLeft(right);
 }
 
 public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right)
 // post: returns a tree referencing value and two subtrees
 {
  val = value;
  if (left == null) { left = new BinaryTree<E>(); }
  setLeft(left);
  if (right == null) { right = new BinaryTree<E>(); }
  setLeft(right);
 }
 
 public BinaryTree<E> left()
 // post: returns reference to (possibly empty) left subtree
 // post: returns reference to (possibly empty) left subtree
 {
  return left;
 }
 
 public BinaryTree<E> parent(){
  return null;
 }
 // post: returns reference to parent node, or null
 
 public void setLeft(BinaryTree<E> newLeft)
 // post: sets left subtree to newLeft
 // re-parents newLeft if not null
 {
  if (isEmpty()){
   return;
  }
  if (left != null && left.parent() == this) left.setParent(null);{
  left = newLeft;
  left.setParent(this);
 }
 }
 
 private boolean isEmpty() {
  // TODO Auto-generated method stub
  return false;
 }
 protected void setParent(BinaryTree<E> newParent)
 // post: re-parents this node to parent reference, or null
 {
  if (!isEmpty()) {
  parent = newParent;
  }
 }
 
 public Iterator<E> iterator(){
  return null;
 }
 // post: returns an in-order iterator of the elements
 
 public boolean isLeftChild(){
  return null != null;
 }
 // post: returns true if this is a left child of parent
 
 public E value(){
 // post: returns value associated with this node
  return val;
 }
 //public void setValue(E value{
 // post: sets the value associated with this node
  //val = value;
}

   
     /* Compute the "maxDepth" of a tree -- the number of 
        nodes along the longest path from the root node 
        down to the farthest leaf node.*/
}
