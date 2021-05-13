package kmp;

/**
 * @author surui
 * @date 2021/3/16 11:54 PM
 */
public class Kmp {
    public static void main(String[] args) {
        String bigStr = "ababcabcacbab";
        String smallStr = "abcac";
        int bf = bf(bigStr.toCharArray(), smallStr.toCharArray());
        System.out.println(bf);
        getNext("abababcs".toCharArray());
    }

    public static int bf(char S[], char T[]) {
        int i = 0, j = 0;
        // while (S[i] != '\0' && T[j] != '\0') {
        while (i != S.length && j != T.length) {
            if (S[i] == T[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == T.length) return (i - j);     //主串中存在该模式返回下标号
        else return -1;     //主串中不存在该模式
    }


    public static int kmp(char S[], char T[]) {
        int i = 0;
        int j = 0;
        int[] next = getNext(T); //获取next
        while (i < S.length || j < T.length) {
            if (j == -1 || S[i] == T[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == T.length) {
            return i - j;
        } else {
            return -1;
        }

    }

    public static int[] getNext(char T[]) {
        int[] next = new int[T.length];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < T.length) {
            if (j == -1 || T[i] == T[j]) {
                ++i;
                ++j;
                if (i < T.length) {
                    next[i] = j;
                } else {
                    break;
                }
            } else
                j = next[j];
        }
        return next;
    }
}
