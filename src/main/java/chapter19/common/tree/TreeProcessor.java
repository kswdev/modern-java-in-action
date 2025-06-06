package chapter19.common.tree;

public abstract class TreeProcessor {

    public static int lookup(String key, int defaultValue, Tree tree) {
        if (tree == null) return defaultValue;
        if (key.equals(tree.getKey())) return tree.getVal();
        return lookup(key, defaultValue,
                            key.compareTo(tree.getKey()) < 0 ? tree.getLeft() : tree.getRight());
    }

    // 기존의 자료구조를 갱신
    public static void update(String key, int newValue, Tree tree) {
        if (tree == null) { /* 새로운 노드 추가 */ }
        else if (key.equals(tree.getKey())) tree.setVal(newValue);
        else update(key, newValue, key.compareTo(tree.getKey()) < 0 ? tree.getLeft() : tree.getRight());
    }

    public static Tree fupdate(String key, int newValue, Tree tree) {
        return (tree == null) ?
                new Tree(key, newValue, null, null) :
                    key.equals(tree.getKey()) ?
                        new Tree(key, newValue, tree.getLeft(), tree.getRight()) :
                    key.compareTo(tree.getKey()) < 0 ?
                        new Tree(tree.getKey(), tree.getVal(), fupdate(key, newValue, tree.getLeft()), tree.getRight()) :
                        new Tree(tree.getKey(), tree.getVal(), tree.getLeft(), fupdate(key, newValue, tree.getRight()));
    }
}
