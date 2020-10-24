import java.util.*;


public class Container <T> implements List<T> {

    private Object[] arr;
    private int size;

    public Container() {
        size = 1;
        arr = new Object[size];
    }

    public T get(int i) {
        try {
            if (i < size && i >= 0) {
                @SuppressWarnings("unchecked") final T e = (T) arr[i];
                return e;
            } else throw new Exception();
        } catch (Exception E) {
            System.out.println("index don't right");
        }
        return null;
    }

    @Override
    public T set(int index, T element) {
        rangeCheck(index);
        T temp = (T) arr[index];
        arr[index] = element;
        return temp;
    }

    @Override
    public void add(int index, T element) {
        rangeCheck(index);
        T temp = (T) arr[index];
        arr[index] = element;
        size++;

    }

    @Override
    public T remove(int index) {
        T delEl = null;
        try {
            rangeCheck(index);
            size--;
            Object[] arrTemp = new Object[size];
            int indexTemp = 0;
            for (int ind = 0; ind < size + 1; ind++) {
                if (ind == index) {
                    delEl = (T) arr[ind];
                    continue;
                }
                arrTemp[indexTemp] = arr[ind];
                indexTemp++;
            }
            arr = arrTemp;

        } catch (IndexOutOfBoundsException e) {
            System.out.println("index don't right");
        }
        return delEl;
    }

    public T remove() {
        T delEl = null;
        try {
            rangeCheck(size - 1);
            size--;
            Object[] arrTemp = new Object[size];
            int indexTemp = 0;
            for (int ind = 0; ind < size + 1; ind++) {
                if (ind == size - 1) {
                    delEl = (T) arr[ind];
                    continue;
                }
                arrTemp[indexTemp] = arr[ind];
                indexTemp++;
            }
            arr = arrTemp;

        } catch (IndexOutOfBoundsException e) {
            System.out.println("index don't right");
        }
        return delEl;
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+ size;
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++) {
            if (o.equals(arr[i])) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int last = -1;
        for(int i = 0; i < size; i++) {
            if (o.equals(arr[i])) last = i;
        }
        return last;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }


    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public int size() {
        return size - 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

//    @Override
//    public boolean equals(Object o) {
//        return (T) o == (T) this;
//    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        for(Object x : arr) {
            if (o.equals(x)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }


    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T value) {
        arr[size - 1] = value;
        size++;
        Object[] arrTemp = new Object[size];
        System.arraycopy(arr, 0, arrTemp, 0, size - 1);
        arr = arrTemp;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }


    @Override
    public void clear() {
        while (size != 1) {
            remove();
        }
    }
}
