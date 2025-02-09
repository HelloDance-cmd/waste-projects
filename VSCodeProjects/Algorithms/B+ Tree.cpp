#include <iostream>
#include <queue>
#define nullptr NULL


struct BNode
{
    int value;
    BNode *leftChild = nullptr;
    BNode *rightChild = nullptr;

    BNode() {}
    BNode(int value) : value(value) {}
};

class BTree
{
    BNode *rootNode;

public:
    BTree(BNode *root) : rootNode(root) {}

    void insertNode(int value);
    void insertNode(BNode *node);
    void print();
};

void BTree::print()
{
    std::queue<BNode*> nodeSequences;
    nodeSequences.push(rootNode);

    while(!nodeSequences.empty())
    {
        BNode* element = nodeSequences.front(); nodeSequences.pop(); 
        std::cout << element->value << std::endl;

        if(element->leftChild != nullptr)
            nodeSequences.push(element->leftChild);
        if(element->rightChild != nullptr)
            nodeSequences.push(element->rightChild);
    }
}
void BTree::insertNode(BNode *node)
{
    BNode *workpoint = rootNode;
    
    // 找到最小的元素，将它放入
    for(; workpoint->value < node->value; workpoint = workpoint->leftChild);
    workpoint->leftChild = node;
}

void BTree::insertNode(int value) 
{
    BNode node(value);
    this->insertNode(&node);
}

int main(int argc, char const *argv[])
{
    int value; std::cin >> value;
    BNode root(value);
    BTree tree(&root);
    tree.insertNode(10);
    tree.print();
    return 0;
}
