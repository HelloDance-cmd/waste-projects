#include <iostream>
#include <vector>

const std::vector<std::vector<int>> adjacentMartix{
    {0,1,1,0,0},
    {1,0,1,1,0},
    {1,1,0,0,1},
    {0,1,0,0,0},
    {0,0,1,0,0}
};

struct Graph {
public:
    typedef int GraphNode;
    typedef char NameOfNode;
    typedef std::vector<std::vector<GraphNode>> Martix2D;
    const std::vector<char> NameMapping{'A', 'B', 'C', 'D', 'E'};
    #define NEIGHBOR_NOT_FOUND -1
private:
    Martix2D martix;
    std::vector<bool> visit;
    bool isVisited(GraphNode v) { return visit.at(v); }
public:
    GraphNode neighbor(GraphNode v) {
        std::vector<GraphNode> v_neighbors = this->martix[v];
        for(GraphNode w : v_neighbors) {
            if(!isVisited(w))
                return w;
        }
        return NEIGHBOR_NOT_FOUND;
    }

    Graph(Martix2D martix) {
        this->martix = martix;
        visit.assign(martix.size(), false);
    }


    void deepthFirstSearch(NameOfNode v) { 
        for(int i = 0; i < NameMapping.size(); i++) {
            if (NameMapping[i] == v) {
                deepthFirstSearch(v);
                return;
            }
        }
    }
    void deepthFirstSearch(GraphNode v) {
        visit[v] = true;
        std::cout << NameMapping[v] << " Visited. " << std::endl;
        for(GraphNode w = neighbor(v); w != -1; w = neighbor(v)) {
            if(!isVisited(w))
                deepthFirstSearch(w);
        }
    }

    void recovery() { this->visit.clear(); }

    ~Graph() {
        this->recovery();
    }
};

struct TreeNode {
    struct TreeNode* left = nullptr;
    struct TreeNode* right = nullptr;
    int val = 0;
};

int main() {
    Graph g(adjacentMartix);
    g.deepthFirstSearch('A');
}