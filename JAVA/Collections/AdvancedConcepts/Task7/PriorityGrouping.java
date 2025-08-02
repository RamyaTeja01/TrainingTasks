package Collections.AdvancedConcepts;

import java.util.*;

class PriorityGrouping {
    String name;
    String department;

    PriorityGrouping(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        List<PriorityGrouping> employees = Arrays.asList(
            new PriorityGrouping("John", "HR"),
            new PriorityGrouping("Alice", "IT"),
            new PriorityGrouping("Bob", "HR"),
            new PriorityGrouping("Emma", "Finance")
        );

        Map<String, List<PriorityGrouping>> deptMap = new HashMap<>();

        for (PriorityGrouping e : employees) {
            deptMap.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
        }

        for (String dept : deptMap.keySet()) {
            System.out.println(dept + " => " + deptMap.get(dept));
        }
    }
}

