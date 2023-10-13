#java code to find out whether it contains a duplicate sub-tree of size two or more, or not

class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    int dupSub(Node root) {
        toSolve(root);
        for (Map.Entry<String,Integer> e : map.entrySet()){
            if(e.getValue()>=2){
                return 1;
            }
        }
        return 0;
    }

    String toSolve(Node root){
        if(root == null){
            return "#";
        }

        String s = "";
        if(root.right == null && root.left == null){
            return Integer.toString(root.data);
        }

        s+=Integer.toString(root.data);
        s+=toSolve(root.left);
        s+=toSolve(root.right);
        map.put(s, map.getOrDefault(s, 0)+1);
        return s;
    }
}
