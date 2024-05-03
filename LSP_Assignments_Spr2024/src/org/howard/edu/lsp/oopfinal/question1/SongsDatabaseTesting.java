package org.howard.edu.lsp.oopfinal.question1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;

public class SongsDatabaseTesting 
{
    private SongsDatabase db;

    @Before
    public void setUp() 
    {
        db = new SongsDatabase();
        db.addSong("Rap", "P.I.M.P");
        db.addSong("Country", "Sweet Alabama");
        db.addSong("Jazz", "What A Wonderful World");
    }

    @Test
    public void testAddSong() 
    {
        db.addSong("Rap", "Hate It Or Love It");
        Set<String> rapSongs = db.getSongs("Rap");
        assertTrue(rapSongs.contains("Hate It Or Love It"));
        assertEquals(2, rapSongs.size());
    }

    @Test
    public void testGetGenre() 
    {
        assertEquals("Rap", db.getGenreOfSong("P.I.M.P"));
        assertEquals("Country", db.getGenreOfSong("Sweet Alabama"));
        assertEquals("Jazz", db.getGenreOfSong("What A Wonderful World"));
        assertNull(db.getGenreOfSong("Empty Song"));
    }

    @Test
    public void testGetSongs() 
    {
        Set<String> rapSongs = db.getSongs("Rap");
        assertTrue(rapSongs.contains("P.I.M.P"));
        assertEquals(1, rapSongs.size());

        Set<String> countrySongs = db.getSongs("Country");
        assertTrue(countrySongs.contains("Sweet Alabama"));
        assertEquals(1, countrySongs.size());

        Set<String> jazzSongs = db.getSongs("Jazz");
        assertTrue(jazzSongs.contains("What A Wonderful World"));
        assertEquals(1, jazzSongs.size());
        assertTrue(db.getSongs("Empty Genre").isEmpty());
    }
}
