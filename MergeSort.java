package ss.week4;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static <E extends Comparable<E>> void mergesort(List<E> list) {
        // List<E> l = new ArrayList<>();
        int n = list.size();
        if (n < 2) {
            return;
        } else {
            int fi = 0;
            int si = 0;
            int mid = (list.size()) / 2; //mid of the list
            List<E> fh = list.subList(0, mid); //defining the first half of the list
            System.out.println(fh);
            mergesort(fh);
            List<E> lh = list.subList(mid, list.size()); // defining the second half of the list
            System.out.println(lh);
            mergesort(lh);
            List<E> l = merge(fh, lh);
            deepcopy(l, list);
            System.out.println("sorted" + list);
        }
    }

    public static <E extends Comparable<E>> List merge(List<E> fh, List<E> lh) {
        ArrayList<E> res = new ArrayList<>();
        int fi = 0;
        int si = 0;
        while (fi <= fh.size() - 1 && si <= lh.size() - 1) {
            if (fh.get(fi).compareTo(lh.get(si)) < 0) {
                res.add(fh.get(fi)); 
                fi = fi + 1;
            } else {
                res.add(lh.get(si));
                si = si + 1;
            }
        }
        while (fi <= fh.size() - 1) {
            res.add(fh.get(fi++));
        }
        while (si <= lh.size() - 1) {
            res.add(lh.get(si++));
        }
        System.out.println("merged sort" + res);
        return res;
    }

    public static <E extends Comparable<E>> void deepcopy(List<E> source, List<E> destination) {
        for (int i = 0; i < destination.size(); i++) {
            if (i < source.size()) {
                destination.set(i, source.get(i));
            }
        }
    }
}


















