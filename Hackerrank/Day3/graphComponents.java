

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

class Solution {

    public static ArrayList<Integer>[] graph(int n, int m, InputReader reader) throws IOException {
        ArrayList<Integer> adjList[] = new ArrayList[n];
        for (int j = 0; j < n; j++) {
            adjList[j] = new ArrayList<>();
        }
        for (int j = 0; j < m; j++) {
            int a = reader.readInt();
            int b = reader.readInt();
            adjList[a - 1].add(b - 1);
            adjList[b - 1].add(a - 1);
        }
        return adjList;
    }
    public static ArrayList<Integer> ls = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        InputReader reader = new InputReader(System.in);
        int edge = reader.readInt();
        ArrayList<Integer>[] Adjlis = graph(2 * edge, edge, reader);
        ConnectedCompnent(Adjlis);
//        for (int i = 0; i < ls.size(); i++) {
//            System.out.print(ls.get(i) + " ");
//        }
        System.out.println(Collections.min(ls) + " " + Collections.max(ls));
    }

    public static void ConnectedCompnent(ArrayList<Integer> adjList[]) {
        boolean visited[] = new boolean[adjList.length];
        for (int v = 0; v < adjList.length; v++) {
            visited[v] = false;
        }
        int countcomp = 0;
        for (int i = 0; i < adjList.length; i++) {
            if (!visited[i]) {
                countcomp++;//start of component
                int size = 0;
                LinkedList<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int w = q.poll();
                    size++;//nodes in component
                    for (int j = 0; j < adjList[w].size(); j++) {
                        int x = adjList[w].get(j);
                        if (!visited[x]) {
                            visited[x] = true;
                            q.addLast(x);
                        }
                    }
                }
                if (size != 0 && size != 1) {
                    ls.add(size);
                }

            }
        }
        //  System.out.println("connected component  " + countcomp);

    }

    static final class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() throws IOException {
            if (curChar >= numChars) {
                curChar = 0;
                numChars = stream.read(buf);
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public final int readInt() throws IOException {
            return (int) readLong();
        }

        public final long readLong() throws IOException {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
                if (c == -1) {
                    throw new IOException();
                }
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return negative ? -res : res;
        }

        public final int[] readIntArray(int size) throws IOException {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = readInt();
            }
            return array;
        }

        public final long[] readLongArray(int size) throws IOException {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) {
                array[i] = readLong();
            }
            return array;
        }

        public final String readString() throws IOException {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.append((char) c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}