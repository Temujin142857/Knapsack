/**
 * Author Tomio Nagano
 * Student number 300239414
 */

public class BruteForce {
    node root;
    int[] v;
    int[] w;
    int maxv=0;

    private class node {
        public node(int v, int c, int depth){
            value=v;
            capacity=c;
        }

        node left=null;
        node right=null;
        int capacity;
        int value;
        int depth;
    }

    public BruteForce(int[] v, int[] w,int c){
        this.v=v;
        this.w=w;
        root=new node(0,c,0);
        buildNode(root);
    }

    //theory
    public void buildNode(node n){
        n.left=new node(n.value+v[n.depth+1],n.capacity - w[n.depth+1], n.depth+1);
        buildNode(n.left);
        if(n.capacity>=0&&n.value>maxv){maxv= n.value;}
        n.right=new node(n.value,n.capacity,n.depth+1);
        buildNode(n.right);
        if(n.capacity>=0&&n.value>maxv){maxv= n.value;}
    }


}
