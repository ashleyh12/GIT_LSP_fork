package org.howard.edu.lsp.oopfinal.question1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class SongsDatabase 
{
    private Map<String, Set<String>> map = new HashMap<String, Set<String>>();

    //adding the title of a song to the specific genre
    public void addSong(String genre, String songTitle) 
    {
        if (!map.containsKey(genre)) 
        {
            map.put(genre, new HashSet<String>());
        }
        map.get(genre).add(songTitle);
    }

    //returning the genre of the given song
    public String getGenreOfSong(String songTitle) 
    {
        for (Map.Entry<String, Set<String>> entry:map.entrySet()) 
        {
            if (entry.getValue().contains(songTitle)) 
            {
                return entry.getKey();
            }
        }
        return null;
    }

    //returning the set that has songs for a certain genre 
    public Set<String> getSongs(String genre) 
    {
        return map.getOrDefault(genre, new HashSet<String>());
    }
}
