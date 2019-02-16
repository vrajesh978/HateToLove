package com.example.hatetolove;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class WordUtils {

    private ArrayList<ArrayList<Integer>> graphList;
    private ArrayList<String> words;
    private int totalSize;

    WordUtils(){
        this.graphList = new ArrayList<>();
        this.words = new ArrayList<>();
    }

    WordUtils(String fileName,String wordFileName){
        this.graphList = new ArrayList<>();
        this.words = new ArrayList<>();
        this.initWordList(wordFileName);
        this.init(fileName);
    }

    private void set(ArrayList<ArrayList<Integer>> graphList){
        this.graphList = graphList;
        this.totalSize = graphList.size();
    }

    public ArrayList<ArrayList<Integer>> getList(){
        return graphList;
    }
    public ArrayList<String> getWordList(){
        return words;
    }

    private  void initWordList(String fileName){
        File file = new File(fileName);
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String word = null;
            while((word = reader.readLine()) != null){
                this.words.add(word);
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void init(String fileName){
        File file = new File(fileName);

        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String text = null;
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            while ((text = reader.readLine()) != null){
                String[] split_string = text.split(" ");
                ArrayList<Integer> list1 = new ArrayList<>();
                for(int i =1 ;i <split_string.length;i++) {
                    list1.add(Integer.parseInt(split_string[i]));
                }
                list.add(list1);

            }
            this.set(list);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Object> BFS(ArrayList<ArrayList<Integer>> adj, int s, int d, int V) {
        // Mark all the vertices as not visited(By default
        // set as false)
        ArrayList<Object> result = new ArrayList<>();
        boolean visited[] = new boolean[V];
        Integer parent[] = new Integer[V];
        // Create a queue for BFS
        Arrays.fill(parent,-1);
        LinkedList<Integer> queue1 = new LinkedList<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue1.add(s);
        int prev = s;
        while (queue1.size() != 0 && d != prev) {
            // Dequeue a vertex from queue and print it
            s = queue1.poll();
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj.get(s).listIterator();
            while (i.hasNext()) {
                int n = i.next();
                prev = n;
                if (!visited[n]) {
                    visited[n] = true;
                    parent[n] = s;
                    queue1.add(n);
                    queue.add(n);
                }
            }
        }
        result.add(queue);
        result.add(parent);
        return result;
    }

    //TODO: implement using index of the string
    public boolean checkWordInDict(int s,int d){
        graphList = this.getList();
        if(graphList.get(s).contains(d))
            return true;
        else
            return false;
    }



}
