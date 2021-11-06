package hr.fer.oop.helping;

import java.util.*;

public class Solution implements StudentDatabase {
    Map<String, Map<String, Integer>> rezultati = new HashMap<>();

    @Override
    public void addEntry(String student, String course, int score) {
        Map<String, Integer> ocjenaPredmeta = new HashMap<>();
        ocjenaPredmeta.put(course, score);

        if (!rezultati.containsKey(student)) rezultati.put(student, ocjenaPredmeta);
        else {
            if (rezultati.get(student).containsKey(course)) rezultati.get(student).replace(course, score);
            else rezultati.get(student).put(course, score);
        }
    }

    @Override
    public Integer getScore(String student, String course) {
        if (!rezultati.containsKey(student)) return null;
        if (!rezultati.get(student).containsKey(course)) return null;
        return  rezultati.get(student).get(course);
    }

    @Override
    public Collection<Integer> getNaturallyOrderedScoresByCourse(String course) {
        List<Integer> ocjene = new ArrayList<>();
        for (Map<String, Integer> opp : rezultati.values()) {
            if (opp.containsKey(course)) ocjene.add(opp.get(course));
        }
        Collections.sort(ocjene);
        return ocjene;
    }
}
