#ifndef HEADER_TREE
#define HEADER_TREE
class Tree {
    class Node {
        int value;
        Node *leftChild, *rightChild;
    public:
        Node(int value): value(value) {}
    };

    Node* root = nullptr;
public:
    void insert(int value);

};
#endif