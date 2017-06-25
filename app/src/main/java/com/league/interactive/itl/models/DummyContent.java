package com.league.interactive.itl.models;

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
    static Random random = new Random();
    private static final int COUNT = 25;

    public static List<RankPlayer> getDummyRankItems() {
        final List<RankPlayer> rankPlayers = new ArrayList<>();

        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            rankPlayers.add(createDummyRank(i));
        }
        return rankPlayers;

    }

    public static List<Tournament> getDummyProgressTournament() {
        final List<Tournament> tournaments = new ArrayList<>();

        // Add some sample items.
        for (int i = 1; i <= 4; i++) {
            tournaments.add(createDummyProgressTournament(i));
        }
        return tournaments;
    }

    public static List<TournamentMatch> getDummyMatches(int matchCount) {
        final List<TournamentMatch> matches = new ArrayList<>();

        // Add some sample items.
        for (int i = 1; i <= matchCount; i++) {
            String status;
            if (i % 2 == 0) {
                status = TournamentMatch.FINISHED_STATUS;
            } else if (i % 3 == 0) {
                status = TournamentMatch.IN_PROGRESS_STATUS;
            } else {
                status = TournamentMatch.UPCOMING_STATUS;
            }
            matches.add(createDummyMatches(i, status));
        }
        return matches;
    }

    public static List<Tournament> getDummyITLTournament() {
        final List<Tournament> tournaments = new ArrayList<>();

        // Add some sample items.
        for (int i = 1; i <= 20; i++) {
            tournaments.add(createDummyITLTournament(i));
        }
        return tournaments;
    }

    public static List<Tournament> getDummyWeekendTournament() {
        final List<Tournament> tournaments = new ArrayList<>();

        // Add some sample items.
        for (int i = 1; i <= 3; i++) {
            tournaments.add(createDummyWeekendTournament(i));
        }
        return tournaments;
    }

    public static List<Tournament> getDummyPastTournament() {
        final List<Tournament> tournaments = new ArrayList<>();

        // Add some sample items.
        for (int i = 1; i <= 20; i++) {
            tournaments.add(createDummyPastTournament(i));
        }
        return tournaments;
    }

    private static RankPlayer createDummyRank(int position) {
        Random random = new Random();
        int rank = random.nextInt(10 - 1 + 1) + 1;
        int points = random.nextInt(2500 - 10 + 1) + 10;
        return new RankPlayer(String.valueOf(position), position, "Item " + position, "Sofia", rank, points);
    }

    private static Tournament createDummyProgressTournament(int position) {
        return new Tournament(String.valueOf(position), position + "th Night Tournament ITL 250", "Diana Tennis Club", "14 Nov 2016", random.nextBoolean());
    }

    private static Tournament createDummyITLTournament(int position) {
        return new Tournament(String.valueOf(position), position + "th Night Tournament ITL 125", "Diana Tennis Club", "14 Nov 2016", random.nextBoolean());
    }

    private static Tournament createDummyWeekendTournament(int position) {
        return new Tournament(String.valueOf(position), position + "th Weekend Tournament", "Diana Tennis Club", "14 Nov 2016", random.nextBoolean());
    }

    private static Tournament createDummyPastTournament(int position) {
        return new Tournament(String.valueOf(position), position + "th Night Tournament ITL 250", "Diana Tennis Club", "14 Nov 2015", random.nextBoolean());
    }

    private static TournamentMatch createDummyMatches(int position, String status) {
        return new TournamentMatch(String.valueOf(position), "Tihomir Zhelev", "Evgeni Manov", null, null, status, "2:1");
    }
}
