package dat102.f21;

public class BinaryTreeNode<T> {
    private T element;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    BinaryTreeNode(T el) {
        element = el;
        left = null;
        right = null;
    }

    public T getElement() {
        return element;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public boolean hasLeftChild() {
        return left != null;
    }

    public boolean hasRightChild() {
        return right != null;
    }

    public boolean isLeaf() {
        return (left == null) && (right == null);
    }
}