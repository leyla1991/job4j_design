package ru.job4j.maps;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double sum = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        sum = sum / (double) count;
        return sum;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0D;
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                if (subject.name() != null) {
                    count++;
                    sum += subject.score();
                }
            }
            Label label = new Label(pupil.name(), sum / (double) count);
            labels.add(label);
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> l = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                l.merge(subject.name(), subject.score(), (oldVal, newVal) -> oldVal + newVal);
            }
            count++;
        }
        for (String s : l.keySet()) {
            int i = l.get(s) / count;
            Label label = new Label(s, i);
            labels.add(label);
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double sum = 0D;
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (subject.name() != null) {
                    sum += subject.score();
                }
            }
            Label label = new Label(pupil.name(), sum);
            labels.add(label);
            sum = 0D;
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }


    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> l = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (!l.containsKey(subject.name())) {
                    l.put(subject.name(), subject.score());
                } else {
                    l.put(subject.name(), l.get(subject.name()) + subject.score());
                }
            }
        }
        for (String s : l.keySet()) {
            Label label = new Label(s, l.get(s));
            labels.add(label);
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}
