using System;
using System.Collections.Generic;

namespace TrieTest
{
    public class TrieStructure
    {
        private TrieNode node = new TrieNode();

        public  bool Contains(string word)
        {
            return node.Contains(word);
        }

        internal void Insert(string p)
        {
            AddTrieNode(node, p);
        }
        
        class TrieNode
        {
            public char ActualValue {
                get{return actualValue;}
                set { actualValue = value; }
            }
            public List<TrieNode> ListTrieNodes {
                get { return listTrieNodes; }
                set { listTrieNodes = value; }
            }

            public char actualValue = '\0';
            public List<TrieNode> listTrieNodes = new List<TrieNode>();

            public bool Contains(string word)
            {
                if (string.IsNullOrEmpty(word))
                {
                    return actualValue == '*';
                }
                else
                {
                    if (word.ToCharArray()[0] == actualValue)
                    {
                        bool contained = false;
                        string remainder = word.Substring(1);
                        foreach (TrieNode node in ListTrieNodes)
                        {
                            contained = node.Contains(remainder);
                            if (contained)
                                return true;
                        }
                        return false;
                    }
                    return false;

                }
                return false;
            }
        }

        private void AddTrieNode(TrieNode trieNode, string value)
            {
                if (string.IsNullOrEmpty(value))
                    return;
                trieNode.actualValue = value.ToCharArray()[0];
                if (value == "*")
                {
                    return;
                }
                if (value.Length == 1 ) { 
                trieNode.listTrieNodes.Add(new TrieNode
                {
                    actualValue = '*'
                });
                }
                else if (value.Length > 1)
                {
                    TrieNode node = new TrieNode();
                    AddTrieNode(node, value.Substring(1));
                    trieNode.listTrieNodes.Add(node);
                }

            }
    }
}