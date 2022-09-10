package com.company;

public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();

        String Contacts [] = {"Abdul_Qayoom","Abdul_Samad","Amjad_Ali","Rizwan_Ali",};
        trie.insertIntoTrie(Contacts);
        String Query = "Abdul";
        trie.displayContacts(Query);


    }

}
