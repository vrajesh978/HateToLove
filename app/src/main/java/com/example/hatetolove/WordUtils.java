package com.example.hatetolove;


import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WordUtils {

    public List<List<Integer>> graphList;
    public List<String> words;
    int V;
    boolean visited[];
    Integer parent[];
    int new_word_index;

    WordUtils(int V){
        this.V = V;
        graphList = new ArrayList();
        words = new ArrayList();
        visited = new boolean[V];
        parent = new Integer[V];
    }


    public List<List<Integer>> getList(){
        return graphList;
    }
    public List<String> getWordList(){
        return words;
    }

    public void initWordList(Context ctx, String fileName) {
        try{
            InputStream ir = ctx.getResources().openRawResource(R.raw.util);
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(ir));
            String word = null;
            while((word = reader.readLine()) != null){
                words.add(word);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void init(Context ctx,String fileName){
        try{
            InputStream ir = ctx.getResources().openRawResource(R.raw.connected_words);

            BufferedReader reader = new BufferedReader(new InputStreamReader(ir));
            String text = null;
            while ((text = reader.readLine()) != null){
                String[] split_string = text.split(" ");
                ArrayList<Integer> list1 = new ArrayList<>();
                for(int i =1 ;i <split_string.length;i++) {
                    list1.add(Integer.parseInt(split_string[i]));
                }
                graphList.add(list1);
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public int BFS(int s, int d, int V) {
        // Mark all the vertices as not visited(By default
        // set as false)


        // Create a queue for BFS
        Arrays.fill(visited,false);
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
            Iterator<Integer> i = graphList.get(s).listIterator();
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
        int temp = find_parent(d);
        return new_word_index;
    }

    public int find_parent(int i){
        if(parent[i]!=-1) {
            new_word_index = i;
            return find_parent(parent[i]);
        }
        return i;
    }


    public boolean checkWordInDict(int s,int d){
        graphList = getList();
        return graphList.get(s).contains(d);
    }
}