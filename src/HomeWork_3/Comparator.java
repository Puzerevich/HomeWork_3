package HomeWork_3;

public class Comparator implements java.util.Comparator<Student> {
    int compareMode = 0;
    public Comparator(int compareMode) {
        this.compareMode = compareMode;
    }

    @Override
    public int compare(Student s1, Student s2) {
        if (s1 == s2) {
            return 0;
        } else if (s1 == null) {
            return -1;
        } else if (s2 == null) {
            return 1;
        } else {
            switch (compareMode) {
                case 0:
                    return s1.getName().compareTo(s2.getName());
                case 1:
                    return s1.getSurname().compareTo(s2.getSurname());
                case 2:
                    return s1.getAge() > s2.getAge() ? 1 : -1;
                case 3:
                    return s1.getAverageScore() > s2.getAverageScore() ? 1 : -1;
            }
        }
        return 0;
    }
}
