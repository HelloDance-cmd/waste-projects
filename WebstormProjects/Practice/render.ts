/*
You are given the root of a binary tree with n nodes.
Each node is uniquely assigned a value from 1 to n.
You are also given an integer startValue representing the value of the start node s,
and a different integer destValue representing the value of the destination node t.

Find the shortest path starting from node s and ending at node t.
Generate step-by-step directions of such path as a string consisting
of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:

'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.
Return the step-by-step directions of the shortest path from node s to node t.
*/

class TreeNode {
  val: number
  left: TreeNode | null
  right: TreeNode | null

  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = (val === undefined ? 0 : val)
    this.left = (left === undefined ? null : left)
    this.right = (right === undefined ? null : right)
  }
}

function findNode(node: TreeNode, value: number): TreeNode {
  const queue: TreeNode[] = [node]
  while(queue.length > 0) {
    const n = queue.shift()
    if(n.val === value)
      return n

    if(n.left !== null)
      queue.push(n.left)
    if(n.right !== null)
      queue.push(n.right)
  }

  return undefined;
}

function getDirections(root: TreeNode | null, startValue: number, destValue: number): string {
  return ""
}