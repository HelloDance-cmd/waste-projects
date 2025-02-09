#include <stdio.h>
#include <malloc.h>

struct t_node
{
    int val;
    struct t_node* left, *right;
};

/**
 * @param node 一个结点
 */
void swap(struct t_node* node)
{
    if(node == NULL || node->left == NULL && node->right == NULL)
        return;

    struct t_node *p = node->right;
    node->right = node->left;
    node->left = p;

    swap(node->left);
    swap(node->right);
}

int counts = 0;
/**
 * 创建一个树
 */
struct t_node* createTree(int deep)
{
    if(deep < 0)
        return NULL;
    
    struct t_node* root = (struct t_node*) malloc(sizeof(struct t_node));
    root->val = counts++;
    root->left = createTree(deep - 1);
    root->right = createTree(deep - 1);
    
    return root;
}

void preorder(struct t_node * n)
{
    if(n == NULL)
        return;
    
    printf("%d \n", n->val);
    preorder(n->left);
    preorder(n->right);
}

void inorder(struct t_node * n)
{
    if(n == NULL)
        return;
    
    inorder(n->left);
    printf("%d \n", n->val);
    inorder(n->right);
}

int main() 
{   struct t_node* root = createTree(3);
    preorder(&root);
    inorder(&root);
}
