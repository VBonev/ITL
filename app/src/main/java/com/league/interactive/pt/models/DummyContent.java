package com.league.interactive.pt.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Helper class for providing sample position for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<RankPlayer> ITEMS = new ArrayList<RankPlayer>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, RankPlayer> ITEM_MAP = new HashMap<String, RankPlayer>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(RankPlayer item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static RankPlayer createDummyItem(int position) {
        Random random = new Random();
        int rank = random.nextInt(10 - 1 + 1) + 1;
        int points = random.nextInt(2500 - 10 + 1) + 10;
        return new RankPlayer(String.valueOf(position), position, "Item " + position, "Sofia", rank, points);
    }

    /**
     * A dummy item representing a piece of position.
     */
    public static class RankPlayer {
        public final String id;
        public final int position;
        public final String name;
        public final String town;
        public final int rank;
        public final int points;

        public RankPlayer(String id, int position, String name, String town, int rank, int points) {
            this.id = id;
            this.position = position;
            this.name = name;
            this.town = town;
            this.rank = rank;
            this.points = points;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
