import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 练习差分数组
 *
 * @author surui
 * @date 2021/6/24 9:52 下午
 */
public class Huawei0604 {
    public static void main(String[] args) {
        Huawei0604 huawei = new Huawei0604();
        int[][] persons = {{0, 10, 4}, {25, 32, 8}, {11, 20, 8}, {4, 9, 5}, {15, 30, 9}, {32, 33, 9}};
        huawei.findPeriods(persons);
    }

    public int[][] findPeriods(int[][] persons) {
        int maxTime = 0;
        for (int i = 0; i < persons.length; i++) {
            int[] person = persons[i];
            int endTime = person[1];
            maxTime = Math.max(maxTime, endTime);
        }
        int[] offsetPerson = new int[maxTime + 1];
        for (int i = 0; i < persons.length; i++) {
            int[] person = persons[i];
            int beginTime = person[0];
            int endTime = person[1];
            int personCount = person[2];
            offsetPerson[beginTime] += personCount;
            if (endTime + 1 <= maxTime) {
                offsetPerson[endTime + 1] -= personCount;
            }
        }
        int[] countPerTime = new int[offsetPerson.length];
        countPerTime[0] = offsetPerson[0];
        for (int i = 1; i < offsetPerson.length; i++) {
            countPerTime[i] = countPerTime[i - 1] + offsetPerson[i];
        }
        int maxPerson = 0;
        for (int i : countPerTime) {
            maxPerson = Math.max(i, maxPerson);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < countPerTime.length; i++) {
            if (countPerTime[i] == maxPerson) {
                list.add(i);
            }
        }
        List<List<Integer>> outList = new ArrayList<>();
        Stack<Integer> integerStack = new Stack<>();
        /*for (int i = 0; i < list.size(); i++) {
            Integer currInt = list.get(i);
            if (!integerStack.isEmpty()) {
                Integer lastInt = integerStack.pop();
                if (integerStack.isEmpty()) {
                    if (lastInt + 1 == currInt) {
                        integerStack.push(lastInt);
                    } else {
                        List<Integer> interList = new ArrayList<>();
                        interList.add(lastInt);
                        interList.add(lastInt);
                        outList.add(interList);
                    }
                } else {
                    if (lastInt + 1 != currInt) {
                        List<Integer> interList = new ArrayList<>();
                        interList.add(integerStack.pop());
                        interList.add(lastInt);
                        outList.add(interList);
                    }
                }
            }
            integerStack.push(currInt);
        }
        if (!integerStack.isEmpty()) {
            Integer pop = integerStack.pop();
            if (integerStack.isEmpty()) {
                List<Integer> interList = new ArrayList<>();
                interList.add(pop);
                interList.add(pop);
                outList.add(interList);
            } else {
                List<Integer> interList = new ArrayList<>();
                interList.add(pop);
                interList.add(integerStack.pop());
                outList.add(interList);
            }
        }*/
        List<int[]> result = new ArrayList<>();
        int startTime = 0;
        while (startTime <= maxTime) {
            if (countPerTime[startTime] != maxPerson) {
                startTime++;
                continue;
            }
            int endTime = startTime + 1;
            while (endTime <= maxTime) {
                if (countPerTime[endTime] != maxPerson) {
                    break;
                }
                endTime++;
            }
            int[] ints = new int[2];
            ints[0] = startTime;
            ints[1] = endTime - 1;
            result.add(ints);
            startTime = endTime;
        }
        int[][] ints = new int[outList.size()][2];
        for (int i = 0; i < ints.length; i++) {
            int[] anInt = ints[i];
            anInt[0] = outList.get(i).get(0);
            anInt[1] = outList.get(i).get(1);
        }
        return ints;
    }
}
