package com.company;

import java.util.*;
public class TrieNode {
    // Each Trie Node contains a Map 'child'
    // where each alphabet points to a Trie
    // Node.
    HashMap<Character,TrieNode> child;
    // 'isLast' is true if the node represents end of a contact
    boolean isLast;
    public TrieNode() {
        child = new HashMap<Character,TrieNode>();
        for (char i = 'a'; i <= 'z'; i++) {
            child.put(i,null);

            isLast = false;
        }
    }
}
class Trie
{
    TrieNode root;

    // Insert all the Contacts into the Trie
    public void insertIntoTrie(String contacts[])
    {
        root = new TrieNode();
        int n = contacts.length;
        for (int i = 0; i < n; i++)
        {
            insert(contacts[i]);
        }
    }


    public void insert(String s) {
        int len = s.length();
        TrieNode itr=root;	//'itr' means a virable is used to iterate the Trie Nodes

        for (int i = 0; i < len; i++) {
            // Check if the s[i] is already present in Trie
            TrieNode nextnode = itr.child.get(s.charAt(i));
            if (nextnode == null) {
                nextnode = new TrieNode(); //if not found then create new trie node
                itr.child.put(s.charAt(i), nextnode); //Insert into Hash Map
            }
            itr=nextnode; //move 'itr' to point next node
            if(i==len-1) {
                itr.isLast=true;// If its the last character of the string 's'  then mark 'isLast' as true
            }
        }
    }
    /* This function simply displays all dictionary words
    going through current node.  String 'prefix'  represents
     string corresponding to the path from root to curNode.
    */
    public void displayContactsUntil(TrieNode currnode, String prefix) {
	/* Check if the string 'prefix' ends at this Node
    If yes then display the string found so far*/
        if (currnode.isLast) {
            System.out.println(prefix);
        }

        // Find all the adjacent Nodes to the current
        // Node and then call the function recursively
        for (char i='a'; i<='z'; i++) {
            TrieNode NextNode = currnode.child.get(i);
            if (NextNode!=null) {
                displayContactsUntil(NextNode, prefix + i);
            }
        }
    }
    // Display suggestions after every character enter by
// the user for a given string 'str'
    void displayContacts(String str)
    {
        TrieNode prevNode = root;

        // 'flag' denotes whether the string entered
        // so far is present in the Contact List

        String prefix = "";
        int len = str.length();

        // Display the contact List for string formed
        // after entering every character
        int i;
        for (i = 0; i < len; i++)
        {
            // 'str' stores the string entered so far
            prefix += str.charAt(i);

            // Get the last character entered
            char lastChar = prefix.charAt(i);

            // Find the Node corresponding to the last
            // character of 'str' which is pointed by
            // prevNode of the Trie
            TrieNode curNode = prevNode.child.get(lastChar);

            // If nothing found, then break the loop as
            // no more prefixes are going to be present.
            if (curNode == null)
            {
                System.out.println("No Results Found for "+ prefix + "");
                i++;
                break;
            }

            // If present in trie then display all
            // the contacts with given prefix.
            System.out.println("nSuggestions based on "+ prefix + "are");
            displayContactsUntil(curNode, prefix);

            // Change prevNode for next prefix
            prevNode = curNode;
        }

        for ( ; i < len; i++)
        {
            prefix += str.charAt(i);
            System.out.println("nNo Results Found for "+ prefix + "");
        }
    }
}

