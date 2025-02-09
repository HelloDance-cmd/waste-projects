#include <bits/stdc++.h>

struct DataType
{
  virtual int compare(DataType *);
};

class Tree
{
  class Node
  {
    static std::unordered_map<Node *, int> recordHeightTable; // The node height is `int`
    DataType *value = nullptr;
    Node *right = nullptr, *left = nullptr;

  public:
    Node(DataType *_value) { this->value = _value; }

    int height(Node *node)
    {
      if (recordHeightTable.find(node) != recordHeightTable.end())
      {
        return recordHeightTable.at(node);
      }

      // 计算左孩子和右孩子的节点高度
      // 并将计算好的节点高度放入到高度记录表中
      int left = 0, right = 0;
      if (recordHeightTable.find(node->left) != recordHeightTable.end())
      {
        left = recordHeightTable.at(node->left);
      }
      else
      {
        recordHeightTable.insert(std::pair<Node *, int>(node->left, height(node->left)));
        left = recordHeightTable.at(node->left);
      }

      if (recordHeightTable.find(node->right) != recordHeightTable.end())
      {
        right = recordHeightTable.at(node->right);
      }
      else
      {
        recordHeightTable.insert(std::pair<Node *, int>(node->right, height(node->right)));
        right = recordHeightTable.at(node->right);
      }

      // 如果下次再次计算根节点, 就不需要需要重新计算了
      if (recordHeightTable.find(node) != recordHeightTable.end())
      {
        recordHeightTable.insert(std::pair<Node *, int>(node, std::max(left, right)));
      }

      return node == nullptr ? 1 : std::max(left, right);
    }
  };
};

int main()
{
}